package com.example.recyclerviewsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.recyclerviewsample.databinding.ListItemBinding

class LinkListAdapter :
    ListAdapter<LinkItemModel, LinkListAdapter.ViewHolder>(DIFF_UTIL_ITEM_CALLBACK) {

    class ViewHolder(
        private val binding: ListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(linkItemModel: LinkItemModel) {
            binding.textView.text = linkItemModel.title
            binding.root.setOnClickListener {
                linkItemModel.clickAction()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_UTIL_ITEM_CALLBACK = object : DiffUtil.ItemCallback<LinkItemModel>() {
            override fun areItemsTheSame(
                oldItem: LinkItemModel,
                newItem: LinkItemModel
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: LinkItemModel,
                newItem: LinkItemModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}