package com.example.newsApp.feature.main.domain

import com.example.newsApp.base.attempt
import com.example.newsApp.feature.main.data.api.NewsRepository

class NewsInteractor(
    private val newsRepository: NewsRepository
) {

    suspend fun getTopNews() = attempt {
        newsRepository.getTopNews()
    }
}