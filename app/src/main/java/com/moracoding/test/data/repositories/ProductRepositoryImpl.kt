package com.moracoding.test.data.repositories

import com.moracoding.test.data.mappers.toEntity
import com.moracoding.test.data.models.ProductDto
import com.moracoding.test.domain.entities.ProductEntity
import com.moracoding.test.domain.repositories.ProductRepository
import javax.inject.Inject

internal class ProductRepositoryImpl @Inject constructor(
    private val remoteDatasource: ProductRemoteDatasource
): ProductRepository{

    override suspend fun getProducts(): List<ProductEntity> {
        return remoteDatasource.getProducts().map { it.toEntity() }
    }
}

internal interface ProductRemoteDatasource{
    suspend fun getProducts():List<ProductDto>
}