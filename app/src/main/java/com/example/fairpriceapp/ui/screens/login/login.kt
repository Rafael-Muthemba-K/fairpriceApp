import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fairpriceapp.navigation.Routes

@Composable
fun LoginScreen(navController: NavController) {
    MaterialTheme {
        // Your login UI components here
        Text(text = "Login Screen", style = TextStyle(
            fontSize = 30.sp
        ))
        Modifier.size(height = 150.dp, width = 30.dp)
        Button(onClick = {
            // Navigate to Register Screen
            navController.navigate(Routes.REGISTER)
        },) {
            Text("Go to Register")
        }
    }
}
