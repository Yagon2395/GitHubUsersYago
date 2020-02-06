package com.example.githubusers_testecriar_yago.views.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.githubusers_testecriar_yago.R
import com.example.githubusers_testecriar_yago.models.GitHubUserService
import com.example.githubusers_testecriar_yago.models.GitHubUsersDataSource
import com.example.githubusers_testecriar_yago.models.UserRepository
import com.example.githubusers_testecriar_yago.views.fragments.UserFragment
import com.example.githubusers_testecriar_yago.viewmodels.MainActivityViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragmentTo(R.id.content_frame, createFragment())
    }

    fun createViewModel(): MainActivityViewModel {
        val retrofit = Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val gitHubUsersDataSource = GitHubUsersDataSource(retrofit.create(GitHubUserService::class.java))
        val repository = UserRepository(gitHubUsersDataSource)
        return MainActivityViewModel(repository, applicationContext)
    }

    fun createFragment(): UserFragment {
        return UserFragment.newInstance(createViewModel())
    }

    fun AppCompatActivity.addFragmentTo(containerId: Int, fragment: Fragment, tag: String = "") {
        supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()
    }
}
