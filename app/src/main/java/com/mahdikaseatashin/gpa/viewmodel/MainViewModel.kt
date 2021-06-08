package com.mahdikaseatashin.gpa.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahdikaseatashin.gpa.models.NodeModel
import com.mahdikaseatashin.gpa.repository.MainRepository
import kotlinx.coroutines.*

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val nodeList = MutableLiveData<List<NodeModel>>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.getAllNodes()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    nodeList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}
