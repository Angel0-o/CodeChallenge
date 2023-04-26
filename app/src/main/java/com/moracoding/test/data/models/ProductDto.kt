package com.moracoding.test.data.models

data class ProductsDto(
    val products: List<ProductDto>
)
data class ProductDto (
    val id:String,
    val title:String,
    val description:String,
    val price:Int,
    val discountPercentage:Float,
    val rating:Float,
    val stock:Int,
    val brand:String,
    val category:String,
    val thumbnail:String,
        )