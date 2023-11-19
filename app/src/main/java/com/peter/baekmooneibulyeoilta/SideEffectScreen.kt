package com.peter.baekmooneibulyeoilta

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.lifecycle.compose.LifecycleStartEffect
import kotlinx.coroutines.delay
import timber.log.Timber

@Composable
fun SideEffectScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val tag = "SideEffect"
        var value by remember { mutableStateOf(false) }

        SideEffect {
            Timber.tag(tag).d("SideEffect Launched!")
        }

        LaunchedEffect(Unit) {
            delay(1000L)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if(value) {
                Text("test")
            }
            Button(
                modifier = Modifier.wrapContentSize(),
                onClick = { value = !value }
            ) {
                Text("Change key!")
            }
        }
    }
}

@Composable
private fun ResultText(result: Int) {
    val rememberUpdatedStateResult by rememberUpdatedState(result)
    val rememberResult by remember { mutableIntStateOf(result) }

    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "rememberUpdatedStateValue : ${rememberUpdatedStateResult}, rememberedValue : ${rememberResult}",
        textAlign = TextAlign.Center
    )
}

@Composable
fun Greeting() {
    val context = LocalContext.current
    val tag = "side-effects"

    LaunchedEffect(Unit) {

        Timber.tag(tag).d("LaunchedEffect")
    }


    Text("Hello I am Peter")
}