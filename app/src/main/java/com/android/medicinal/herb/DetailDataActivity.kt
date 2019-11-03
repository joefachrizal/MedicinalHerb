package com.android.medicinal.herb

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_data.*
import kotlinx.android.synthetic.main.content_data.*

class DetailDataActivity : AppCompatActivity() {

    private lateinit var titleName: TextView
    private lateinit var detailText: TextView
    private lateinit var imageHeader: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_data)

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        imageHeader = image_header
        titleName = title_herb
        detailText = text_detail

        getData()
    }

    private fun getData() {
        val photo = intent.getStringExtra(EXTRA_IMAGE)
        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)

        Glide.with(this)
            .load(photo)
            .into(imageHeader)

        titleName.text = name
        detailText.text = detail
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
