package survey.app.apxeaon.view.survey.observer

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_observer.*
import survey.app.apxeaon.R
import survey.app.apxeaon.view.main.MainActivity
import common.survey.core.view.BaseFragment

class ObserverFragment : BaseFragment() {

    var list_of_sky = arrayOf("Sky")
    var list_of_precipitation = arrayOf("Precipitation")
    var list_of_wind_intensity = arrayOf("Wind Intensity")
    var list_of_wind_direction = arrayOf("Wind Direction")
    var list_of_surf = arrayOf("Surf")

    override val layoutId: Int
        get() = R.layout.fragment_observer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinner_sky?.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                list_of_sky
            )
        )
        spinner_sky?.setText(list_of_sky[0])

        spinner_precipitation?.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                list_of_precipitation
            )
        )
        spinner_precipitation?.setText(list_of_precipitation[0])

        spinner_wind_intensity?.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                list_of_wind_intensity
            )
        )
        spinner_wind_intensity?.setText(list_of_wind_intensity[0])

        spinner_wind_direction?.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                list_of_wind_direction
            )
        )
        spinner_wind_direction?.setText(list_of_wind_direction[0])

        spinner_surf?.setAdapter(
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                list_of_surf
            )
        )
        spinner_surf.setText(list_of_precipitation[0])

        tv_previous?.setOnClickListener {
            findNavController().popBackStack()
        }

        tv_cancel?.setOnClickListener {
            (activity as? MainActivity)?.alertCancelSurvey()
        }

        tv_next?.setOnClickListener {
            findNavController().navigate(R.id.action_observerFragment_to_msEntriesChooseFragment)
        }
    }
}