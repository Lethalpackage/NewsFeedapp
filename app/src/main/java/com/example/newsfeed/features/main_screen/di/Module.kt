package com.example.newsfeed.features.main_screen.di

import com.example.newsfeed.features.main_screen.ui.MainScreenViewModel
import com.example.newsfeed.features.main_screen.data.api.NewsApi
import com.example.newsfeed.features.main_screen.data.api.NewsRemoteSource
import com.example.newsfeed.features.main_screen.data.api.NewsRepo
import com.example.newsfeed.features.main_screen.data.api.NewsRepoImpl
import com.example.newsfeed.features.main_screen.domain.NewsInteractor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//newsapi.org/v2/everything?q=bitcoin&apiKey=API_KEY
const val BASE_URL = "https://newsapi.org/"

val  mainScreenModule = module{
    viewModel{
        MainScreenViewModel(get <NewsInteractor>())
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<NewsApi> {
        get<Retrofit>().create(NewsApi::class.java)
    }
    single<NewsRemoteSource> {
        NewsRemoteSource(api = get<NewsApi>())
    }
    single<NewsRepo> {
        NewsRepoImpl(get<NewsRemoteSource>())
    }

    single<NewsInteractor> {
        NewsInteractor(get<NewsRepo>())
    }

}
