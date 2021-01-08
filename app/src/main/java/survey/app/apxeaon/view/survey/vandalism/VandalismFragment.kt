package survey.app.apxeaon.view.survey.vandalism

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_vadalism.*
import survey.app.apxeaon.R
import survey.app.apxeaon.view.main.MainActivity
import tran.nam.core.view.BaseFragment

class VandalismFragment : BaseFragment() {

    var list_of_nest = arrayOf("Choose Nest")

    override val layoutId: Int
        get() = R.layout.fragment_vadalism

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinner_nest?.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                list_of_nest
            )
        )
        spinner_nest.setText(list_of_nest[0])

        tv_cancel?.setOnClickListener {
            (activity as? MainActivity)?.alertCancelEvent()
        }

        tv_next?.setOnClickListener {
            (activity as? MainActivity)?.alertEndSurvey(true)
        }
    }
}