package com.example.githubusers_testecriar_yago.views.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers_testecriar_yago.databinding.FragmentUserBinding
import com.example.githubusers_testecriar_yago.views.adapters.UserAdapter
import com.example.githubusers_testecriar_yago.models.User

import com.example.githubusers_testecriar_yago.viewmodels.MainActivityViewModel

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    lateinit var viewModel: MainActivityViewModel


    companion object {
        fun newInstance(viewModel: MainActivityViewModel): UserFragment {
            val fragment = UserFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentUserBinding = FragmentUserBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerView.adapter = UserAdapter(emptyList<User>())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }


}
