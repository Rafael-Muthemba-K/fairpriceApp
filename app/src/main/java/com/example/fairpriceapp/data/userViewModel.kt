package com.example.fairpriceapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fairpriceapp.models.Users

class UserViewModel : ViewModel() {
    private val _user = MutableLiveData<Users>()
    val user: LiveData<Users> get() = _user

    fun login(username: String, password: String) {
        // Example login logic
        if (username.isNotEmpty() && password.isNotEmpty()) {
            _user.value = Users("1", username ="Tester", email = "",password ="")
        }
    }

    fun register(user: Users) {
        // Example registration logic
        _user.value = user
    }

    fun updateUser(user: Users) {
        // Logic to update user details
        _user.value = user
    }
}


