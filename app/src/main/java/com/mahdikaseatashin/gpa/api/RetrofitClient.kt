package com.mahdikaseatashin.gpa.api

import com.mahdikaseatashin.gpa.utils.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideForecastApi(get()) }
    single { provideRetrofit() }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideForecastApi(retrofit: Retrofit): RetrofitService =
    retrofit.create(RetrofitService::class.java)


