package com.android.medicinal.herb

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.android.medicinal.herb.databinding.ActivityDetailDataBinding
import com.android.medicinal.herb.model.Herb
import com.bumptech.glide.Glide

class DetailDataActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        getData()
    }

    private fun getData() {
        val data = intent.getParcelableExtra(EXTRA_DATA) as Herb

        Glide.with(this)
            .load(data.image)
            .into(binding.imageHeader)

        binding.titleHerb.text = data.name
        binding.textDetail.text = data.detail
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
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
