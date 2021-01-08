package survey.app.apxeaon.view.survey.choose

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_ms_entries.*
import survey.app.apxeaon.R
import survey.app.apxeaon.view.main.MainActivity
import common.survey.core.view.BaseFragment

class MsEntriesChooseFragment : BaseFragment(){

    override val layoutId: Int
        get() = R.layout.fragment_choose_ms_entries

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_new_event?.setOnClickListener {
            findNavController().navigate(R.id.action_msEntriesChooseFragment_to_addNewEventChooseFragment)
        }

        tv_previous?.setOnClickListener {
            findNavController().popBackStack()
        }

        tv_cancel?.setOnClickListener {
            (activity as? MainActivity)?.alertCancelSurvey()
        }
    }
}