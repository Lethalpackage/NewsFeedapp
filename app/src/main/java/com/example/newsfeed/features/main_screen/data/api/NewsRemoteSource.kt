package com.example.newsfeed.features.main_screen.data.api


import com.example.newsfeed.features.main_screen.data.api.model.TopNewsModel

class NewsRemoteSource(private val api: NewsApi) {
    suspend fun getNews ():  TopNewsModel = api.getTopHeadlines()
}