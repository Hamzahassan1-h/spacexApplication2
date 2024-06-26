package com.example.spacexapplication1.ui.compose.nav

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.spacexapplication1.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(navController: NavHostController) {
    var showLoginDialog by remember { mutableStateOf(false) }
    var showSignUpDialog by remember { mutableStateOf(false) }
    val backgroundImage: Painter = painterResource(R.drawable.img)

    val auth = FirebaseAuth.getInstance()

    LaunchedEffect(Unit) {
        checkFirebaseAuthentication(auth, navController)
    }
    Image(
        painter = backgroundImage,
        contentDescription = stringResource(R.string.background_image_desc),
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.img_2),
                contentDescription = stringResource(R.string.app_logo_desc),
                modifier = Modifier
                    .size(400.dp)
                    .padding(bottom = 180.dp)
            )

            Spacer(modifier = Modifier.height(100.dp))

            Text(
                stringResource(R.string.app_slogan),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier
                    .padding(top = 25.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))


            OutlinedButton(
                onClick = { showLoginDialog = true },
                modifier = Modifier
                    .width(360.dp)
                    .height(48.dp)
                    .padding(vertical = 1.5.dp),
                border = BorderStroke(1.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent,

                    )
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 18.sp),
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = { showLoginDialog = true },
                modifier = Modifier
                    .width(360.dp)
                    .height(48.dp)
                    .padding(vertical = 1.5.dp),
                border = BorderStroke(1.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    stringResource(R.string.authenticate_text),
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 18.sp),
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = { showSignUpDialog = true },
                modifier = Modifier
                    .width(360.dp)
                    .height(48.dp)
                    .padding(vertical = 1.5.dp),
                border = BorderStroke(1.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = "Sign Up",
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 18.sp),
                )
            }
        }
        if (showLoginDialog) {
            LoginDialog(onDismiss = { showLoginDialog = false }, navController)
        }
        if (showSignUpDialog) {
            SignUpDialog(onDismiss = { showSignUpDialog = false }, navController)
        }
    }
}



@Composable
fun LoginDialog(onDismiss: () -> Unit, navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val auth: FirebaseAuth = remember { FirebaseAuth.getInstance() }
    val context = LocalContext.current



    AlertDialog(
        modifier = Modifier
            .width(340.dp)
            .height(320.dp),

        onDismissRequest = onDismiss,
        title = { Text(text = "Login")},
        text = {
            Column {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text="Email") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") }
                )
            }
        },
        confirmButton = {
            OutlinedButton(
                onClick = { login(email, password, auth, context, navController) },
                modifier = Modifier
                    .width(100.dp)
                    .height(45.dp)
                    .padding(vertical = 1.5.dp),
                //
                border = BorderStroke(1.dp, Color.Black),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black,
                    containerColor = Color.Transparent
                )
            ) {
                Text(text = "Login")
            }
        }
    )
}

@Composable
fun SignUpDialog(onDismiss: () -> Unit, navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val auth: FirebaseAuth = remember { FirebaseAuth.getInstance() }
    val context = LocalContext.current

    AlertDialog(
        modifier = Modifier
            .width(340.dp)
            .height(360.dp),
        onDismissRequest = onDismiss,
        title = { Text(text = "Sign Up") },
        text = {
            Column {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text(text = "Confirm Password") },
                    visualTransformation = PasswordVisualTransformation()
                )
            }
        },
        confirmButton = {
            OutlinedButton(
                onClick = { signUp (email, password, confirmPassword, auth, context, navController) },
                modifier = Modifier
                    .width(100.dp)
                    .height(45.dp)
                    .padding(vertical = 1.5.dp),
                border = BorderStroke(1.dp, Color.White),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Transparent
                )
            ) {
                Text(text = "Sign Up")
            }
        }
    )
}