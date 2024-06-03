package com.example.spacexapplication1.ui.compose.nav

//@Composable
//fun LoginScreen(navController: NavHostController) {
//    var showLoginDialog by remember { mutableStateOf(false) }
//    var showSignUpDialog by remember { mutableStateOf(false) }
//
//    //val auth = FirebaseAuth.getInstance()
//
//    LaunchedEffect(Unit) {
//        checkAuthStatus(auth, navController)
//    }
//
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 30.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//
//            Spacer(modifier = Modifier.height(190.dp))
//
//
//            OutlinedButton(
//                onClick = { showLoginDialog = true },
//                modifier = Modifier
//                    .width(360.dp)
//                    .height(48.dp)
//                    .padding(vertical = 1.5.dp),
//                border = BorderStroke(1.dp, Color.White),
//                colors = ButtonDefaults.outlinedButtonColors(
//                    contentColor = Color.Black,
//                    containerColor = Color.Transparent,
//
//                    )
//            ) {
//                Text(
//                    text = "Login",
//                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 18.sp),
//                )
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            OutlinedButton(
//                onClick = { / Handle authenticate / },
//                modifier = Modifier
//                    .width(360.dp)
//                    .height(48.dp)
//                    .padding(vertical = 1.5.dp),
//                border = BorderStroke(1.dp, Color.White),
//                colors = ButtonDefaults.outlinedButtonColors(
//                    contentColor = Color.Black,
//                    containerColor = Color.Transparent
//                )
//            ) {
//
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            OutlinedButton(
//                onClick = { showSignUpDialog = true },
//                modifier = Modifier
//                    .width(360.dp)
//                    .height(48.dp)
//                    .padding(vertical = 1.5.dp),
//                border = BorderStroke(1.dp, Color.White),
//                colors = ButtonDefaults.outlinedButtonColors(
//                    contentColor = Color.Black,
//                    containerColor = Color.Transparent
//                )
//            ) {
//                Text(
//                    text = "Sign Up",
//                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 18.sp),
//                )
//            }
//        }
//        if (showLoginDialog) {
//            LoginDialog(onDismiss = { showLoginDialog = false }, navController)
//        }
//        if (showSignUpDialog) {
//            SignUpDialog(onDismiss = { showSignUpDialog = false }, navController)
//        }
//    }
//}
//
//
//
//@Composable
//fun LoginDialog(onDismiss: () -> Unit, navController: NavHostController) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    val auth: FirebaseAuth = remember { FirebaseAuth.getInstance() }
//    val context = LocalContext.current
//
//
//
//    AlertDialog(
//        modifier = Modifier
//            .width(340.dp)
//            .height(320.dp),
//
//        onDismissRequest = onDismiss,
//        title = { Text(text = "Login")},
//        text = {
//            Column {
//                OutlinedTextField(
//                    value = email,
//                    onValueChange = { email = it },
//                    label = { Text(text="Email") }
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                TextField(
//                    value = password,
//                    onValueChange = { password = it },
//                    label = { Text(text = "Password") }
//                )
//            }
//        },
//        confirmButton = {
//            OutlinedButton(
//                onClick = { loginWithEmailAndPassword(email, password, auth, context, navController) },
//                modifier = Modifier
//                    .width(100.dp)
//                    .height(45.dp)
//                    .padding(vertical = 1.5.dp),
//                border = BorderStroke(1.dp, Color.Black),
//                colors = ButtonDefaults.outlinedButtonColors(
//                    contentColor = Color.Black,
//                    containerColor = Color.Transparent
//                )
//            ) {
//                Text(text = "Login")
//            }
//        }
//    )
//}
//
//@Composable
//fun SignUpDialog(onDismiss: () -> Unit, navController: NavHostController) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var confirmPassword by remember { mutableStateOf("") }
//    val auth: FirebaseAuth = remember { FirebaseAuth.getInstance() }
//    val context = LocalContext.current
//
//    AlertDialog(
//        modifier = Modifier
//            .width(340.dp)
//            .height(360.dp),
//        onDismissRequest = onDismiss,
//        title = { Text(text = "Sign Up") },
//        text = {
//            Column {
//                OutlinedTextField(
//                    value = email,
//                    onValueChange = { email = it },
//                    label = { Text(text = "Email") }
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                OutlinedTextField(
//                    value = password,
//                    onValueChange = { password = it },
//                    label = { Text(text = "Password") },
//                    visualTransformation = PasswordVisualTransformation()
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                OutlinedTextField(
//                    value = confirmPassword,
//                    onValueChange = { confirmPassword = it },
//                    label = { Text(text = "Confirm Password") },
//                    visualTransformation = PasswordVisualTransformation()
//                )
//            }
//        },
//        confirmButton = {
//            OutlinedButton(
//                onClick = { signUpWithEmailAndPassword(email, password, confirmPassword, auth, context, navController) },
//                modifier = Modifier
//                    .width(100.dp)
//                    .height(45.dp)
//                    .padding(vertical = 1.5.dp),
//                border = BorderStroke(1.dp, Color.Black),
//                colors = ButtonDefaults.outlinedButtonColors(
//                    contentColor = Color.Black,
//                    containerColor = Color.Transparent
//                )
//            ) {
//                Text(text = "Sign Up")
//            }
//        }
//    )
//}