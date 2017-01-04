package mrpro.samplekotlin.di.components

import dagger.Component
import mrpro.samplekotlin.di.AppModule
import mrpro.samplekotlin.di.NetworkModule
import mrpro.samplekotlin.model.api.TeamsAPI
import javax.inject.Singleton

/**
 * Created by Andrey on 1/4/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun exposeTeamsAPI(): TeamsAPI
}