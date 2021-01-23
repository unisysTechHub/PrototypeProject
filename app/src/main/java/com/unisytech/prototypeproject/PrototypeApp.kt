package com.unisytech.prototypeproject

import android.app.Application
import android.content.Context

/**
 * Created by ramesh on 21/01/21.
 */
class PrototypeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext;

    }
    companion object {
      lateinit  var context: Context

    }
}