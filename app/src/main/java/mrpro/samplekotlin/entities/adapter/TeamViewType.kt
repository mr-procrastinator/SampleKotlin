package mrpro.samplekotlin.entities.adapter

import mrpro.samplekotlin.ui.adapters.misc.AdapterConstants
import mrpro.samplekotlin.ui.adapters.misc.ViewType
import mrpro.samplekotlin.entities.Team

/**
 * Created by Andrey on 12/15/16.
 */
class TeamViewType(element : Team): ViewType<Team> {
    private val i : Team = element

    override fun getItem() = i

    override fun getViewType() = AdapterConstants.TEAM

}