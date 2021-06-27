package com.example.testapplication.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("./svc/movies/v2/reviews/search.json")
    fun getReviews(@Query("api-key") apikey:String) : Single<QuestMovieResponse>
}