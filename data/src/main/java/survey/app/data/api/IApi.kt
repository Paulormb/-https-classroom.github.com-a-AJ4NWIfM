package survey.app.data.api

import io.reactivex.Observable
import survey.app.data.model.AuthenKey
import survey.app.data.model.Nest
import retrofit2.http.*

interface IApi {

    @POST("/login/")
    @FormUrlEncoded
    fun authen(
        @FieldMap params: Map<String, String>
    ): Observable<AuthenKey>

    @GET("/api/archelon/nest_list")
    fun allNest(): Observable<List<Nest>>
}
