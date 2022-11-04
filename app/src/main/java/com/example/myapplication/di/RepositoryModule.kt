package com.example.myapplication.di

import com.example.myapplication.data.apiservice.ApiService
import com.example.myapplication.data.repositories.UserRepositoryImpl
import com.example.myapplication.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepositoryImpl(apiService)
    }
}