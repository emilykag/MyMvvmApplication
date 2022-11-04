package com.example.myapplication.domain.models

data class Resource<out T>(val status: String, val data: T?, val message: String?) {
    companion object {

        const val SUCCESS = "SUCCESS"
        const val ERROR = "ERROR"

        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(ERROR, data, msg)
        }
    }
}
