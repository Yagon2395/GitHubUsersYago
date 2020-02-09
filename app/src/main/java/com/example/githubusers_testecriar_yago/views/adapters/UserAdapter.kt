package com.example.githubusers_testecriar_yago.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers_testecriar_yago.BR
import com.example.githubusers_testecriar_yago.R
import com.example.githubusers_testecriar_yago.databinding.UserItemBinding
import com.example.githubusers_testecriar_yago.models.entities.User
import com.example.githubusers_testecriar_yago.viewmodels.UserListViewModel

class UserAdapter(private val userListViewModel: UserListViewModel) : RecyclerView.Adapter<UserAdapter.UserListViewHolder>(){

    var userList: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = UserItemBinding.inflate(inflater, parent, false)
        return UserListViewHolder(dataBinding, userListViewModel)
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.setup(userList[position])
    }

    fun updateUserList(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    class UserListViewHolder constructor(private val dataBinding: ViewDataBinding, private val userListViewModel: UserListViewModel)
        : RecyclerView.ViewHolder(dataBinding.root) {

        fun setup(itemData: User) {
            dataBinding.setVariable(BR.user, itemData)
            dataBinding.executePendingBindings()

            itemView.setOnClickListener {
                val bundle = bundleOf("user" to itemData)
                itemView.findNavController()
                    .navigate(R.id.action_userListFragment_to_userDetailFragment, bundle)

            }
        }

    }

}