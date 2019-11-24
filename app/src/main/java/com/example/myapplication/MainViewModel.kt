package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel : ViewModel(), CoroutineScope {

    companion object {

        const val OPEN_HOME_PAGE = 12
        const val OPEN_REGISTER_PAGE = 23

    }

    val loginRepo by lazy { LoginRepository() }

    val username by lazy { MutableLiveData<String>() }
    val password by lazy { MutableLiveData<String>() }

    val action by lazy { MutableLiveData<Int>() }
    val toastMessage by lazy { MutableLiveData<String>() }

    fun submitLogin() {
        val submittedUsername = username.value
        val submittedPassword = password.value

        if (submittedPassword?.isEmpty() == true) {
            toastMessage.value = "Password should not be empty"
            return
        }

        launch {
            if (loginRepo.login(submittedUsername!!, submittedPassword!!)) {
                toastMessage.value = "Sukses login"
                action.value = OPEN_HOME_PAGE
            }
        }

        Log.d("TAGA", "ASDASD")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

}