package com.moracoding.test.data.mappers

import com.moracoding.test.data.models.ProductDto
import com.moracoding.test.domain.entities.ProductEntity

internal fun ProductDto.toEntity() = ProductEntity(
    id = id,
    title = title,
    description = description,
    price = price,
    discountPercentage = discountPercentage,
    rating = rating,
    stock = stock,
    brand = brand,
    category = category,
    thumbnail = thumbnail,
)