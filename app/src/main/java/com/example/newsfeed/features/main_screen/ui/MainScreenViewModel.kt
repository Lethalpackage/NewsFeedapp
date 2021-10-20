package com.example.newsfeed.features.main_screen.ui

import androidx.lifecycle.ViewModel
import com.example.newsfeed.base.BaseViewModel
import com.example.newsfeed.base.Event
import com.example.newsfeed.features.main_screen.domain.NewsInteractor


class MainScreenViewModel(private val interactor: NewsInteractor) : BaseViewModel<ViewState>() {
    init {
        processDataEvent(DataEvent.OnLoadData)

    }

    override fun initialViewState(): ViewState {
        return ViewState(articleList = listOf(), errorMessage = null, isLoading = true)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.OnLoadData -> {
                interactor.getNews().fold(
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessNewsRequest(articleList = it))
                    },
                    onError = {

                    },

                    )
            }
            is UIEvent.OnArticleClick -> {

            }
            is DataEvent.SuccessNewsRequest -> {
                return previousState.copy(articleList = event.articleList, isLoading = false)
            }
        }
        return null
    }
}