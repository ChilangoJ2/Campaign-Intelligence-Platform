package com.jay.myfirstapp.models

data class Product(
    val id: String = "",
    val productname: String = "",
    val productcategory: String = "",
    val price: String = "",
    val productquantity: String = "",
    val productdescription: String = "",
    val imageurl: String? = null,
    val public_id: String? = null
)
