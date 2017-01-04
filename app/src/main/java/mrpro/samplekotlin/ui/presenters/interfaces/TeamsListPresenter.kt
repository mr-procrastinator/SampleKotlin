package mrpro.samplekotlin.ui.presenters.interfaces

import mrpro.samplekotlin.ui.presenters.interfaces.Presenter
import mrpro.samplekotlin.ui.views.TeamsListView

/**
 * Created by Andrey on 1/4/17.
 */
interface TeamsListPresenter : Presenter<TeamsListView> {

    fun loadTeams()
}