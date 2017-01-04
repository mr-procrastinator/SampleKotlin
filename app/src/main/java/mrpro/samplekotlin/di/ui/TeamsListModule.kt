package mrpro.samplekotlin.di.ui

import dagger.Module
import dagger.Provides
import mrpro.samplekotlin.di.interfaces.PerFragment
import mrpro.samplekotlin.model.interactors.TeamsInteractor
import mrpro.samplekotlin.ui.presenters.TeamsListPresenterImpl
import mrpro.samplekotlin.ui.presenters.interfaces.TeamsListPresenter

/**
 * Created by Andrey on 1/4/17.
 */
@Module
class TeamsListModule {

//    @Provides
//    @PerFragment
//    fun provideTeamsInteractor(teamsAPI: TeamsAPI): TeamsInteractor{
//        return TeamsInteractor(teamsAPI)
//    }

    @PerFragment
    @Provides
    fun provideTeamsListPresenter(teamsInteractor: TeamsInteractor): TeamsListPresenter{
        return TeamsListPresenterImpl(teamsInteractor)
    }

}