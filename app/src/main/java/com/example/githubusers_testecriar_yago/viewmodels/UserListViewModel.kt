package com.example.githubusers_testecriar_yago.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.githubusers_testecriar_yago.models.entities.User
import com.example.githubusers_testecriar_yago.models.repositories.UserRepository


class UserListViewModel : BaseViewModel() {

    val userListLive = MutableLiveData<List<User>>()

    fun load() {
        dataLoading.value = true
        UserRepository.getInstance().getUsers { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                userListLive.value = response
                empty.value = false
            } else {
                error.value = true
                empty.value = true
            }
        }
    }

}