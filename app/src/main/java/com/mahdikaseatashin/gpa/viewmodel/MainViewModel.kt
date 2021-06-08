package com.mahdikaseatashin.gpa.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahdikaseatashin.gpa.models.NodeModel
import com.mahdikaseatashin.gpa.repository.MainRepository
import kotlinx.coroutines.*
import timber.log.Timber
import java.lang.Exception

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    object AddressList: MutableLiveData<List<NodeModel>>()
    val errorMessage = MutableLiveData<String>()
    val nodeList = MutableLiveData<List<NodeModel>>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getAllMovies(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            try {
                val response = repository.getAllNodes()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        nodeList.postValue(response.body())
                        loading.value = false
                    } else {
                        onError("Error : ${response.message()} ")
                    }
                }
            }catch (e:Exception){
                Timber.e("Error -> $e")
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
