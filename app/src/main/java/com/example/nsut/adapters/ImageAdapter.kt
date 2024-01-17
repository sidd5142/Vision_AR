//package com.example.nsut.adapters
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import androidx.tracing.R
//import com.bumptech.glide.Glide
//import com.coding.materialcarousel.R
//import com.example.nsut.models.ImageItem
//
//class ImageAdapter : ListAdapter<ImageItem,ImageAdapter.ViewHolder>(DiffCallback()){
//
//    class DiffCallback : DiffUtil.ItemCallback<ImageItem>(){
//        override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//    class ViewHolder(iteView: View): RecyclerView.ViewHolder(iteView){
//        private val imageView = iteView.findViewById<ImageView>(com.example.nsut.R.id.imageView)
//
//
//        fun bindData(item: ImageItem){
//            Glide.with(itemView)
//                .load(item.url)
//                .into(imageView)
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            LayoutInflater.from(parent.context)
//                 .inflate(R.layout.image_item_layout, parent, false)
//        )
//    }
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val imageItem = getItem(position)
//        holder.bindData(imageItem)
//    }
//}

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
