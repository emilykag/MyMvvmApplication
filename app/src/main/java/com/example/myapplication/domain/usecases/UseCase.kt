package com.example.myapplication.domain.usecases

import androidx.lifecycle.LiveData
import com.example.myapplication.domain.models.Resource

interface UseCase<R, P> {
    fun invoke(param: P? = null): LiveData<Resource<R>>
}