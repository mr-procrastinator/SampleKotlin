package mrpro.samplekotlin.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.teams_fragment.*
import mrpro.samplekotlin.R
import mrpro.samplekotlin.entities.Team
import mrpro.samplekotlin.misc.extensions.inflate
import mrpro.samplekotlin.ui.adapters.TeamsAdapter
import mrpro.samplekotlin.ui.adapters.misc.OnViewSelectedListener

/**
 * Created by Andrey on 11/29/16.
 */
class TeamsListFragment : Fragment() {

    lateinit var adapter: TeamsAdapter
    lateinit var teams:List<Team>

    private val teamsRecyclerView by lazy {
        teams_fragment_rv
    }


    companion object{
        fun getInstance(teams: List<Team>) : TeamsListFragment {
            var teamsListFragment = TeamsListFragment()
            teamsListFragment.teams = teams
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
        adapter = TeamsAdapter(object : OnViewSelectedListener<Team> {
            override fun onItemSelected(item: Team) {
                openTeamDetails(item)
            }
        })
        adapter.setItems(teams)
        teamsRecyclerView.apply {
            setHasFixedSize(true)
            adapter = this@TeamsListFragment.adapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    fun openTeamDetails(team: Team){
        Toast.makeText(context, team.name, Toast.LENGTH_SHORT).show()
    }
}