package com.example.newsApp.feature.main.di

import com.example.newsApp.feature.main.data.api.NewsApi
import com.example.newsApp.feature.main.data.api.NewsRemoteSource
import com.example.newsApp.feature.main.data.api.NewsRepository
import com.example.newsApp.feature.main.data.api.NewsRepositoryImpl
import com.example.newsApp.feature.main.domain.NewsInteractor
import com.example.newsApp.feature.main.ui.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainScreenModule = module {

    single {
        get<Retrofit>().create(NewsApi::class.java)
    }

    single {
        NewsRemoteSource(api = get())
    }

    single<NewsRepository> {
        NewsRepositoryImpl(newsRemoteSource = get())
    }

    single {
        NewsInteractor(newsRepository = get())
    }

    viewModel {
        MainScreenViewModel(newsInteractor = get(), bookMarkInteractor = get())
    }
}