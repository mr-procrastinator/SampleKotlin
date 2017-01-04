package mrpro.samplekotlin.di

import android.content.Context
import dagger.Module
import dagger.Provides
import mrpro.samplekotlin.SampleKotlinApplication
import javax.inject.Singleton

/**
 * Created by Andrey on 1/4/17.
 */
@Module
class AppModule(val app: SampleKotlinApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app;
    }

    @Provides
    @Singleton
    fun provideApplication(): SampleKotlinApplication {
        return app;
    }
}