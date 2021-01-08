package survey.app.apxeaon.view.authen

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_authen.*
import survey.app.apxeaon.R
import survey.app.apxeaon.view.main.MainViewModel
import tran.nam.core.view.BaseFragment

class AuthenFragment : BaseFragment() {

    val mViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override val layoutId: Int
        get() = R.layout.fragment_authen

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_login?.setOnClickListener {
            mViewModel.login(edt_user.text.toString(),edt_pass.text.toString())
        }
    }
}