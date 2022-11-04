package com.example.myapplication.presentation.userlist

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.RowUserItemBinding
import com.example.myapplication.domain.models.User

class UserListAdapter(
    private val context: Context,
    private val callback: () -> Unit
) : ListAdapter<User, UserListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            RowUserItemBinding.inflate(LayoutInflater.from(context), parent, false),
            callback
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: RowUserItemBinding,
        private val callback: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            val imageView = binding.imageView
            Glide.with(imageView.context).load(user.thumbnailImage).into(imageView)
            binding.textView.text = user.firstName + " " + user.lastName

            binding.root.setOnClickListener {
                callback()
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = Diff()
    }

    class Diff : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }


}