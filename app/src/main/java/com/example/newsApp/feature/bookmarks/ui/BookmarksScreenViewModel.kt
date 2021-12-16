package com.example.newsApp.feature.bookmarks.ui

import com.example.newsApp.base.BaseViewModel
import com.example.newsApp.base.Event
import com.example.newsApp.feature.bookmarks.domain.BookmarkInteractor

class BookmarksScreenViewModel(
    private val bookmarkInteractor: BookmarkInteractor
) : BaseViewModel<ViewState>() {

    init {
        processUiEvent(DataEvent.GetFavoriteNews)
    }

    override fun initialViewState(): ViewState {
        return ViewState(
            articleFavoriteList = listOf()
        )
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {

            is DataEvent.GetFavoriteNews -> {
                val favoriteList = bookmarkInteractor.getAll()
                return previousState.copy(articleFavoriteList = favoriteList)
            }

            is UiEvent.OnFavoriteClick -> {
                bookmarkInteractor.delete(event.articleDomainModel)
                processDataEvent(DataEvent.GetFavoriteNews)
            }
        }

        return null
    }
}