package bug.capitulated.whole.activity

import android.os.Bundle
import bug.capitulated.core_common.mvi.timetravel.DebaggableActivity
import bug.capitulated.core_common.mvi.timetravel.DebuggableView
import bug.capitulated.core_common.mvi.timetravel.TimeTravelView
import bug.capitulated.whole.BuildConfig
import bug.capitulated.whole.R
import bug.capitulated.whole.navigation.NavigationActivity
import io.palaima.debugdrawer.DebugDrawer

class MainActivity : NavigationActivity(R.id.container), DebaggableActivity {
    
    private var _debuggableView: DebuggableView? = null
    override val debuggableView: DebuggableView? get() = _debuggableView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        if (BuildConfig.DEBUG) {
            setupDebugDrawer()
        }
    }
    
    private fun setupDebugDrawer() {
        val timeTravelView = TimeTravelView()
        _debuggableView = timeTravelView
        
        DebugDrawer.Builder(this).modules(
            timeTravelView
        ).build()
    }
    
}