package com.peter.baekmooneibulyeoilta

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

class HomeViewModel: ViewModel() {
    private val _bitmap = MutableStateFlow<Bitmap?>(null)
    val bitmap: StateFlow<Bitmap?> = _bitmap

    fun createQRCode() {
        try {
            val barcodeEncoder = BarcodeEncoder()
            _bitmap.value = barcodeEncoder.encodeBitmap("www.naver.com", BarcodeFormat.QR_CODE, 400, 400)
            Timber.tag("sm.shin").d("bitmap: $bitmap")
        } catch(e: Exception) {
            Timber.tag("sm.shin").d("bitmap: $e")
        }
    }
}