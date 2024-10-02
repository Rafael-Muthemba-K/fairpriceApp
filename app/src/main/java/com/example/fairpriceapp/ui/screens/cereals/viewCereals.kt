import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fairpriceapp.data.CerealsViewModel
import com.example.fairpriceapp.models.Cereals

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewCerealsScreen(navController: NavController, cerealsViewModel: CerealsViewModel) {
    val cerealsViewModel: CerealsViewModel = viewModel()

    // Observe the LiveData for cereals
    val cereals by cerealsViewModel.cereals.observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Cereals") })
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding) // Proper padding from Scaffold
            ) {
                items(cereals) { cereal ->
                    CerealItem(navController, cereal) // Pass only navController and cereal
                }
            }
        }
    )
}

@Composable
fun CerealItem(navController: NavController, cereal: Cereals) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                navController.navigate("viewOrder/${cereal.id}") // Correctly navigate to viewOrder with cerealId
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = cereal.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = cereal.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Price: ${cereal.price} Ksh", style = MaterialTheme.typography.bodyLarge)
        }
    }
}







