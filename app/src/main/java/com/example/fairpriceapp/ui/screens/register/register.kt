import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//@Composable
//fun RegisterScreen(navController: NavController) {
//    MaterialTheme {
        // Your registration UI components here
//        Text(text = "Register Screen")

//        Button(onClick = {
            // Navigate back to Login Screen
//            navController.navigate("login")
//        }) {
//            Text("Go to Login")
//        }
//    }
//}

@Composable
fun RegisterScreen(navController: NavController) {
    // Define state variables for form fields
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Define error state variables for validation (optional)
    var isEmailError by remember { mutableStateOf(false) }
    var isPasswordError by remember { mutableStateOf(false) }

    // Layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Register", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Name input field
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth(),
            isError = name.isEmpty()  // Optional error handling
        )
        if (name.isEmpty()) {
            Text("Name cannot be empty", color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Email input field
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            isError = isEmailError  // Optional error handling
        )
        if (isEmailError) {
            Text("Invalid email address", color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Password input field
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            isError = isPasswordError  // Optional error handling
        )
        if (isPasswordError) {
            Text("Password must be at least 6 characters", color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Confirm password input field
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            isError = confirmPassword != password
        )
        if (confirmPassword != password) {
            Text("Passwords do not match", color = Color.Red, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Register button
        Button(
            onClick = {
                // Perform registration logic
                if (name.isNotEmpty() && email.isNotEmpty() && password == confirmPassword) {
                    navController.navigate("login")
                } else {
                    // Handle validation failure
                    isEmailError =
                        email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                            .matches()
                    isPasswordError = password.length < 6
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register")
        }

        // Navigate to login screen
        TextButton(onClick = { navController.navigate("login") }) {
            Text("Already have an account? Log in")
        }
    }
}
