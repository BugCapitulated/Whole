package bug.capitulated.core_common.base

import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment(
    @LayoutRes private val layoutId: Int,
    @MenuRes private val menuResource: Int? = null,
    private val hasOptionMenu: Boolean = true
) : Fragment() {

    protected val activity get() = getActivity() as AppCompatActivity
    protected val supportActionBar by lazy { activity.supportActionBar }

    protected val disposable by lazy { CompositeDisposable() }

    protected var menu: Menu? = null

    private val navigator by lazy { activity as BaseNavigator }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (hasOptionMenu) setHasOptionsMenu(true)
    }

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    final override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        this.menu = menu
        super.onCreateOptionsMenu(menu, inflater)
        menuResource?.let { inflater.inflate(it, menu) }
        menu.onCreated()
    }

    final override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onHomeUpPressed()
        }

        menu?.onItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        menu = null
        disposable.clear()
        super.onDestroyView()
    }

    open fun onBackPressed() = finish()

    protected open fun onHomeUpPressed() = finish()

    protected open fun Menu.onCreated() = Unit

    protected open fun Menu.onItemSelected(item: MenuItem) = Unit

    protected fun finish() {
        navigator.closeScreen()
    }

    protected fun Toolbar.init(
        title: String? = null,
        @StringRes titleRes: Int? = null,
        enableArrowUp: Boolean = true
    ) {
        activity.setSupportActionBar(this)
        title?.let { this.title = title }
        titleRes?.let { this.title = getString(titleRes) }
        supportActionBar?.setDisplayHomeAsUpEnabled(enableArrowUp)
    }

    protected companion object {

        /**
         * Прикрепление аргументов из лямбды к фрагменту
         */
        fun <F : BaseFragment> F.withArguments(bundleInitialization: Bundle.() -> Unit): F {
            arguments = Bundle().apply { bundleInitialization(this) }
            return this
        }

    }

}