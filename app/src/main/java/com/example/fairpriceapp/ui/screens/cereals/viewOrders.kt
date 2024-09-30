import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ViewOrder(navController: NavController){
    MaterialTheme{
        // Your login UI components here
        Text(text = "Login Screen")

        Button(onClick = {
            // Navigate to Register Screen
            navController.navigate("login")
        }) {
            Text("Go to Register")
        }
    }
}