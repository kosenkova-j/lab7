package com.example.lab7.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val API_KEY = "4dc061d5b27f7eb1eb4cbe851f541e1e"

class PhotoInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val newUrl: HttpUrl = originalRequest.url.newBuilder().addQueryParameter("api_key",API_KEY)
            .addQueryParameter("format","json")
            .addQueryParameter("nojsoncallback", "1")
            .addQueryParameter("extras","url_s")
            .addQueryParameter("safesearch", "1").build()
        val newRequest: Request = originalRequest.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }
}