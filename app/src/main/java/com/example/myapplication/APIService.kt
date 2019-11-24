package com.example.myapplication

import retrofit2.http.POST

interface APIService {

    @POST("/login")
    suspend fun login(username: String, password: String): LoginResponse

}