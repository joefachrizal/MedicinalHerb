package com.android.medicinal.herb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.medicinal.herb.R
import com.android.medicinal.herb.model.Herb
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_grid_layout.view.*

/**
Written by Muhammad Joe Fachrizal
 **/
class GridHerbAdapter(val listHerbs: ArrayList<Herb>) :
    RecyclerView.Adapter<GridHerbAdapter.GridViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_grid_layout, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int = listHerbs.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(listHerbs[position])
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Herb) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .apply(RequestOptions().override(200, 200))
                    .into(img_item_photo)
                title_herb.text = data.name
                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(data)
                }

            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Herb)
    }
}