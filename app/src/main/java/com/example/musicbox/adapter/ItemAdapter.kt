package com.example.musicbox.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.musicbox.R
import com.example.musicbox.data.model.Song
import com.example.musicbox.ui.MusiclistFragmentDirections

class ItemAdapter(var dataset: List<Song>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val iv_cover = itemView.findViewById<ImageView>(R.id.imageView_cover)
        val tv_title = itemView.findViewById<TextView>(R.id.textView_title)
        val tv_singer = itemView.findViewById<TextView>(R.id.textView_singer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.iv_cover.setImageResource(item.imageSource)
        holder.tv_title.text = item.title
        holder.tv_singer.text = item.singer

        holder.itemView.setOnClickListener {
            var navController = holder.itemView.findNavController()
            navController.navigate(MusiclistFragmentDirections.actionMusiclistFragmentToMusicFragment(item.imageSource, item.title, item.singer, item.length, position))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}