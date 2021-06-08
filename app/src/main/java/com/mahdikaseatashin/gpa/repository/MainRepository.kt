package com.mahdikaseatashin.gpa.repository

import com.mahdikaseatashin.gpa.api.RetrofitService

class MainRepository constructor (private val retrofitService: RetrofitService) {

    suspend fun getAllNodes() = retrofitService.getAllNodes()

}
