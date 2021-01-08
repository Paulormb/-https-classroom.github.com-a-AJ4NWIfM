package survey.app.apxeaon.view.main

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*
import survey.app.apxeaon.R
import tran.nam.common.ErrorState
import tran.nam.core.view.BaseActivityInjection
import tran.nam.core.viewmodel.IViewLoading
import tran.nam.state.Status
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivityInjection(), IViewLoading {

    @Inject
    lateinit var mViewModel: MainViewModel

    private var navController: NavController? = null

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun init(savedInstanceState: Bundle?) {
        val navHostFragment = nav_fragment as NavHostFragment
        val graphInflater = navHostFragment.navController.navInflater
        val navGraph = graphInflater.inflate(R.navigation.nav_graph)
        navController = navHostFragment.navController

        val destination = if (mViewModel.checkLogin()) {
            R.id.authenFragment
        } else {
            R.id.mainFragment
        }
        navGraph.startDestination = destination
        navController?.graph = navGraph

        setupLoadingDialog()

        mViewModel.goToMain.observe(this, Observer {
            if (it) {
                navController?.navigate(R.id.action_authenFragment_to_mainFragment)
            }
        })

        mViewModel.goToAuthen.observe(this, Observer {
            when(it){
                1 -> {
                    navController?.navigate(R.id.action_mainFragment_to_authenFragment)
                }
                2 -> {
                    navController?.navigate(R.id.action_vandalismFragment_to_authenFragment2)
                }
            }
        })
    }

    fun alertCancelSurvey() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Cancel Survey")
        alertDialog.setMessage("Are you sure you want to cancel this survey and delete survey entries?")
        alertDialog.setCancelable(false)
        alertDialog.setPositiveButton("Yes") { dialog, _ ->
            dialog.dismiss()
            navController?.popBackStack(R.id.mainFragment, false)
        }
        alertDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.show()
    }

    fun alertCancelEvent() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Cancel Event")
        alertDialog.setMessage("Are you sure you want to cancel this event?")
        alertDialog.setCancelable(false)
        alertDialog.setPositiveButton("Yes") { dialog, _ ->
            dialog.dismiss()
            navController?.popBackStack(R.id.msEntriesChooseFragment, false)
        }
        alertDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.show()
    }

    fun alertEndSurvey(logout: Boolean) {
        val df = SimpleDateFormat("HH:mm:ss")
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("End Survey")
        alertDialog.setMessage("Are you sure you want to end this survey at ${df.format(Calendar.getInstance().time)} ?")
        alertDialog.setCancelable(false)
        alertDialog.setPositiveButton("Yes") { dialog, _ ->
            dialog.dismiss()
            if (logout){
                mViewModel.logout(false)
            }
        }
        alertDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.show()
    }

    fun alertCancelEmergency() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Cancel Emergence")
        alertDialog.setMessage("Are you sure you want to cancel this emergence?")
        alertDialog.setCancelable(false)
        alertDialog.setPositiveButton("Yes") { dialog, _ ->
            dialog.dismiss()
            navController?.popBackStack(R.id.msEntriesChooseFragment, false)
        }
        alertDialog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.show()
    }

    fun setupLoadingDialog() {
        mViewModel.loadingDialog.observe(this, Observer {
            it?.run {
                when (it.status) {
                    Status.LOADING -> {
                        showDialogLoading()
                    }
                    Status.SUCCESS -> {
                        hideDialogLoading()
                    }
                    Status.ERROR -> {
                        hideDialogLoading()
                        onShowDialogError(it.errorState)
                    }
                }
            }
        })
    }

    override fun showDialogLoading() {
        showLoadingDialog()
    }

    override fun hideDialogLoading() {
        hideLoadingDialog()
    }

    override fun onShowDialogError(
        error: ErrorState?,
        isFinish: Boolean,
        retry: (() -> Unit)?
    ) {
        alert(error, isFinish, retry)
    }
}
