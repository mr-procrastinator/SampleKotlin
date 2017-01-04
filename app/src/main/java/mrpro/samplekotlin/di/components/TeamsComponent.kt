package mrpro.samplekotlin.di.components

import dagger.Component
import mrpro.samplekotlin.di.interfaces.PerFragment
import mrpro.samplekotlin.di.ui.TeamsListModule
import mrpro.samplekotlin.ui.fragments.TeamsListFragment

/**
 * Created by Andrey on 1/4/17.
 */
@PerFragment
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(TeamsListModule::class))
interface TeamsComponent {
    fun inject(teamsListFragment: TeamsListFragment)
}