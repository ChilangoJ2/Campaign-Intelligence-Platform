package com.jay.myfirstapp.data

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.jay.myfirstapp.BuildConfig
import com.jay.myfirstapp.models.Product
import com.jay.myfirstapp.navigation.ROUTE_VIEW_PRODUCTS
import com.jay.myfirstapp.network.CloudinaryApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody

class ProductViewModel : ViewModel() {
    private val cloudinaryApi = CloudinaryApi.create()
    private val database = FirebaseDatabase.getInstance().getReference("products")

    var products = mutableStateListOf<Product>()
    var loading = mutableStateOf(false)

    fun uploadProduct(
        imageUri: Uri?,
        productName: String,
        productPrice: String,
        productQuantity: String,
        productDescription: String,
        productCategory: String,
        context: Context,
        navController: NavController,
    ) {
        if (productName.isBlank() || productPrice.isBlank() || productQuantity.isBlank()) {
            Toast.makeText(context, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            return
        }

        viewModelScope.launch {
            loading.value = true
            try {
                var imageUrl: String? = null
                var publicId: String? = null

                if (imageUri != null) {
                    val result = uploadToCloudinary(context, imageUri)
                    imageUrl = result?.secure_url
                    publicId = result?.public_id
                }
                
                val reference = database.push()
                val productId = reference.key ?: ""
                val product = Product(
                    id = productId,
                    productname = productName,
                    price = productPrice,
                    productquantity = productQuantity,
                    productdescription = productDescription,
                    productcategory = productCategory,
                    imageurl = imageUrl,
                    public_id = publicId
                )

                reference.setValue(product).await()

                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Product Added successfully", Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_VIEW_PRODUCTS)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            } finally {
                loading.value = false
            }
        }
    }

    private suspend fun uploadToCloudinary(context: Context, imageUri: Uri) = withContext(Dispatchers.IO) {
        val contentResolver = context.contentResolver
        val fileBytes = contentResolver.openInputStream(imageUri)?.use { it.readBytes() } 
            ?: throw Exception("Could not read image data")
        
        val body = fileBytes.toRequestBody("image/jpeg".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("file", "image.jpg", body)
        val preset = BuildConfig.CLOUDINARY_UPLOAD_PRESET.toRequestBody("text/plain".toMediaTypeOrNull())

        cloudinaryApi.uploadImage(BuildConfig.CLOUDINARY_CLOUD_NAME, part, preset)
    }

    fun getProducts() {
        loading.value = true
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                products.clear()
                for (productSnapshot in snapshot.children) {
                    val product = productSnapshot.getValue(Product::class.java)
                    product?.let { products.add(it) }
                }
                loading.value = false
            }

            override fun onCancelled(error: DatabaseError) {
                loading.value = false
            }
        })
    }

    fun deleteProduct(productId: String, context: Context) {
        viewModelScope.launch {
            try {
                database.child(productId).removeValue().await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Product deleted", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Delete failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun updateProduct(
        productId: String,
        productName: String,
        productPrice: String,
        productQuantity: String,
        productDescription: String,
        productCategory: String,
        context: Context,
        navController: NavController
    ) {
        viewModelScope.launch {
            try {
                val updates = mapOf(
                    "productname" to productName,
                    "price" to productPrice,
                    "productquantity" to productQuantity,
                    "productdescription" to productDescription,
                    "productcategory" to productCategory
                )
                database.child(productId).updateChildren(updates).await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Product updated", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Update failed: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
