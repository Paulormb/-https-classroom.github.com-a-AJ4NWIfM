package survey.app.apxeaon.view.survey.morning

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_morning_survey.*
import survey.app.apxeaon.R
import common.survey.core.view.BaseFragment

class MorningSurveyFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_morning_survey

    var list_of_beachs = arrayOf("Mavrovouni", "Selinitsa", "Vathi", "Valtaki")
    var list_of_sector = arrayOf("East", "West")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterBeach = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            list_of_beachs
        )
        // Set Adapter to Spinner
        spinner_beach?.setAdapter(adapterBeach)
        spinner_beach?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        val adapterSector = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            list_of_sector
        )
        // Set Adapter to Spinner
        spinner_sector?.setAdapter(adapterSector)
        spinner_sector?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        tv_previous?.setOnClickListener {
            findNavController().popBackStack()
        }

        tv_start_survey.setOnClickListener {
            findNavController().navigate(R.id.action_morningSurveyFragment_to_observerFragment)
        }
    }
}