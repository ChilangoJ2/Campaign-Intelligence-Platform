package com.jay.myfirstapp.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.jay.myfirstapp.models.User
import com.jay.myfirstapp.navigation.ROUTE_LOGIN
import com.jay.myfirstapp.navigation.ROUTE_MENU

class AuthViewModel(
    private val navController: NavHostController,
    private val context: Context
) {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signup(
        jina: String,
        email: String,
        pass: String,
        confirmpass: String
    ) {

        if (
            jina.isBlank() ||
            email.isBlank() ||
            pass.isBlank() ||
            confirmpass.isBlank()
        ) {
            Toast.makeText(
                context,
                "Fill all inputs",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        if (pass != confirmpass) {
            Toast.makeText(
                context,
                "Passwords do not match",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        mAuth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    val uid = mAuth.currentUser?.uid ?: ""

                    val userData = User(
                        jina = jina,
                        email = email,
                        pass = pass,
                        confirmpass = confirmpass,
                        userid = uid
                    )

                    FirebaseDatabase
                        .getInstance()
                        .getReference("Users")
                        .child(uid)
                        .setValue(userData)

                    Toast.makeText(
                        context,
                        "Registration Successful",
                        Toast.LENGTH_LONG
                    ).show()

                } else {

                    Toast.makeText(
                        context,
                        task.exception?.message
                            ?: "Registration Failed",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
    fun login(email: String, pass: String){
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_MENU)
            }else{
                Toast.makeText(context, "${it.exception?.message}", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
            }
        }
    }
