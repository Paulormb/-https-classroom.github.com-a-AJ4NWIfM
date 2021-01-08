package survey.app.apxeaon.view.survey.emergency

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_complete_emergency.*
import survey.app.apxeaon.R
import survey.app.apxeaon.view.main.MainActivity
import survey.app.apxeaon.view.main.MainViewModel
import common.survey.core.view.BaseFragment

class CompleteEmergencyFragment : BaseFragment() {

    val mViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override val layoutId: Int
        get() = R.layout.fragment_complete_emergency

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_previous?.setOnClickListener {
            findNavController().popBackStack()
        }

        tv_cancel?.setOnClickListener {
            mViewModel.resetEvent()
            (activity as? MainActivity)?.alertCancelEmergency()
        }

        tv_next?.setOnClickListener {
            mViewModel.updateEvent()
            findNavController().popBackStack(R.id.msEntriesChooseFragment, false)
        }
    }
}