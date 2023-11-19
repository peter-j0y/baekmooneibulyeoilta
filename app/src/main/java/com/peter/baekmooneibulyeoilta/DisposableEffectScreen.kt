package com.peter.baekmooneibulyeoilta

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.lifecycle.compose.LifecycleStartEffect
import timber.log.Timber

@Composable
fun LifecycleEventEffectScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val tag = "Lifecycle"

        LifecycleEventEffect(event = Lifecycle.Event.ON_START) {
            Timber.tag(tag).d("onStart")
        }

        LifecycleEventEffect(event = Lifecycle.Event.ON_CREATE) {
            Timber.tag(tag).d("onCreate")
        }

        LifecycleEventEffect(event = Lifecycle.Event.ON_RESUME) {
            Timber.tag(tag).d("onResume")
        }

        LifecycleEventEffect(event = Lifecycle.Event.ON_PAUSE) {
            Timber.tag(tag).d("onPause")
        }

        LifecycleEventEffect(event = Lifecycle.Event.ON_STOP) {
            Timber.tag(tag).d("onStop")
        }

    }
}