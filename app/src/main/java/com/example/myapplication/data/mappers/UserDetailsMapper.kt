package com.example.myapplication.data.mappers

import com.example.myapplication.data.dto.ResultDto
import com.example.myapplication.domain.models.UserDetails

object UserDetailsMapper {
    fun mapDtoToDomainModel(result: ResultDto): UserDetails {
        val userDto = result.results?.first()
        return UserDetails(
            profileImage = userDto?.picture?.thumbnail,
            firstName = userDto?.name?.first,
            lastName = userDto?.name?.last
        )
    }
}