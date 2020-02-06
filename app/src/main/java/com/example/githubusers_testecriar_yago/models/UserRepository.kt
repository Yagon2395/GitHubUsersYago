package com.example.githubusers_testecriar_yago.models

class UserRepository (private val userDataSource: UserDataSource) : UserDataSource {

    override fun listAll(success: (List<User>) -> Unit, failure: () -> Unit) {
        userDataSource.listAll(success, failure)
    }
}