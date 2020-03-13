package bug.capitulated.core_common.mvi

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.withLatestFrom
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import kotlin.reflect.KClass

/**
 * Реализация ViewModel в паттерне отображения MVI: ModelViewViewModel (аналог redux)
 *
 * [Intent] - Намерение пользователя, на основе этого намерения формируется запрос в model
 * [Action] - Ответ от модели и формирования на основе типа ответа и самого ответа изменения стейта
 * [State] - Состояние view, состояния одно на одну фичу, как и вся ViewModel одна на фичу
 * [Subscription] - Тоже, что и [Action] только без сохранения значения между сменой конфигурации
 */
abstract class MviViewModel<Intent : Any, Action : Any, State : Any, Subscription : Any>(
    initialState: State
) : ViewModel() {
    
    val subscription: ObservableSource<Subscription>
        get() = subscriptionSubject
    
    val state: ObservableSource<State>
        get() = stateSubject
    
    private val intentsSubject = PublishSubject.create<Intent>()
    private val subscriptionSubject = PublishSubject.create<Subscription>()
    private val stateSubject = BehaviorSubject.create<State>()
    
    private val flows = mutableMapOf<KClass<out Intent>, SwitchableObservable<*>>()
    
    private val disposable = CompositeDisposable()
    
    init {
        stateSubject.onNext(initialState)
        
        disposable += intentsSubject
            .flatWithLatestFrom(state, ::actWithSchedulers)
            .withLatestFrom(state, ::onActionReceived)
            .subscribeBy(onNext = stateSubject::onNext)
    }
    
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
        
        flows.apply {
            map { it.value.dispose() }
            clear()
        }
    }
    
    
    /**
     * Отправляет новое пользовательское намерение
     */
    fun postIntent(intent: Intent) = intentsSubject.onNext(intent)
    
    
    /**
     * Вызывается при отправке очередного [Intent]
     *
     * Далее, на основе интента вызывается какая-то кастомная логика.
     * После получения результата от логики отправляем [Action]
     */
    protected open fun act(state: State, intent: Intent): Observable<out Action> =
        Observable.empty()
    
    /**
     * Принимает [Action], изменяет на его основе [State] и отдаёт его
     */
    protected open fun reduce(oldState: State, action: Action): State = oldState
    
    /**
     * Принимает [Action] и формирует на его основе [Subscription], отдаёт его
     */
    protected open fun publishSubscription(action: Action, state: State): Subscription? = null
    
    
    private fun actWithSchedulers(intent: Intent, state: State) = act(state, intent)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
    
    /**
     * Данная функция позволяет подписываться на один и тот же стрим по несколько раз,
     * избегая множественные подписки, она будет одна
     */
    protected fun <T : Any> Observable<T>.asFlowSource(intentType: KClass<out Intent>): Observable<T> {
        val isFlowLaunched = flows.containsKey(intentType)
        
        if (!isFlowLaunched) {
            flows[intentType] = SwitchableObservable(this)
        }
        
        @Suppress("UNCHECKED_CAST")
        val flow = flows[intentType] as Observable<T>
        flow.switchSource(this)
        
        return if (isFlowLaunched) Observable.empty() else flow
    }
    
    private fun onActionReceived(action: Action, oldState: State): State {
        val newState = reduce(oldState, action)
        val subscription = publishSubscription(action, newState)
        
        subscription?.let { subscriptionSubject.onNext(it) }
        return newState
    }
    
    private inline fun <T, U, R> Observable<T>.flatWithLatestFrom(
        other: ObservableSource<U>,
        crossinline combiner: (T, U) -> ObservableSource<out R>
    ): Observable<R> {
        return withLatestFrom(other, combiner).flatMap { it }
    }
    
}