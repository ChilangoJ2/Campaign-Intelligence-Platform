package com.jay.myfirstapp.network

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface CloudinaryApi {

    @Multipart
    @POST("v1_1/{cloud_name}/image/upload")
    suspend fun uploadImage(
        @Path("cloud_name") cloudName: String,
        @Part image: MultipartBody.Part,
        @Part("upload_preset") uploadPreset: RequestBody
    ): CloudinaryResponse

    companion object {
        private const val BASE_URL = "https://api.cloudinary.com/"

        fun create(): CloudinaryApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CloudinaryApi::class.java)
        }
    }
}

data class CloudinaryResponse(
    val public_id: String,
    val version: Int,
    val signature: String,
    val width: Int,
    val height: Int,
    val format: String,
    val resource_type: String,
    val created_at: String,
    val bytes: Int,
    val type: String,
    val url: String,
    val secure_url: String
)
