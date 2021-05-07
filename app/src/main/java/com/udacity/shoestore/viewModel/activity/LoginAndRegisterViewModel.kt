package com.udacity.shoestore.viewModel.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginAndRegisterViewModel : ViewModel() {

    private var _stateUserLogin = MutableLiveData<Boolean>()
    val stateUserLogin: LiveData<Boolean>
        get() = _stateUserLogin

    fun login(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            setStateValue(true)
        } else setStateValue(false)

    }

    fun register(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            setStateValue(true)
        } else setStateValue(false)

    }

    private fun setStateValue(value: Boolean) {
        _stateUserLogin.postValue(value)
    }
}