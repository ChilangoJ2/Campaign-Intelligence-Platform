package com.jay.myfirstapp.ui.theme.homescreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jay.myfirstapp.R
import com.jay.myfirstapp.navigation.ROUTE_CALCULATOR
import com.jay.myfirstapp.navigation.ROUTE_INTENT
import com.jay.myfirstapp.navigation.ROUTE_LOGIN
import com.jay.myfirstapp.navigation.ROUTE_PROFILE
import com.jay.myfirstapp.navigation.ROUTE_REGISTER
import com.jay.myfirstapp.navigation.ROUTE_SPLASH
import com.jay.myfirstapp.ui.bottomnavigation.BottomNavBar

private val Black = Color(0xFF121212)
private val DarkGray = Color(0xFF1E1E1E)
private val Red = Color(0xFFE53935)
private val White = Color.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(

        containerColor = Black,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Arsenal Hub",
                        color = White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkGray
                )
            )
        },

        bottomBar = {
            BottomNavBar(navController)
        }

    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Image(
                painter = painterResource(id = R.drawable.arsenal),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.25f
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "MY HOME",
                    color = Red,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "All in one marketplace",
                    color = White,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(25.dp))

                HomeCard(
                    title = "Calculator",
                    subtitle = "Perform calculations"
                ) {
                    navController.navigate(ROUTE_CALCULATOR)
                }

                HomeCard(
                    title = "Intent Dashboard",
                    subtitle = "SMS, Calls, Camera & STK"
                ) {
                    navController.navigate(ROUTE_INTENT)
                }

                HomeCard(
                    title = "Profile",
                    subtitle = "View your profile"
                ) {
                    navController.navigate(ROUTE_PROFILE)
                }

                HomeCard(
                    title = "Register",
                    subtitle = "Create a new account"
                ) {
                    navController.navigate(ROUTE_REGISTER)
                }

                HomeCard(
                    title = "Login",
                    subtitle = "Access your account"
                ) {
                    navController.navigate(ROUTE_LOGIN)
                }

                HomeCard(
                    title = "Splash Demo",
                    subtitle = "Preview splash screen"
                ) {
                    navController.navigate(ROUTE_SPLASH)
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
                        color = White,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun HomeCard(
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = DarkGray
        ),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = title,
                color = White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = subtitle,
                color = Color.LightGray,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    HomeScreen(
        navController = rememberNavController()
    )
}