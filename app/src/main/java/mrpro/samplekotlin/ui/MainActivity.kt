package mrpro.samplekotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import mrpro.samplekotlin.R
import mrpro.samplekotlin.entities.Team
import mrpro.samplekotlin.ui.fragments.TeamsListFragment

class MainActivity : AppCompatActivity() {
    val teams: List<Team> = mutableListOf(Team("Arcenal"), Team("Real Madrid"),
            Team("Rostov"), Team("Manchester United"), Team("Manchester City"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.activity_main, TeamsListFragment.getInstance(teams))
        transaction.commitAllowingStateLoss()
    }
}
