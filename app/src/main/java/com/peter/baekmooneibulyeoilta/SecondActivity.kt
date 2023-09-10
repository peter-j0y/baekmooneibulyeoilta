package com.peter.baekmooneibulyeoilta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.peter.baekmooneibulyeoilta.ui.theme.BaekmooneibulyeoiltaTheme

class SecondActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaekmooneibulyeoiltaTheme {
                Text(text = "Second Activity")
            }
        }
    }
}