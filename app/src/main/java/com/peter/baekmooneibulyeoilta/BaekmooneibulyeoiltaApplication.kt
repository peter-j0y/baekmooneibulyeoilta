package com.peter.baekmooneibulyeoilta

import android.app.Application
import timber.log.Timber

class BaekmooneibulyeoiltaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}