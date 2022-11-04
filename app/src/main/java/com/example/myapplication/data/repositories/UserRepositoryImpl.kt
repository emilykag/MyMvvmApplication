package com.example.myapplication.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.myapplication.data.apiservice.ApiService
import com.example.myapplication.data.mapToResource
import com.example.myapplication.data.mappers.UserDetailsMapper
import com.example.myapplication.data.mappers.UsersResultMapper
import com.example.myapplication.domain.models.Resource
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.models.UserDetails
import com.example.myapplication.domain.repositories.UserRepository

class UserRepositoryImpl(private val apiService: ApiService) : UserRepository {

    override fun getUserList(): LiveData<Resource<List<User>>> {
        return Transformations.map(apiService.getUsers()) {
            it.mapToResource {
                UsersResultMapper.mapDtoToDomainModelList(it)
            }
        }
    }

    override fun getUserDetails(id: String): LiveData<Resource<UserDetails>> {
        return Transformations.map(apiService.getUserById()) {
            it.mapToResource {
                UserDetailsMapper.mapDtoToDomainModel(it)
            }
        }
    }
}