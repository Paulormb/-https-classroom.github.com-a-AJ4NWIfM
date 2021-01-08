package survey.app.data.interactor

import io.reactivex.Completable
import io.reactivex.Observable
import survey.app.data.api.IApi
import survey.app.data.local.IPreference
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject


class AuthenUseCaseImpl @Inject constructor(
    private val iApi: IApi,
    private val iPref: IPreference
) : AuthenUseCase {

    override fun authen(user: String, pass: String): Observable<Boolean> {
        return iApi.authen(ConcurrentHashMap<String, String>().apply {
            this["username"] = user
            this["password"] = pass
        }).map {
            iPref.token = it.token
            true
        }
    }

    override fun logout(): Completable {
        return Completable.create {
            iPref.token = ""
            it.onComplete()
        }
    }

    override fun checkLogin(): Boolean {
        return iPref.token.isEmpty()
    }
}