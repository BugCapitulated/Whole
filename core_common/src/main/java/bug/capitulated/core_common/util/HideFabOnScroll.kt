package bug.capitulated.core_common.util

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HideFabOnScroll(context: Context, attrs: AttributeSet) : FloatingActionButton.Behavior() {

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        directTargetChild: View,
        target: View,
        axes: Int
    ): Boolean {
        return true
    }

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: FloatingActionButton,
        dependency: View
    ): Boolean {
        return dependency is RecyclerView
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        fab: FloatingActionButton,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
        super.onNestedScroll(
            coordinatorLayout,
            fab,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type
        )

        if (dyConsumed > 0 && fab.isVisible) {
            fab.hideWithAnimation()
        } else if (dyConsumed < 0 && fab.isInvisible) {
            fab.show()
        }
    }

}

fun FloatingActionButton.hideWithAnimation() {
    onHidden { isInvisible = true }
}

fun FloatingActionButton.finallyHideWithAnimation() {
    if (isInvisible) isVisible = false
    onHidden { isVisible = false }
}

fun FloatingActionButton.onHidden(callback: (FloatingActionButton?) -> Unit) {
    hide(object : FloatingActionButton.OnVisibilityChangedListener() {
        override fun onHidden(fab: FloatingActionButton?) {
            super.onHidden(fab)
            callback.invoke(fab)
        }
    })
}