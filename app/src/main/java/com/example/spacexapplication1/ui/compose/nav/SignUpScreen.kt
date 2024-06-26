package com.example.spacexapplication1.ui.compose.nav

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.common.NavRoutes.NavRoutes
import com.google.firebase.auth.FirebaseAuth

fun login(
    email: String,
    password: String,
    auth: FirebaseAuth,
    context: Context,
    navController: NavHostController
) {
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                navController.navigate(NavRoutes.Home.route)
            }
            else {
                Toast.makeText(
                    context,
                    task.exception?.message ?: "Login failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
}


fun checkFirebaseAuthentication(auth: FirebaseAuth, navController: NavHostController) {
    val currentUser = auth.currentUser
    if (currentUser != null) {
        navController.navigate(NavRoutes.Home.route) {
            popUpTo(NavRoutes.Home.route) { inclusive = true }
        }
    }
}

fun signUp(email: String, password: String, confirmPassword: String, auth: FirebaseAuth, context: Context, navController: NavHostController) {
    if (password != confirmPassword) {
        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
        return
    }

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                navController.navigate("home")
            } else {
                Toast.makeText(context, "Sign Up Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
}


fun signOut(auth: FirebaseAuth, navController: NavHostController) {
    auth.signOut()
    navController.navigate(NavRoutes.ROUTE_LOGIN)
}