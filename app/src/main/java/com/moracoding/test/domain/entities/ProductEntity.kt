package com.moracoding.test.domain.entities

data class ProductEntity(
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
