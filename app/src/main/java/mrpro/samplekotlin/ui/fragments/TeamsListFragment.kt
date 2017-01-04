package mrpro.samplekotlin.ui.fragments

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.teams_fragment.*
import mrpro.samplekotlin.R
import mrpro.samplekotlin.SampleKotlinApplication
import mrpro.samplekotlin.di.components.DaggerTeamsComponent
import mrpro.samplekotlin.entities.Team
import mrpro.samplekotlin.misc.extensions.inflate
import mrpro.samplekotlin.ui.adapters.TeamsAdapter
import mrpro.samplekotlin.ui.adapters.misc.OnViewSelectedListener
import mrpro.samplekotlin.ui.presenters.interfaces.TeamsListPresenter
import mrpro.samplekotlin.ui.views.TeamsListView
import javax.inject.Inject

/**
 * Created by Andrey on 11/29/16.
 */
class TeamsListFragment : Fragment(), TeamsListView {
    lateinit var adapter: TeamsAdapter
    @Inject lateinit var presenter:TeamsListPresenter
    var progressDialog: ProgressDialog? = null

    private val teamsRecyclerView by lazy {
        teams_fragment_rv
    }


    companion object{
        fun getInstance() : TeamsListFragment {
            var teamsListFragment = TeamsListFragment()
        //    teamsListFragment.teams = teams
            return teamsListFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.teams_fragment, false)
        return view

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerTeamsComponent.builder()
                .appComponent(SampleKotlinApplication.appComponent)
                .build().inject(this)
        adapter = TeamsAdapter(object : OnViewSelectedListener<Team> {
            override fun onItemSelected(item: Team) {
                openTeamDetails(item)
            }
        })
        teamsRecyclerView.apply {
            setHasFixedSize(true)
            adapter = this@TeamsListFragment.adapter
            layoutManager = LinearLayoutManager(activity)
        }
        presenter.attachView(this)
    }

    fun openTeamDetails(team: Team){
        Toast.makeText(context, team.name, Toast.LENGTH_SHORT).show()
    }

    override fun showTeams(teams: List<Team>) {
        adapter.setItems(teams)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun showProgressDialog() {
        progressDialog = ProgressDialog(context)
        progressDialog?.setMessage("Loading")
        progressDialog?.show()
    }

    override fun hideProgressDialog() {
        progressDialog?.hide()
    }

}