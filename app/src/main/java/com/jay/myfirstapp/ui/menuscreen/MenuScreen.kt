package com.jay.myfirstapp.ui.menuscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jay.myfirstapp.navigation.ROUTE_ADD_PRODUCT
import com.jay.myfirstapp.navigation.ROUTE_CALCULATOR
import com.jay.myfirstapp.navigation.ROUTE_INTENT
import com.jay.myfirstapp.navigation.ROUTE_LOGIN
import com.jay.myfirstapp.navigation.ROUTE_MYSAFARICOM
import com.jay.myfirstapp.navigation.ROUTE_UPDATE_PRODUCT
import com.jay.myfirstapp.navigation.ROUTE_VIEW_PRODUCTS
import com.jay.myfirstapp.ui.bottomnavigation.BottomNavBar

private val Black = Color(0xFF0F0F0F)
private val Red = Color(0xFFE53935)
private val White = Color.White

@Composable
fun MenuScreen(navController: NavController) {

    Scaffold(
        containerColor = Black,
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Black)
                .padding(paddingValues)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "MENU",
                color = Red,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_CALCULATOR)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red
                )
            ) {
                Text(
                    text = "Calculator",
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_INTENT)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red
                )
            ) {
                Text(
                    text = "Intent Dashboard",
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_MYSAFARICOM)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red
                )
            ) {
                Text(
                    text = "My Safaricom App",
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_ADD_PRODUCT)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red
                )
            ) {
                Text(
                    text = "Add Product",
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_VIEW_PRODUCTS)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red
                )
            ) {
                Text(
                    text = "View Products",
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    navController.navigate(
                        ROUTE_UPDATE_PRODUCT.replace(
                            "{productId}",
                            "1"
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red
                )
            ) {
                Text(
                    text = "Update Product",
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_LOGIN)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red
                )
            ) {
                Text(
                    text = "Logout",
                    color = White
                )
            }
        }
    }
}