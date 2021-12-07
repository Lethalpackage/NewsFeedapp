package com.example.newsfeed.features.main_screen.ui

import com.example.newsfeed.base.Event
import com.example.newsfeed.features.main_screen.data.api.model.ArticleModel
import com.example.newsfeed.features.main_screen.domain.model.ArticleDomainModel

data class ViewState(
    val articleList: List<ArticleDomainModel>,
    val errorMessage: String?,
    val isLoading : Boolean
    )

sealed class UIEvent(): Event{
    class OnArticleClick : UIEvent()
}

sealed class DataEvent(): Event{
    object OnLoadData: DataEvent()
    data class SuccessNewsRequest(val articleList: List<ArticleDomainModel>): DataEvent()
    data class ErrorNewsRequest(val error: Throwable): DataEvent()

}