package com.achilleasoft.TheAstrology.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.achilleasoft.TheAstrology.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        GlobalScope.launch {
            Thread.sleep(5_000)

            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
