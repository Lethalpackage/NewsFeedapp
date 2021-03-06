package com.example.newsApp.feature.main.ui

import com.example.newsApp.base.Event
import com.example.newsApp.feature.main.domain.model.ArticleDomainModel

data class ViewState(
    val articleList: List<ArticleDomainModel>,
    val favoriteList: List<ArticleDomainModel>,
    val searchResult: List<ArticleDomainModel>,
    val isLoading: Boolean,
    val errorMessage: String?,
    val isSearchVisible: Boolean,
    val searchText: String
)

sealed class UiEvent : Event {
    object GetCurrentNews : UiEvent()
    object OnSearchClick : UiEvent()

    data class OnSearchTextInput(
        val searchText: String
    ) : UiEvent()

    data class OnFavoriteClick(
        val articleDomainModel: ArticleDomainModel,
        val isFavorite: Boolean
    ) : UiEvent()
}

sealed class DataEvent : Event {
    object OnLoadData : DataEvent()
    object OnLoadFavoriteData : DataEvent()
    data class SuccessNewsRequest(val articleList: List<ArticleDomainModel>) : DataEvent()
    data class ErrorNewsRequest(val error: String) : DataEvent()
}