package com.example.flickrbrowser

import android.os.Build
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "BaseActivity"
internal const val FLICKR_QUERY = "FLICKR_QUERY"
internal const val PHOTO_TRANSFER = "PHOTO_TRANSFER"

open class BaseActivity: AppCompatActivity() {

    internal fun activateToolbar(enableHome: Boolean) {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(enableHome)
    }
}