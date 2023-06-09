package com.moracoding.test.domain.usecases.base

sealed class Response<out T>{
    data class Success<out T>(val response: T) : Response<T>()
    data class Failure(val error: Exception) : Response<Nothing>()

    fun fold(onSuccess: (T) -> Any, onFailure: (Exception) -> Any = {}): Any =
        when(this){
            is Success -> onSuccess(response)
            is Failure -> onFailure(error)
        }
}
