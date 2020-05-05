package bug.capitulated.whole.activity

import android.os.Bundle
import bug.capitulated.whole.R
import bug.capitulated.whole.navigation.NavigationActivity
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class MainActivity : NavigationActivity(R.id.container) {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    
}