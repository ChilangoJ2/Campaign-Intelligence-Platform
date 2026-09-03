package com.jay.myfirstapp.ui.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jay.myfirstapp.R
import com.jay.myfirstapp.ui.bottomnavigation.BottomNavBar

private val Black = Color(0xFF0F0F0F)
private val DarkGray = Color(0xFF1C1C1C)
private val Red = Color(0xFFE53935)
private val White = Color.White

@Composable
fun ProfileScreen(navController: NavController) {

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
                .verticalScroll(rememberScrollState())
                .padding(20.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "MY PROFILE",
                color = Red,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(25.dp))

            Image(
                painter = painterResource(id = R.drawable.julius3),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Julius Chilango",
                color = White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Android Kotlin Developer",
                color = Color.LightGray,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(25.dp))

            ProfileCard(
                title = "Email",
                value = "julius_3@gmail.com"
            )

            ProfileCard(
                title = "Phone",
                value = "+254 759 671 ***"
            )

            ProfileCard(
                title = "Position",
                value = "Founder & CEO - MJC Africa Ltd"
            )

            ProfileCard(
                title = "Skills",
                value = "Kotlin, Jetpack Compose, Marketing, PR, Digital Strategy"
            )

            ProfileCard(
                title = "Experience",
                value = "Marketing Consultant, Mobile App Development Learner, Entrepreneur"
            )

            ProfileCard(
                title = "About Me",
                value = "Passionate Android developer and entrepreneur focused on building impactful digital products and helping brands grow through technology, marketing and innovation."
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun ProfileCard(
    title: String,
    value: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        colors = CardDefaults.cardColors(
            containerColor = DarkGray
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                color = Red,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = value,
                color = White,
                fontSize = 15.sp
            )
        }
    }
}