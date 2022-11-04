package com.example.myapplication.domain.usecases

import androidx.lifecycle.LiveData
import com.example.myapplication.domain.models.Resource
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.repositories.UserRepository
import javax.inject.Inject

class FetchUsersListUseCase @Inject constructor(
    private val userRepository: UserRepository
) : UseCase<List<User>, Unit> {

    override fun invoke(param: Unit?): LiveData<Resource<List<User>>> =
        userRepository.getUserList()
}