package survey.app.apxeaon.view.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import survey.app.apxeaon.R
import common.survey.core.view.BaseFragment

class MainFragment : BaseFragment() {

    val mViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_start_survey?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_morningSurveyFragment)
        }

        tv_logout?.setOnClickListener {
            mViewModel.logout()
        }
    }
}