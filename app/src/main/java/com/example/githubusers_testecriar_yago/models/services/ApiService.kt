package com.example.githubusers_testecriar_yago.models.services

import com.example.githubusers_testecriar_yago.models.entities.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}