package mrpro.samplekotlin.model.api

import com.droidcba.kedditbysteps.api.TeamsRetrofitApi
import mrpro.samplekotlin.entities.TeamsResponse
import rx.Observable
import javax.inject.Inject

/**
 * Created by Andrey on 1/4/17.
 */
class TeamsRestRepository @Inject constructor(private val retrofit: TeamsRetrofitApi): TeamsAPI {

    override fun getTeams(): Observable<TeamsResponse> {
        return retrofit.getTeams()
    }
}