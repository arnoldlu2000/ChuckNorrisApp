package com.example.chucknorrisjokeapp

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import io.reactivex.Single
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface JokeApiService {

    @GET("url_path_extension")
    fun giveMeAJoke(): Single<Joke> {
        @Path("url_path_extension")
    }

    fun retrofitFactory(): JokeApiService {
        val JokeApiServiceFactory = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/random")
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return JokeApiServiceFactory
    }
}