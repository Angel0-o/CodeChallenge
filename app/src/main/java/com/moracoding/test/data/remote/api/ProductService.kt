package com.moracoding.test.data.remote.api

import com.moracoding.test.data.models.ProductsDto
import retrofit2.http.GET

interface ProductService {

    @GET("/products")
    suspend fun getProducts(): ProductsDto
}