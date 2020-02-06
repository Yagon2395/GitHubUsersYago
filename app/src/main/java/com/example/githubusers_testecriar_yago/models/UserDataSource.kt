package com.example.githubusers_testecriar_yago.models

interface UserDataSource {

    fun listAll(success : (List<User>) -> Unit, failure: () -> Unit)

}