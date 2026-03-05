package com.android.gawexx.helper

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.asImageBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

@Composable
fun imageUrl(url: String) {
    var bitmap by remember { mutableStateOf<Bitmap?>( null) }

    LaunchedEffect(Unit) {
        val bmp = withContext(Dispatchers.IO) {
            try {
                BitmapFactory.decodeStream(URL(url).openStream())
            } catch (e: Exception) {
                null
            }
        }
        bitmap = bmp
    }

    if (bitmap != null) {
        Image(
            bitmap = bitmap!!.asImageBitmap(),
            contentDescription = null
        )
    }
}