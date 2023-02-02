package com.example.lumet13.Request.Retrofit

interface RequestListener<T> {
    fun onFetchData(t:T)
    fun onError(message: String?)
}