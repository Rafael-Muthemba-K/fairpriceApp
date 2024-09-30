import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController) {
    MaterialTheme {
        // Your registration UI components here
        Text(text = "Register Screen")

        Button(onClick = {
            // Navigate back to Login Screen
            navController.navigate("login")
        }) {
            Text("Go to Login")
        }
    }
}
