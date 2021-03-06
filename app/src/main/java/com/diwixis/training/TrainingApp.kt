package com.diwixis.training

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 *
 *
 * @author П. Густокашин (Diwixis)
 */
class TrainingApp : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@TrainingApp)
            fragmentFactory()
            modules(appModule, viewModels)
        }
    }
}