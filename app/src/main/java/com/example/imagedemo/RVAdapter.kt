package com.example.imagedemo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagedemo.databinding.ImageLayoutBinding

class RVAdapter(private var imageList : ArrayList<Photo>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    private var photoList = ArrayList<Photo>()

    init {
        photoList = imageList
    }

    fun setPhotoList(list: ArrayList<Photo>){
        this.photoList = list
        notifyDataSetChanged()
    }


    class ViewHolder(val binding: ImageLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ImageLayoutBinding.inflate(
            LayoutInflater.from(
                parent.context
            )
        )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val url = photoList[position].url_s
        Glide.with(holder.itemView)
            .load(url)
            .into(holder.binding.imageView)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

}