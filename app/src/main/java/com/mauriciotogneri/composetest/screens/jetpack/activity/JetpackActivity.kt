package com.mauriciotogneri.composetest.screens.jetpack.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mauriciotogneri.composetest.screens.jetpack.view.JetpackView

class JetpackActivity : ComponentActivity() {
    companion object {
        fun intent(param: String, context: Context): Intent {
            val intent = Intent(context, JetpackActivity::class.java)
            intent.putExtra("param", param)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackView()
        }
    }
}