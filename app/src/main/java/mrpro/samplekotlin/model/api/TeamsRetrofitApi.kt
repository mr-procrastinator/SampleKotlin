package com.droidcba.kedditbysteps.api

import mrpro.samplekotlin.entities.TeamsResponse
import retrofit2.http.GET
import rx.Observable

interface TeamsRetrofitApi {
    @GET("competitions/405/teams")
    fun getTeams(): Observable<TeamsResponse>
}