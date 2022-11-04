package com.example.myapplication.data.mappers

import com.example.myapplication.data.dto.ResultDto
import com.example.myapplication.domain.models.User

object UsersResultMapper {

    fun mapDtoToDomainModelList(result: ResultDto): List<User> {
        val users = mutableListOf<User>()

        result.results?.forEachIndexed { index, it ->
            users.add(
                User(
                    id = index.toString(),
                    thumbnailImage = it.picture?.large,
                    firstName = it.name?.first,
                    lastName = it.name?.last
                )
            )
        }
        return users
    }
}