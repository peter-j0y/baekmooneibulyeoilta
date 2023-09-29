package com.peter.baekmooneibulyeoilta

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.peter.baekmooneibulyeoilta.ui.theme.BaekmooneibulyeoiltaTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ImageViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaekmooneibulyeoiltaTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    viewModel.uri?.let {
                        AsyncImage(
                            model = viewModel.uri,
                            contentDescription = null
                        )
                    }
                    Button(
                        onClick = {
                            // 앱 내의 다른 액티비티를 실행시킬 때 사용
//                            Intent(applicationContext, SecondActivity::class.java).also {
//                                startActivity(it)
//                            }
                            // 명시적 인텐트 예시 -> 버튼을 누르면 Youtube 앱 실행
//                            Intent(Intent.ACTION_MAIN).also {
//                                it.`package` = "com.google.android.youtube"
//                                try {
//                                    startActivity(it)
//                                } catch(e: ActivityNotFoundException) {
//                                    e.printStackTrace()
//                                }
//                            }
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_EMAIL, arrayOf("test@test.com"))
                                putExtra(Intent.EXTRA_SUBJECT, arrayOf("This is my subject"))
                                putExtra(Intent.EXTRA_TEXT, arrayOf("This is the content of my email"))
                            }
                            if(intent.resolveActivity(packageManager) != null) {
                                startActivity(intent)
                            }
                        }
                    ) {
                        Text(text = "Click me")
                    }
                }

            }
        }
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val uri = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
        } else {
            intent?.getParcelableExtra(Intent.EXTRA_STREAM)
        }
        Log.d("MainActivity", "uri: $uri")
        viewModel.updateUri(uri)
    }
}