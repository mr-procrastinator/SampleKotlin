package mrpro.samplekotlin.model.api

import mrpro.samplekotlin.entities.TeamsResponse
import rx.Observable

/**
 * Created by Andrey on 1/4/17.
 */
interface TeamsAPI {
    fun getTeams(): Observable<TeamsResponse>
}