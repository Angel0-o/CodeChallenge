package com.moracoding.test.di

import com.moracoding.test.data.remote.source.ProductRemoteDataSourceImpl
import com.moracoding.test.data.repositories.ProductRemoteDatasource
import com.moracoding.test.data.repositories.ProductRepositoryImpl
import com.moracoding.test.domain.repositories.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindProductRepository(repositoryImpl: ProductRepositoryImpl): ProductRepository

    @Binds
    fun bindProductRemoteDataSource(remoteDataSourceImpl: ProductRemoteDataSourceImpl):ProductRemoteDatasource
}