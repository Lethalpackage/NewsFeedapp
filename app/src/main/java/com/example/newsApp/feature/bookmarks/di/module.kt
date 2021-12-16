package com.example.newsApp.feature.bookmarks.di

import com.example.newsApp.feature.bookmarks.data.BookmarksRepository
import com.example.newsApp.feature.bookmarks.data.BookmarksRepositoryImpl
import com.example.newsApp.feature.bookmarks.domain.BookmarkInteractor
import com.example.newsApp.feature.bookmarks.ui.BookmarksScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val bookmarkModule = module {

    single<BookmarksRepository> {
        BookmarksRepositoryImpl(bookmarksDao = get())
    }

    single {
        BookmarkInteractor(bookmarkRepository = get())
    }

    viewModel{
        BookmarksScreenViewModel(bookmarkInteractor = get())
    }
}