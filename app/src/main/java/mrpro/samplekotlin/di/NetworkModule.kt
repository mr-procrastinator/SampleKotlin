package mrpro.samplekotlin.di

import com.droidcba.kedditbysteps.api.TeamsRetrofitApi
import dagger.Module
import dagger.Provides
import mrpro.samplekotlin.model.api.TeamsAPI
import mrpro.samplekotlin.model.api.TeamsRestRepository
import mrpro.samplekotlin.model.api.TeamsRetrofit
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Andrey on 1/4/17.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return TeamsRetrofit().provideRetrofit()
    }

    @Provides
    @Singleton
    fun provideTeamsAPI(retrofitApi: TeamsRetrofitApi): TeamsAPI {
        return TeamsRestRepository(retrofitApi)
    }

    @Provides
    @Singleton
    fun provideTeamsRetrofitApi(retrofit: Retrofit): TeamsRetrofitApi{
        return retrofit.create(TeamsRetrofitApi::class.java)
    }
}