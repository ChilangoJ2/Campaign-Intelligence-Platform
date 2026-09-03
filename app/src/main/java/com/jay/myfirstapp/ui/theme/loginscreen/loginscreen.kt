package com.jay.myfirstapp.ui.theme.loginscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.jay.myfirstapp.navigation.ROUTE_REGISTER
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jay.myfirstapp.data.AuthViewModel
import com.jay.myfirstapp.navigation.ROUTE_HOME

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "LOGIN",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },

            label = {
                Text(text = "Email")
            },

            placeholder = {
                Text(text = "Enter Email")
            },

            modifier = Modifier.width(300.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(
            value = password,
            onValueChange = { password = it },

            label = {
                Text(text = "Password")
            },

            placeholder = {
                Text(text = "Enter Password")
            },

            visualTransformation = PasswordVisualTransformation(),

            modifier = Modifier.width(300.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))


        Button(
            onClick = {
                if (email.text.trim().isEmpty() || password.text.trim().isEmpty()) {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                } else {
                    val mylogin = AuthViewModel(navController as NavHostController, context)
                    mylogin.login(email.text.trim(), password.text.trim())
                }
            },

            modifier = Modifier.width(300.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )
        ) {

            Text(
                text = "Login",
                fontSize = 18.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        TextButton(
            onClick = {
                navController.navigate(ROUTE_REGISTER)
            }
        ) {
            Text(
                text = "Don't have an account? Register",
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {

    LoginScreen(
        navController = rememberNavController()
    )
}