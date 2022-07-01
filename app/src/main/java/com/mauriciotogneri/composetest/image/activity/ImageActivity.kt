package com.mauriciotogneri.composetest.image.activity

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.counter.state.CounterState
import com.mauriciotogneri.composetest.image.state.ImageState
import com.mauriciotogneri.composetest.image.view.ImageView
import kotlin.reflect.KClass

class ImageActivity : BaseActivity<ImageState, ImageView>() {
    companion object {
        fun intent(url: String, context: Context): Intent {
            val intent = Intent(context, ImageActivity::class.java)
            intent.putExtra("url", url)

            return intent
        }
    }

    override fun createState() = ImageState.create(this, intent.getStringExtra("url")!!)

    override fun createView() = ImageView(state)
}