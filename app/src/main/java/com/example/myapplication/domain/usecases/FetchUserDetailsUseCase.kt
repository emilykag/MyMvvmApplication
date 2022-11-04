package com.example.myapplication.domain.usecases

import androidx.lifecycle.LiveData
import com.example.myapplication.domain.models.Resource
import com.example.myapplication.domain.models.UserDetails
import com.example.myapplication.domain.repositories.UserRepository
import javax.inject.Inject

class FetchUserDetailsUseCase @Inject constructor(
    private val userRepository: UserRepository
) : UseCase<UserDetails, String> {

    override fun invoke(param: String?): LiveData<Resource<UserDetails>> {
        return userRepository.getUserDetails(param.orEmpty())
    }
}