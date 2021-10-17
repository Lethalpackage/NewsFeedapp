package com.example.newsfeed.features.main_screen.data.api

import com.example.newsfeed.features.main_screen.domain.model.ArticleDomainModel

interface NewsRepo {
    suspend fun getNews(): List<ArticleDomainModel>
}