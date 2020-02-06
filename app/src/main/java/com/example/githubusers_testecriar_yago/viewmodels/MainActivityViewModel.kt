package com.example.githubusers_testecriar_yago.viewmodels

import android.content.Context
import com.example.githubusers_testecriar_yago.models.User
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.githubusers_testecriar_yago.R
import com.example.githubusers_testecriar_yago.models.UserDataSource

class MainActivityViewModel (val repository: UserDataSource, val context: Context) {

    val users = ObservableArrayList<User>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            users.clear()
            users.addAll(items)
            if (items.isEmpty()) {
                message.set(context.getString(R.string.user_empty))
            }
            loadingVisibility.set(false)
        }, {
            message.set(context.getString(R.string.user_failed))
            loadingVisibility.set(false)
        })
    }

}