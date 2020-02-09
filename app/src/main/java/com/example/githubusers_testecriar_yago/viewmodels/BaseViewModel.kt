package com.example.githubusers_testecriar_yago.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val empty = MutableLiveData<Boolean>().apply { value = false }

    val dataLoading = MutableLiveData<Boolean>().apply { value = false }

    val toastMessage = MutableLiveData<String>()

    val error = MutableLiveData<Boolean>().apply { value = false }

    val errorMessage = MutableLiveData<String>().apply { value = "Erro de conexão, tente novamente em alguns instantes..." }
}