import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fairpriceapp.data.CerealsViewModel

@Composable
fun UpdateCerealScreen(navController: NavController, cerealId: String, cerealsViewModel: CerealsViewModel = viewModel()) {
    // Fetch cereal by id from the ViewModel
    val cereals by cerealsViewModel.cereals.observeAsState(emptyList())
    val cerealToUpdate = cereals.find { it.id == cerealId }

    // Initialize the state variables based on the cerealToUpdate
    var name by remember { mutableStateOf(cerealToUpdate?.name ?: "") }
    var description by remember { mutableStateOf(cerealToUpdate?.description ?: "") }
    var price by remember { mutableStateOf(cerealToUpdate?.price?.toString() ?: "") }
    var isPriceError by remember { mutableStateOf(false) }

    if (cerealToUpdate != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Update Cereal", style = MaterialTheme.typography.headlineMedium)

            // TextField for Name
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            // TextField for Description
            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )

            // TextField for Price
            TextField(
                value = price,
                onValueChange = {
                    price = it
                    isPriceError = it.toFloatOrNull() == null // Validate price input
                },
                label = { Text("Price") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            // Display error message for invalid price input
            if (isPriceError) {
                Text("Please enter a valid price", color = MaterialTheme.colorScheme.error)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (name.isNotBlank() && description.isNotBlank() && !isPriceError) {
                        val priceValue = price.toFloat()
                        // Update the cereal
                        val updatedCereal = cerealToUpdate.copy(
                            name = name,
                            description = description,
                            price = priceValue
                        )
                        cerealsViewModel.updateCereal(updatedCereal) // Update cereal in ViewModel
                        navController.navigate("cereals/view") // Navigate back to the cereals list
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = name.isNotBlank() && description.isNotBlank() && !isPriceError // Enable button only when valid
            ) {
                Text("Update")
            }
        }
    } else {
        Text("Cereal not found", modifier = Modifier.padding(16.dp))
    }
}
