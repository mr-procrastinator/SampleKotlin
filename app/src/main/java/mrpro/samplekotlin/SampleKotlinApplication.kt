package mrpro.samplekotlin

import android.app.Application
import mrpro.samplekotlin.di.components.AppComponent
import mrpro.samplekotlin.di.components.DaggerAppComponent

/**
 * Created by Andrey on 1/4/17.
 */
class SampleKotlinApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .build()
    }
}