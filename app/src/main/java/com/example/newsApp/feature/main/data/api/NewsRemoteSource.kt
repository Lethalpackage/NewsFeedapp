package com.example.newsApp.feature.main.data.api

import com.example.newsApp.feature.main.data.model.TopNewsModel

class NewsRemoteSource(
    private val api: NewsApi
) {

    suspend fun getTopNews(): TopNewsModel {
        return api.getTopHeadlines()
    }
}