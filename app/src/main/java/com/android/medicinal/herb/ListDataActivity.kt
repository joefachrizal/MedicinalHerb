package com.android.medicinal.herb

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.medicinal.herb.adapter.GridHerbAdapter
import com.android.medicinal.herb.adapter.ListHerbAdapter
import com.android.medicinal.herb.model.HerbDatas
import com.android.medicinal.herb.model.Herb
import kotlinx.android.synthetic.main.activity_list_data.*
import kotlinx.android.synthetic.main.content_list_data.*

class ListDataActivity : AppCompatActivity() {
    private var list: ArrayList<Herb> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data)

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        showRecyclerList()

        rv_list_herb.setHasFixedSize(true)
        list.addAll(HerbDatas.listData)

        mode_tampil.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showRecyclerGrid()
            } else {
                showRecyclerList()
            }
        }
    }

    private fun showRecyclerList() {
        rv_list_herb.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHerbAdapter(list)
        rv_list_herb.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHerbAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Herb) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rv_list_herb.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHerbAdapter(list)
        rv_list_herb.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHerbAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Herb) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(herb: Herb) {
        Toast.makeText(this, "Memuat Data " + herb.name, Toast.LENGTH_SHORT).show()
        val moveWithDataIntent = Intent(this@ListDataActivity, DetailDataActivity::class.java)
        moveWithDataIntent.putExtra(DetailDataActivity.EXTRA_IMAGE, herb.image)
        moveWithDataIntent.putExtra(DetailDataActivity.EXTRA_NAME, herb.name)
        moveWithDataIntent.putExtra(DetailDataActivity.EXTRA_DETAIL, herb.detail)
        startActivity(moveWithDataIntent)
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
