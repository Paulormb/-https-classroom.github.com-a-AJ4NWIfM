package survey.app.apxeaon.view.main

import androidx.lifecycle.LiveData
import survey.app.data.interactor.AuthenUseCase
import survey.app.data.interactor.SurveyUseCase
import common.survey.common.SingleLiveEvent
import common.survey.core.viewmodel.BaseViewModel
import common.survey.state.Loading
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mUseCaseAuthen: AuthenUseCase,private val mUseSurveyUseCase: SurveyUseCase) : BaseViewModel() {

    var eventCount = 1;

    private val _goToAuthen = SingleLiveEvent<Int>()
    val goToAuthen: LiveData<Int>
        get() = _goToAuthen

    private val _goToMain = SingleLiveEvent<Boolean>()
    val goToMain : LiveData<Boolean>
        get() = _goToMain

    fun login(user : String,pass : String){
        execute<Boolean>(mUseCaseAuthen.authen(user, pass),{
            _goToMain.value = true
        },typeLoading = Loading.LOADING_DIALOG)
    }

    fun logout(fromMain : Boolean = true) {
        execute(mUseCaseAuthen.logout()) {
            _goToAuthen.value = if (fromMain) 1 else 2
        }
    }

    fun checkLogin(): Boolean {
        return mUseCaseAuthen.checkLogin()
    }

    fun updateEvent(){
        if (eventCount > 1)
            return
        eventCount++
    }

    fun resetEvent(){
        eventCount = 1
    }
}