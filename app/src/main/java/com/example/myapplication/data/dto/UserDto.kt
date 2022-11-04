package com.example.myapplication.data.dto

class ResultDto(
    val results: List<UserDto>?,
    val info: InfoDto?
)

class UserDto(
    val gender: String?,
    val email: String?,
    val phone: String?,
    val cell: String?,
    val nat: String?,
    val id: IdDto?,
    val name: NameDto?,
    val dob: DateDto?,
    val registered: DateDto?,
    val picture: PictureDto?,
    val location : LocationDto?
)

class NameDto(
    val title: String?,
    val first: String?,
    val last: String?
)

class IdDto(
    val name: String?,
    val value: String?
)

class DateDto(
    val date: String?,
    val age: String?
)

class PictureDto(
    val large: String?,
    val medium: String?,
    val thumbnail: String?,
)

class LocationDto(
    val city: String?,
    val state: String?,
    val country: String?,
    val postcode: String?,
    val street: StreetDto?
)
class StreetDto(
    val number: Int?,
    val name: String?
)

class InfoDto(
    val seed: String?,
    val results: Int?,
    val page: Int?,
    val version: String?
)
