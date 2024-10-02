import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fairpriceapp.data.OrderViewModel
import com.example.fairpriceapp.models.Orders

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewOrderScreen(orderViewModel: OrderViewModel, navController: NavController) {
    // Observing the orders from the ViewModel
    val orders by orderViewModel.orders.observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Orders") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        content = { paddingValues ->
            // Respect the scaffold's content padding
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                items(orders) { order ->
                    OrderItem(order)
                }
            }
        }
    )
}

@Composable
fun OrderItem(order: Orders) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        // Use shadowElevation for Material3
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Order ID: ${order.id}", style = MaterialTheme.typography.headlineSmall)
            Text("Cereal: ${order.cerealId}", style = MaterialTheme.typography.bodyLarge)
            Text("Quantity: ${order.quantity}", style = MaterialTheme.typography.bodyMedium)
            Text("Total Price: ${order.totalPrice} Ksh", style = MaterialTheme.typography.bodyLarge)
        }
    }
}


