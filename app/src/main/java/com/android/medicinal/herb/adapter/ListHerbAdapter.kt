package com.android.medicinal.herb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.medicinal.herb.R
import com.android.medicinal.herb.model.Herb
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_about.view.*
import kotlinx.android.synthetic.main.activity_about.view.img_item_photo
import kotlinx.android.synthetic.main.item_row_herb.view.*

/**
Written by Muhammad Joe Fachrizal
 **/
class ListHerbAdapter(private val listHerbs: ArrayList<Herb>) :
    RecyclerView.Adapter<ListHerbAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_herb, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listHerbs[position])
    }

    override fun getItemCount(): Int = listHerbs.size


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: Herb) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .apply(RequestOptions().override(55, 55))
                    .into(img_item_photo)
                tv_item_name.text = data.name
                tv_item_from.text = data.from

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