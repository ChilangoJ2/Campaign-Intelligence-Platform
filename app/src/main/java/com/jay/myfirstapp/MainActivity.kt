package com.jay.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jay.myfirstapp.navigation.AppNavHost
import com.jay.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyFirstAppTheme {
                AppNavHost()
            }
        }
    }
}