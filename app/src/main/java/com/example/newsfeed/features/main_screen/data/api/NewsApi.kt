package com.example.newsfeed.features.main_screen.data.api


import com.example.newsfeed.features.main_screen.data.api.model.TopNewsModel
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
interface NewsApi {
    @GET("v2/top-headlines")
  suspend  fun getTopHeadlines(
    @Query("country") country: String = "ru",
    @Query("apiKey")  apiKey: String = "daa5bbe8c37b4154884e261dfa6cb771",


) : TopNewsModel

}