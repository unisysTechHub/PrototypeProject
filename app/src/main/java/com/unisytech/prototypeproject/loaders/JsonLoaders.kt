package com.unisytech.prototypeproject.loaders

import android.content.Context
import com.unisytech.prototypeproject.PrototypeApp
import java.io.IOException
import java.io.InputStream

/**
 * Created by ramesh on 21/01/21.
 */
fun loadApplicationJSON() : String? {
    var json: String? = null
    json = try {
        val  inputStream: InputStream = PrototypeApp.context.assets.open("application.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, Charsets.UTF_8)
    } catch (ex: IOException) {
        ex.printStackTrace()
        throw  ex
    }
    return json
}

