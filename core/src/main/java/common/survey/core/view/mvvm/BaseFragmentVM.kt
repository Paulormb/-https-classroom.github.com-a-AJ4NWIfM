/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package common.survey.core.view.mvvm

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import common.survey.common.autoCleared
import common.survey.core.view.BaseFragmentInjection
import common.survey.core.viewmodel.BaseViewModel
import common.survey.core.viewmodel.IViewLoading
import common.survey.state.Status.*
import common.survey.common.ErrorState
import common.survey.common.Logger
import javax.inject.Inject


abstract class BaseFragmentVM<V : ViewDataBinding, VM : BaseViewModel> : BaseFragmentInjection(),
    IViewLoading {

    @Inject
    lateinit var mViewModel: VM

    var mViewDataBinding by autoCleared<V>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mViewModel.onAttach(this)
    }

    override fun onInitialized(bundle: Bundle?, isRefresh: Boolean) {
        Logger.debug("Lifecycle - onInitialized ${javaClass.name}")
        mViewModel.onInitialized(bundle, isRefresh)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLoadingDialog()
    }

    open fun setupLoadingDialog() {
        mViewModel.loadingDialog.observe(viewLifecycleOwner, Observer {
            it?.run {
                when (it.status) {
                    LOADING -> {
                        showDialogLoading()
                    }
                    SUCCESS -> {
                        hideDialogLoading()
                    }
                    ERROR -> {
                        hideDialogLoading()
                        onShowDialogError(it.errorState)
                    }
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Logger.debug("Lifecycle - onCreateView ${javaClass.name}")
        mViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        initToolbar(arguments)
        return mViewDataBinding?.root
    }

    override fun onResume() {
        super.onResume()
        Logger.debug("onResume - ${javaClass.name}")
        mViewModel.onResume(arguments)
    }

    override fun onPause() {
        super.onPause()
        mViewModel.onPause(arguments)
    }

    override fun onDestroy() {
        this.mViewDataBinding?.unbind()
        super.onDestroy()
    }

    override fun showDialogLoading() {
        showLoadingDialog()
    }

    override fun hideDialogLoading() {
        hideLoadingDialog()
    }

    override fun onShowDialogError(
        error: ErrorState?,
        isFinish: Boolean, retry: (() -> Unit)?
    ) {
        showAlert(error, isFinish, retry,{
            callbackDismissAlert(error?.code)
        })
    }

    open fun callbackDismissAlert(codeError: Int?) {}
}
