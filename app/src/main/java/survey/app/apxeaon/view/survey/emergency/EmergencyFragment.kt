package survey.app.apxeaon.view.survey.emergency

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_emergency.*
import survey.app.apxeaon.R
import survey.app.apxeaon.view.main.MainActivity
import common.survey.core.view.BaseFragment

class EmergencyFragment : BaseFragment() {

    companion object {
        const val ARG_TYPE = "arg_type emergency"
    }

    private var isSelected = false
    private var count = 0
    private var listAttempts = mutableListOf<String>()

    override val layoutId: Int
        get() = R.layout.fragment_emergency

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_cancel?.setOnClickListener {
            (activity as? MainActivity)?.alertCancelEmergency()
        }

        listAttempts.clear()
        val type = arguments?.getInt(ARG_TYPE)
        tv_number?.text = "$type"
        when (type) {
            1 -> {
                count = 1
                tv_na?.setOnClickListener {
                    if (count == 0 || isSelected || listAttempts.contains(tv_na?.text?.toString()))
                        return@setOnClickListener
                    isSelected = true
                    tv_na?.isSelected = true
                }
            }
            else -> {
                count = 3
                tv_bp?.setOnClickListener {
                    if (count == 0 || isSelected || listAttempts.contains(tv_bp?.text?.toString()))
                        return@setOnClickListener
                    isSelected = true
                    tv_bp?.isSelected = true
                }
                tv_aec?.setOnClickListener {
                    if (count == 0 || isSelected || listAttempts.contains(tv_aec?.text?.toString()))
                        return@setOnClickListener
                    isSelected = true
                    tv_aec?.isSelected = true
                }
                tv_swim_bp?.setOnClickListener {
                    if (count == 0 || isSelected || listAttempts.contains(tv_swim_bp?.text?.toString()))
                        return@setOnClickListener
                    isSelected = true
                    tv_swim_bp?.isSelected = true
                }
            }
        }
        iv_add?.setOnClickListener {
            if (count == 0 || !isSelected) {
                return@setOnClickListener
            }
            if (tv_na?.isSelected == true) {
                tv_na?.text?.toString()?.run {
                    listAttempts.add(this)
                }
            }
            if (tv_bp?.isSelected == true) {
                tv_bp?.text?.toString()?.run {
                    listAttempts.add(this)
                }
            }
            if (tv_aec?.isSelected == true) {
                tv_aec?.text?.toString()?.run {
                    listAttempts.add(this)
                }
            }
            if (tv_swim_bp?.isSelected == true) {
                tv_swim_bp?.text?.toString()?.run {
                    listAttempts.add(this)
                }
            }
            tv_contain_stamp.text = getTextAttempt()
            tv_na?.isSelected = false
            tv_bp?.isSelected = false
            tv_aec?.isSelected = false
            tv_swim_bp?.isSelected = false
            count--
            tv_attempt.text = "${listAttempts.size}"
            isSelected = false
        }
        tv_clear?.setOnClickListener {
            if (listAttempts.size == 0)
                return@setOnClickListener
            count++
            listAttempts.removeAt(listAttempts.size - 1)
            tv_contain_stamp.text = getTextAttempt()
            tv_attempt.text = "${listAttempts.size}"
        }

        tv_next.setOnClickListener {
            if (count == 0){
                findNavController().navigate(R.id.action_emergencyFragment_to_completeEmergencyFragment)
            } else
                Toast.makeText(context,"Please choose time stamp",Toast.LENGTH_SHORT).show()
        }
    }

    fun getTextAttempt(): String {
        if (listAttempts.size == 0)
            return ""
        return listAttempts.joinToString("-")
    }
}