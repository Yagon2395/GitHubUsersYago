package com.example.githubusers_testecriar_yago.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers_testecriar_yago.databinding.UserItemBinding
import com.example.githubusers_testecriar_yago.models.AdapterItemsContract
import com.example.githubusers_testecriar_yago.models.User

class UserAdapter(var items: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(),
    AdapterItemsContract {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: UserItemBinding = UserItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(items: List<*>) {
        this.items = items as List<User>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }


    class ViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }
    }

}