package com.firstaap.newsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiInterface {
    @GET("v2/everything?q=apple&from=2022-01-02&to=2022-01-02&sortBy=popularity&apiKey=faaa8306f1854173b8a8e4951e34cef4")
    fun getNews(): Call<NewsArticle>

    companion object{
        var BASE_URL= "https://newsapi.org/"
        fun create(): ApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }

    }
}