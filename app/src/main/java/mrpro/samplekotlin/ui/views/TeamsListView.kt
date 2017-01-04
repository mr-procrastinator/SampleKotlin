package mrpro.samplekotlin.ui.views

import mrpro.samplekotlin.entities.Team

/**
 * Created by Andrey on 1/4/17.
 */
interface TeamsListView : View {
    fun showProgressDialog()
    fun showTeams(teams: List<Team>)
    fun hideProgressDialog()
}