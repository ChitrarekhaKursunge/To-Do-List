package com.firstaap.newsapp

data class NewsArticle(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)