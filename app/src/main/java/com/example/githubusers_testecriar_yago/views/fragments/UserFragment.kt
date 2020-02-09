package com.example.githubusers_testecriar_yago.views.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers_testecriar_yago.databinding.FragmentUserBinding
import com.example.githubusers_testecriar_yago.views.adapters.UserAdapter

import com.example.githubusers_testecriar_yago.viewmodels.UserListViewModel
import kotlinx.android.synthetic.main.fragment_user.*

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentUserBinding
    private lateinit var adapter: UserAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentUserBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProviders.of(this@UserFragment).get(UserListViewModel::class.java)
            setLifecycleOwner(viewLifecycleOwner)
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.load()

        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        viewDataBinding.viewmodel?.userListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateUserList(it)
        })
    }

    private fun setupAdapter() {
        val viewmodel = viewDataBinding.viewmodel
        if (viewmodel != null) {
            adapter = UserAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            recycler_view.layoutManager = layoutManager
            recycler_view.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            recycler_view.adapter = adapter
        }
    }

}
