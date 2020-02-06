package com.example.githubusers_testecriar_yago.models

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface GitHubUserService {
    @GET("users")
    fun listUsers(): Call<List<User>>
}