package mrpro.samplekotlin.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import mrpro.samplekotlin.ui.adapters.delagates.TeamViewHolder
import mrpro.samplekotlin.ui.adapters.misc.AdapterViewItem
import mrpro.samplekotlin.ui.adapters.misc.OnViewSelectedListener
import mrpro.samplekotlin.ui.adapters.misc.ViewType
import mrpro.samplekotlin.entities.Team
import mrpro.samplekotlin.entities.adapter.TeamViewType
import java.util.*

/**
 * Created by Andrey on 11/29/16.
 */
class TeamsAdapter(val listener: OnViewSelectedListener<Team>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType<Any>> = ArrayList()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        @Suppress("UNCHECKED_CAST")
        holder as AdapterViewItem<Any>
        holder.onBindViewHolder(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        //when for type
        return TeamViewHolder(parent, listener)
    }

    fun setItems(items : List<Team>){
        this.items.clear()
        this.items.addAll(items.map(::TeamViewType))
    }
}
