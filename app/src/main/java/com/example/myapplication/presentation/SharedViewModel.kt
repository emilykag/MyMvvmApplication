package com.example.myapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SharedViewModel @Inject constructor() : ViewModel() {

    private val _userRating: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    fun getUserRating() = _userRating

    fun setUserRating(rating: String) {
        if (_userRating.value != rating) {
            _userRating.value = rating
        }
    }
}