package com.example.myapplication.data

import com.example.myapplication.domain.models.Resource
import com.example.myapplication.network.ApiEmptyResponse
import com.example.myapplication.network.ApiErrorResponse
import com.example.myapplication.network.ApiResponse
import com.example.myapplication.network.ApiSuccessResponse

fun <Dto, DomainModel> ApiResponse<Dto>.mapToResource(
    mapper: (Dto) -> DomainModel
): Resource<DomainModel> =
    when (this) {
        is ApiSuccessResponse -> {
            Resource.success(mapper(this.body))
        }
        is ApiErrorResponse -> {
            Resource.error(this.errorMessage, null)
        }
        is ApiEmptyResponse -> {
            Resource.success(null)
        }
    }