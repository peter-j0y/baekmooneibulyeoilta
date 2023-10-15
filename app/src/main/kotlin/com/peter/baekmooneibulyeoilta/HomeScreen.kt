package com.peter.baekmooneibulyeoilta

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import timber.log.Timber

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel()
) {
    val bitmap = homeViewModel.bitmap.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            bitmap.value,
            contentDescription = null
        )
        Button(
            onClick = {
                Timber.tag("sm.shin").d("Button Clicked")
                homeViewModel.createQRCode()
            }
        ) {
            Text(text = "QR 코드 생성 Test")
        }
    }
}