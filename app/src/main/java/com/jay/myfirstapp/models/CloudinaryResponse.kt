package com.jay.myfirstapp.models

data class CloudinaryResponse(
    val secure_url: String? = null,
    val public_id: String? = null,
    val productname: String? = null,
    val category: String? = null,
    val price: String? = null,
    var description: String? = null,
    val stock: String? = null,
    var product_id: String? = null
)