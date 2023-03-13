package com.timplifier.dokka.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.timplifier.dokka.R

/**
 * [MainActivity] class is used to launch the application.
 */
class MainActivity : AppCompatActivity() {
    /**
     * [onCreate] function is invoked when activity starts.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        someFunction("")
    }

    /**
     * [someFunction] is used to do something
     * @param someParam is used to do something
     * @return Unit
     * @author Timur
     * @since 1.0
     */
    private fun someFunction(someParam: Any) {
        println(someParam)
    }
}