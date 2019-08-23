package com.android.medicinal.herb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_about.*

class AboutAct : AppCompatActivity() {
    val PHOTO_URL: String =
        "https://www.dicoding.com/images/small/avatar/201710122153227b9539ec4f1304132789c4c56dce3fed.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        Glide.with(this)
            .load(PHOTO_URL)
            .into(img_item_photo)
    }
}
