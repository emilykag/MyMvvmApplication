package com.example.myapplication.domain.repositories

import androidx.lifecycle.LiveData
import com.example.myapplication.domain.models.Resource
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.models.UserDetails

interface UserRepository {

    fun getUserList(): LiveData<Resource<List<User>>>

    fun getUserDetails(id: String): LiveData<Resource<UserDetails>>
}