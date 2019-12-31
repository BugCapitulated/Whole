package bug.capitulated.feature_workmanager.presentation

import android.os.Bundle
import android.view.View
import bug.capitulated.core_common.mvi.MviFragment
import bug.capitulated.feature_workmanager.R
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerIntent
import bug.capitulated.feature_workmanager.presentation.mvi.WorkManagerViewState
import kotlinx.android.synthetic.main.workmanager_fragment.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class WorkManagerFragment : MviFragment<WorkManagerIntent, WorkManagerViewState, Nothing>(
    layoutId = R.layout.workmanager_fragment
) {

    override fun provideViewModel(): WorkManagerViewModel = getViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        one_time_work.setOnClickListener {
            postIntent(WorkManagerIntent.StartWork)
        }

        periodic_work.setOnClickListener {
            postIntent(WorkManagerIntent.StartPeriodicWork)
        }
    }

    override fun render(state: WorkManagerViewState) {}

}