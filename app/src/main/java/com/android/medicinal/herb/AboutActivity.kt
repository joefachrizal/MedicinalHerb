package com.android.medicinal.herb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    val PHOTO_URL: String =
        "https://www.pokemoncenter.com/wcsstore/PokemonCatalogAssetStore/images/catalog/products/P4828/701-03127/P4828_701-03127_01.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        Glide.with(this)
            .load(PHOTO_URL)
            .into(img_item_photo)
    }
}
