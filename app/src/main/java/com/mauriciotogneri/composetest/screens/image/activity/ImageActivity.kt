package com.mauriciotogneri.composetest.screens.image.activity

import android.content.Context
import android.content.Intent
import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.screens.image.state.ImageState
import com.mauriciotogneri.composetest.screens.image.view.ImageView

class ImageActivity : BaseActivity<ImageState, ImageView>() {
    companion object {
        fun intent(url: String, context: Context): Intent {
            val intent = Intent(context, ImageActivity::class.java)
            intent.putExtra("url", url)

            return intent
        }
    }

    override fun createState() = ImageState(intent.getStringExtra("url")!!)

    override fun createView() = ImageView(state)
}