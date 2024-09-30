import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun UpdateCerealScreen(navController: NavController,cerealId:String){
    MaterialTheme{
        // Your login UI components here
        Text(text = "UpdateCerealScreen Screen")

        Button(onClick = {
            // Navigate to Register Screen
            navController.navigate("Update")
        }) {
            Text("Go to Update")
        }
    }
}