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

/**
Written by Muhammad Joe Fachrizal
 **/
class ListHerbAdapter(private val listHerbs: ArrayList<Herb>) : RecyclerView.Adapter<ListHerbAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_herb, parent, false)
        return ListViewHolder(view)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, from, image) = listHerbs[position]
        Glide.with(holder.itemView.context)
            .load(image)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvFrom.text = from

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(
                listHerbs[holder.adapterPosition]
            )
        }
    }

    override fun getItemCount(): Int = listHerbs.size


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Herb)
    }

}