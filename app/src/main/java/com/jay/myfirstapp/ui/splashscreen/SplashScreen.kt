package com.jay.myfirstapp.ui.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jay.myfirstapp.navigation.ROUTE_LOGIN
import com.jay.myfirstapp.navigation.ROUTE_CAMERA
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    var showScanner by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(ROUTE_LOGIN) {
            popUpTo(0)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "ARSENAL",
                color = Color.Red,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Champions 2026",
                color = Color.White,
                fontSize = 20.sp
            )
        }

        Card(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
                .clickable {
                    showScanner = true
                },
            colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
        ) {
            Text(
                text = "Scanner",
                color = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }



        if (showScanner) {


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.6f))
                    .clickable {
                        showScanner = false
                    }
            )


            Card(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp)
                    .clickable {
                        navController.navigate(ROUTE_CAMERA)
                    },
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Open Scanner",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Tap to launch camera",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}