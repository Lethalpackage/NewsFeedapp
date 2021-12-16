package com.example.newsApp.feature.main.data.model

import com.google.gson.annotations.SerializedName

data class SourceModel(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String
)