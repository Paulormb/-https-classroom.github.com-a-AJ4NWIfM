package survey.app.data.interactor

import io.reactivex.Observable
import survey.app.data.api.IApi
import survey.app.data.model.Nest
import javax.inject.Inject


class SurveyUseCaseImpl @Inject constructor(
    private val iApi: IApi
) : SurveyUseCase {

    override fun allNest(): Observable<List<Nest>> {
        return iApi.allNest()
    }
}