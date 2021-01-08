package survey.app.data.interactor

import io.reactivex.Observable
import survey.app.data.model.Nest

interface SurveyUseCase {
    fun allNest() : Observable<List<Nest>>
}