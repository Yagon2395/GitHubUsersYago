package com.example.githubusers_testecriar_yago.views.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers_testecriar_yago.models.AdapterItemsContract

class BindingAdapters {

    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun setItems(recyclerView: RecyclerView, list: List<Any>) {

            recyclerView.adapter.let {
                if (it is AdapterItemsContract) {
                    it.replaceItems(list)
                }
            }
        }
    }
}