package com.example.lumet13.Activity.LoadingActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lumet13.Activity.LoadingActivity.ui.theme.Lumet13Theme
import com.example.lumet13.JCview.backgroung

class LoadingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadingActivitsy()
        }
    }
}

@Composable
fun LoadingActivitsy(){
    backgroung()
}
