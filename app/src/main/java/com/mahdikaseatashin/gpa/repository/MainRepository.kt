package com.mahdikaseatashin.gpa.repository

import com.mahdikaseatashin.gpa.api.RetrofitService
import org.koin.dsl.module

val mainRepositoryModule = module {
    factory { MainRepository(get()) }
}

open class MainRepository constructor (private val retrofitService: RetrofitService) {
    suspend fun getAllNodes() = retrofitService.getAllNodes()
}
