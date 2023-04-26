package com.moracoding.test.data.remote.source

import com.moracoding.test.data.models.ProductDto
import com.moracoding.test.data.remote.api.ProductService
import com.moracoding.test.data.repositories.ProductRemoteDatasource
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(
    private val productService: ProductService
): ProductRemoteDatasource {
    override suspend fun getProducts(): List<ProductDto> {
        return productService.getProducts().products
    }
}