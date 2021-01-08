package survey.app.apxeaon.view.survey.choose

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_add_new_event.*
import survey.app.apxeaon.R
import survey.app.apxeaon.view.main.MainActivity
import survey.app.apxeaon.view.main.MainViewModel
import survey.app.apxeaon.view.survey.emergency.EmergencyFragment.Companion.ARG_TYPE
import tran.nam.core.view.BaseFragment

class AddNewEventChooseFragment : BaseFragment() {

    val mViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override val layoutId: Int
        get() = R.layout.fragment_choose_add_new_event

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_previous?.setOnClickListener {
            findNavController().popBackStack()
        }

        tv_cancel?.setOnClickListener {
            (activity as? MainActivity)?.alertCancelSurvey()
        }

        tv_adult_emergence?.setOnClickListener {
            findNavController().navigate(
                R.id.action_addNewEventChooseFragment_to_emergencyFragment,
                Bundle().apply {
                    putInt(ARG_TYPE, mViewModel.eventCount)
                })
        }
        tv_vandalism?.setOnClickListener {
            findNavController().navigate(
                R.id.action_addNewEventChooseFragment_to_vandalismFragment
            )
        }
    }
}