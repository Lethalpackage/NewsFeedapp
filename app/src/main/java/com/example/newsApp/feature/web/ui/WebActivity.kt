package com.example.newsApp.feature.web.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

import android.webkit.WebSettings
import com.example.newsApp.R


class WebActivity : AppCompatActivity() {

    companion object {
        const val URL = "LINK_wqqwWEB_NEWS"
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val webView = findViewById<WebView>(R.id.webView)

        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        val url = intent.getStringExtra(URL)

        url?.let {
            webView.loadUrl(url)
        }
    }
}