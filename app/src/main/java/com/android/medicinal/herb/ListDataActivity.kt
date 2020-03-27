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
import com.android.medicinal.herb.databinding.ActivityListDataBinding
import com.android.medicinal.herb.model.HerbDatas
import com.android.medicinal.herb.model.Herb

class ListDataActivity : AppCompatActivity() {
    private var list: ArrayList<Herb> = arrayListOf()
    private lateinit var binding : ActivityListDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }

        showRecyclerList()

        binding.rvListHerb.setHasFixedSize(true)
        list.addAll(HerbDatas.listData)

        binding.modeTampil.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showRecyclerGrid()
            } else {
                showRecyclerList()
            }
        }
    }

    private fun showRecyclerList() {
        binding.rvListHerb.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHerbAdapter(list)
        binding.rvListHerb.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHerbAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Herb) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        binding.rvListHerb.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHerbAdapter(list)
        binding.rvListHerb.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHerbAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Herb) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(herb: Herb) {
        Toast.makeText(this, "Memuat Data " + herb.name, Toast.LENGTH_SHORT).show()
        val moveWithDataIntent = Intent(this@ListDataActivity, DetailDataActivity::class.java)
        moveWithDataIntent.putExtra(DetailDataActivity.EXTRA_DATA, herb)
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
