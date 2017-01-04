package mrpro.samplekotlin.ui.presenters

import mrpro.samplekotlin.entities.TeamsResponse
import mrpro.samplekotlin.model.interactors.TeamsInteractor
import mrpro.samplekotlin.ui.presenters.interfaces.TeamsListPresenter
import mrpro.samplekotlin.ui.views.TeamsListView
import rx.Subscriber
import javax.inject.Inject

/**
 * Created by Andrey on 1/4/17.
 */
class TeamsListPresenterImpl @Inject constructor(val teamsInteractor: TeamsInteractor): TeamsListPresenter {
    var teamsListView: TeamsListView? = null

    override fun loadTeams() {
        teamsListView?.showProgressDialog()
        teamsInteractor.execute(object: Subscriber<TeamsResponse>(){
            override fun onError(e: Throwable?) {
                e?.printStackTrace()
                teamsListView?.hideProgressDialog()
            }

            override fun onCompleted() {
            }

            override fun onNext(t: TeamsResponse?) {
                teamsListView?.hideProgressDialog()
                val teams = t?.teams ?: arrayListOf()
                teamsListView?.showTeams(teams)
            }
        })
    }

    override fun detachView() {
        teamsListView = null
    }


    override fun attachView(view: TeamsListView) {
        teamsListView = view
        loadTeams()
    }

}