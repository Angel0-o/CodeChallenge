package com.moracoding.test.domain.repositories

import com.moracoding.test.domain.entities.ProductEntity

interface ProductRepository {

    suspend fun getProducts():List<ProductEntity>
}