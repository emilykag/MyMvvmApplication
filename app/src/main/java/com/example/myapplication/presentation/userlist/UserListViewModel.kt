package com.example.myapplication.presentation.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.models.Resource
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.FetchUsersListUseCase
import javax.inject.Inject

class UserListViewModel @Inject constructor(
    fetchUsersListUseCase: FetchUsersListUseCase
) : ViewModel() {

    private var _users: LiveData<Resource<List<User>>> = fetchUsersListUseCase.invoke()

    fun getUsers() = _users
}