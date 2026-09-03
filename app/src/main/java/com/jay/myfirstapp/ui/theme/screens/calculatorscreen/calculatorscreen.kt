package com.jay.myfirstapp.ui.theme.screens.calculatorscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jay.myfirstapp.navigation.ROUTE_HOME
import com.jay.myfirstapp.ui.bottomnavigation.BottomNavBar

private val Black = Color(0xFF0F0F0F)
private val DarkGray = Color(0xFF1C1C1C)
private val Red = Color(0xFFE53935)
private val White = Color.White

@Composable
fun CalculatorScreen(navController: NavController) {

    var firstNum by remember { mutableStateOf("") }
    var secondNum by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf("0") }

    fun calculate(operation: String) {

        val num1 = firstNum.toDoubleOrNull()
        val num2 = secondNum.toDoubleOrNull()

        answer = if (num1 == null || num2 == null) {
            "Invalid Input"
        } else {

            when (operation) {
                "+" -> (num1 + num2).toString()
                "-" -> (num1 - num2).toString()
                "*" -> (num1 * num2).toString()
                "/" -> {
                    if (num2 == 0.0) {
                        "Cannot Divide By Zero"
                    } else {
                        (num1 / num2).toString()
                    }
                }
                else -> "0"
            }
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
                .padding(20.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "CALCULATOR",
                color = Red,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = DarkGray
                ),
                shape = RoundedCornerShape(16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = answer,
                        color = White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = firstNum,
                onValueChange = {
                    firstNum = it
                },
                label = {
                    Text(
                        "First Number",
                        color = White
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(
                    color = White
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Red,
                    unfocusedBorderColor = White,
                    cursorColor = Red
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = secondNum,
                onValueChange = {
                    secondNum = it
                },
                label = {
                    Text(
                        "Second Number",
                        color = White
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(
                    color = White
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Red,
                    unfocusedBorderColor = White,
                    cursorColor = Red
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CalcButton("+") {
                    calculate("+")
                }

                CalcButton("-") {
                    calculate("-")
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CalcButton("*") {
                    calculate("*")
                }

                CalcButton("/") {
                    calculate("/")
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_HOME)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkGray
                )
            ) {

                Text(
                    text = "Back Home",
                    color = White
                )
            }
        }
    }
}

@Composable
fun CalcButton(
    symbol: String,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .width(150.dp)
            .height(60.dp),

        shape = RoundedCornerShape(12.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = Red
        )
    ) {

        Text(
            text = symbol,
            color = White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    }
}