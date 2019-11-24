package com.example.myapplication

class LoginRepository {

    lateinit var apiService: APIService

    suspend fun login(username: String, password: String): Boolean {
        val response = apiService.login(username, password)
        val token = response.token

        // SAVE TOKEN KE DB

        return token.isNotEmpty()
    }

}