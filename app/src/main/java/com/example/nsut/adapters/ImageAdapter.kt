package com.example.nsut.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nsut.R  // Correct import for your app's R class
import com.example.nsut.models.ImageItem

class ImageAdapter : ListAdapter<ImageItem, ImageAdapter.ViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<ImageItem>() {
        override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        fun bindData(item: ImageItem) {
            Glide.with(itemView)
                .load(item.url)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.image_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageItem = getItem(position)
        holder.bindData(imageItem)
    }
}
//
//package com.example.nsut.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.nsut.databinding.ItemImageBinding
//import com.example.nsut.models.ImageItem
//
//class ImageAdapter : ListAdapter<ImageItem, ImageAdapter.ImageViewHolder>(DiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
//        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ImageViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
//        val currentItem = getItem(position)
//        holder.bind(currentItem)
//    }
//
//    class ImageViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(imageItem: ImageItem) {
//            binding.imageView.setImageResource(imageItem.imageResourceId)
//        }
//    }
//
//    private class DiffCallback : DiffUtil.ItemCallback<ImageItem>() {
//        override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
//            return oldItem == newItem
//        }
//    }
//}
//
