package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.presentation.MyApplication
import dagger.Module

import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideApplicationContext(application: MyApplication): Context? {
        return application.applicationContext
    }
}