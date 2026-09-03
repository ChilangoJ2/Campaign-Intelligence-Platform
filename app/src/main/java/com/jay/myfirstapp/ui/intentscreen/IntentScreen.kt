package com.jay.myfirstapp.ui.intentscreen

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.jay.myfirstapp.navigation.ROUTE_HOME
import com.jay.myfirstapp.ui.bottomnavigation.BottomNavBar

private val Black = Color(0xFF0F0F0F)
private val DarkGray = Color(0xFF1C1C1C)
private val Red = Color(0xFFE53935)
private val White = Color.White

@Composable
fun IntentScreen(navController: NavController) {

    val context = LocalContext.current

    val permissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { granted ->

            if (granted) {

                val callIntent = Intent(
                    Intent.ACTION_CALL,
                    "tel:0759671146".toUri()
                )

                context.startActivity(callIntent)

            } else {

                Toast.makeText(
                    context,
                    "Call Permission Denied",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

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

            Text(
                text = "INTENT DASHBOARD",
                color = Red,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Android Intent Actions",
                color = Color.LightGray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(25.dp))

            // SEND SMS
            IntentCard(
                title = "Send SMS",
                subtitle = "Open messaging app"
            ) {

                try {

                    val smsIntent = Intent(
                        Intent.ACTION_SENDTO,
                        "smsto:0759671146".toUri()
                    )

                    context.startActivity(smsIntent)

                } catch (e: Exception) {

                    Toast.makeText(
                        context,
                        "SMS app not found",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            // DIAL NUMBER
            IntentCard(
                title = "Dial Number",
                subtitle = "Open phone dialer"
            ) {

                val dialIntent = Intent(
                    Intent.ACTION_DIAL,
                    "tel:0759671146".toUri()
                )

                context.startActivity(dialIntent)
            }

            // DIRECT CALL
            IntentCard(
                title = "Make Call",
                subtitle = "Call directly"
            ) {

                if (
                    ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.CALL_PHONE
                    ) == PackageManager.PERMISSION_GRANTED
                ) {

                    val callIntent = Intent(
                        Intent.ACTION_CALL,
                        "tel:0759671146".toUri()
                    )

                    context.startActivity(callIntent)

                } else {

                    permissionLauncher.launch(
                        Manifest.permission.CALL_PHONE
                    )
                }
            }

            // CAMERA
            IntentCard(
                title = "Open Camera",
                subtitle = "Launch camera app"
            ) {

                try {

                    val cameraIntent =
                        Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                    context.startActivity(cameraIntent)

                } catch (e: Exception) {

                    Toast.makeText(
                        context,
                        "Camera unavailable",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            // STK
            IntentCard(
                title = "SIM Toolkit",
                subtitle = "Open STK"
            ) {

                try {

                    val stkIntent =
                        context.packageManager
                            .getLaunchIntentForPackage(
                                "com.android.stk"
                            )

                    if (stkIntent != null) {

                        context.startActivity(stkIntent)

                    } else {

                        Toast.makeText(
                            context,
                            "SIM Toolkit not available",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                } catch (e: Exception) {

                    Toast.makeText(
                        context,
                        "SIM Toolkit unavailable",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_HOME)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Red
                )
            ) {

                Text(
                    text = "Back Home",
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun IntentCard(
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },

        shape = RoundedCornerShape(16.dp),

        colors = CardDefaults.cardColors(
            containerColor = DarkGray
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
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
                    fontSize = 13.sp
                )
            }

            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        color = Red,
                        shape = RoundedCornerShape(50)
                    )
            )
        }
    }
}