package mrpro.samplekotlin.model.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Andrey on 1/4/17.
 */
class TeamsRetrofit {

    var retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("http://api.football-data.org/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()


    fun provideRetrofit(): Retrofit {
        return retrofit
    }
}