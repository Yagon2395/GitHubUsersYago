package com.example.githubusers_testecriar_yago.models.repositories

import com.example.githubusers_testecriar_yago.models.entities.User
import com.example.githubusers_testecriar_yago.models.services.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    // GET user list
    fun getUsers(onResult: (isSuccess: Boolean, response: List<User>?) -> Unit) {

        ApiClient.INSTANCE.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                onResult(false, null)
            }
        })
    }

    companion object {
        private var INSTANCE: UserRepository? = null
        fun getInstance() = INSTANCE
            ?: UserRepository().also {
                INSTANCE = it
            }
    }
}