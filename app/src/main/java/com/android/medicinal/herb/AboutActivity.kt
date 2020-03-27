package com.android.medicinal.herb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.medicinal.herb.databinding.ActivityAboutBinding
import com.bumptech.glide.Glide

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    val PHOTO_URL: String =
        "https://www.pokemoncenter.com/wcsstore/PokemonCatalogAssetStore/images/catalog/products/P4828/701-03127/P4828_701-03127_01.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load(PHOTO_URL)
            .into(binding.imgItemPhoto)
    }
}
