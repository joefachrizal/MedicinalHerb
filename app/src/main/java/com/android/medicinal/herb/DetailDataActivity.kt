package com.android.medicinal.herb

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_data.*
import kotlinx.android.synthetic.main.content_data.*

class DetailDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_data)

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        getData()
    }

    private fun getData() {
        val photo = intent.getStringExtra(EXTRA_IMAGE)
        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)

        Glide.with(this)
            .load(photo)
            .into(image_header)

        title_herb.text = name
        text_detail.text = detail
    }

    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_NAME = "extra_name"
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

}
