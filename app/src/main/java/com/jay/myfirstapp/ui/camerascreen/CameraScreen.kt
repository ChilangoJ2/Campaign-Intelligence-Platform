package com.jay.myfirstapp.ui.camerascreen

import android.content.Intent
import android.provider.MediaStore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun CameraScreen() {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        context.startActivity(intent)
    }
}