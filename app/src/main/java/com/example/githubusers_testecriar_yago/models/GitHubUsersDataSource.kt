package com.example.githubusers_testecriar_yago.models

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubUsersDataSource(val gitHubUserService: GitHubUserService) : UserDataSource {

    override fun listAll(success: (List<User>) -> Unit, failure: () -> Unit) {
        val call = gitHubUserService.listUsers()
        call.enqueue(object : Callback<List<User>> {

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = mutableListOf<User>()
                    response.body()?.forEach{
                        users.add(it)
                    }
                    success(users)
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable?) {
                failure()
            }
        })
    }
}