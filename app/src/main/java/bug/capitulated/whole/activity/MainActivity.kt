package bug.capitulated.whole.activity

import android.os.Bundle
import bug.capitulated.whole.R
import bug.capitulated.whole.navigation.NavigationActivity

class MainActivity : NavigationActivity(R.id.container) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}