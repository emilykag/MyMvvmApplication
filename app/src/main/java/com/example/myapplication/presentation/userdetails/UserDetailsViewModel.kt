package com.example.myapplication.presentation.userdetails

import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.usecases.FetchUserDetailsUseCase
import javax.inject.Inject

class UserDetailsViewModel @Inject constructor(
    private val fetchUsersDetailsUseCase: FetchUserDetailsUseCase
) : ViewModel() {

    fun getUserDetails(id: String) = fetchUsersDetailsUseCase.invoke(id)
}