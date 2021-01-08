package survey.app.data.interactor

import io.reactivex.Completable
import io.reactivex.Observable

interface AuthenUseCase {
    fun authen(user: String, pass: String): Observable<Boolean>
    fun logout(): Completable
    fun checkLogin(): Boolean
}