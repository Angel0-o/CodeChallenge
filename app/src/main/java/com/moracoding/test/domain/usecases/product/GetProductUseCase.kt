package com.moracoding.test.domain.usecases.product

import com.moracoding.test.domain.entities.ProductEntity
import com.moracoding.test.domain.repositories.ProductRepository
import com.moracoding.test.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository,
    background:CoroutineDispatcher
): UseCase<List<ProductEntity>, Unit>(background) {
    override suspend fun run(input: Unit?): List<ProductEntity> {
        return repository.getProducts()
    }
}