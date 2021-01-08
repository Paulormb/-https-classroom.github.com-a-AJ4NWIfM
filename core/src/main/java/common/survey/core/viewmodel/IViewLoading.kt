package common.survey.core.viewmodel

import common.survey.common.ErrorState

interface IViewLoading : IViewLifecycle {

    fun showDialogLoading()

    fun hideDialogLoading()

    fun onShowDialogError(
        error: ErrorState?,
        isFinish: Boolean = false, retry: (() -> Unit)? = null
    )
}
