package com.jay.myfirstapp.ui.bottomnavigation

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jay.myfirstapp.navigation.ROUTE_HOME
import com.jay.myfirstapp.navigation.ROUTE_MENU
import com.jay.myfirstapp.navigation.ROUTE_PROFILE

private val NavGray = Color(0xFF222222)
private val Red = Color(0xFFE53935)

@Composable
fun BottomNavBar(navController: NavController) {

    NavigationBar(
        containerColor = NavGray,
        tonalElevation = 0.dp,
        modifier = Modifier.height(60.dp)
    ) {

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(ROUTE_HOME)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Red,
                unselectedIconColor = Color.White,
                selectedTextColor = Red,
                unselectedTextColor = Color.White,
                indicatorColor = Color.Transparent
            ),
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = {
                Text("Home")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(ROUTE_PROFILE)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Red,
                unselectedIconColor = Color.White,
                selectedTextColor = Red,
                unselectedTextColor = Color.White,
                indicatorColor = Color.Transparent
            ),
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile"
                )
            },
            label = {
                Text("Profile")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(ROUTE_MENU)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Red,
                unselectedIconColor = Color.White,
                selectedTextColor = Red,
                unselectedTextColor = Color.White,
                indicatorColor = Color.Transparent
            ),
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            },
            label = {
                Text("Menu")
            }
        )
    }
}