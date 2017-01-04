package mrpro.samplekotlin.model.interactors

import mrpro.samplekotlin.entities.TeamsResponse
import mrpro.samplekotlin.model.api.TeamsAPI
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Andrey on 1/4/17.
 */
class TeamsInteractor @Inject constructor(val teamsAPI: TeamsAPI) : BaseInteractor<TeamsResponse>() {

    override fun execute(callback: Subscriber<TeamsResponse>) {
        teamsAPI.getTeams().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback)
    }

}