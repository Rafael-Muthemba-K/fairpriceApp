package com.example.fairpriceapp.ui.screens.cereals

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
import com.example.fairpriceapp.models.Cereals
import java.util.UUID


@Composable
fun AddCerealScreen(navController: NavController, cerealsViewModel: CerealsViewModel = viewModel()) {
    // State variables for user input
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var isPriceError by remember { mutableStateOf(false) } // For price validation

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Add New Cereal", style = MaterialTheme.typography.headlineMedium)

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
                    // Create a new Cereals object
                    val newCereal = Cereals(
                        id = UUID.randomUUID().toString(),
                        name = name,
                        description = description,
                        price = priceValue,
                        imageUrl = ""
                    )
                    cerealsViewModel.addCereal(newCereal) // Add cereal to the ViewModel
                    navController.navigate("cereals/view") // Navigate to the ViewCerealsScreen
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = name.isNotBlank() && description.isNotBlank() && !isPriceError // Enable button only when valid
        ) {
            Text("Save")
        }
    }
}



