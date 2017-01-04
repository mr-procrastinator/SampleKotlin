package mrpro.samplekotlin.ui.adapters.delagates

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import mrpro.samplekotlin.ui.adapters.misc.AdapterViewItem
import mrpro.samplekotlin.ui.adapters.misc.ViewType
import kotlinx.android.synthetic.main.team_row_item.view.*
import mrpro.samplekotlin.R
import mrpro.samplekotlin.entities.Team
import mrpro.samplekotlin.ui.adapters.misc.OnViewSelectedListener
import mrpro.samplekotlin.misc.extensions.inflate

/**
 * Created by Andrey on 11/29/16.
 */
class TeamViewHolder(parent: ViewGroup?, val listener: OnViewSelectedListener<Team>) : RecyclerView.ViewHolder(parent?.inflate(R.layout.team_row_item)), AdapterViewItem<Team> {

    override fun onBindViewHolder(item: ViewType<Team>) {
        bind(item.getItem())
    }

    fun bind(item: Team) = with(itemView){
            team_row_name.text = item.name;
            setOnClickListener { listener.onItemSelected(item) }
    }
}