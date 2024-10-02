package com.example.fairpriceapp.navigation

import com.example.fairpriceapp.ui.screens.cereals.AddCerealScreen
import com.example.fairpriceapp.ui.screens.login.LoginScreen
import RegisterScreen
import UpdateCerealScreen
import ViewCerealsScreen
import ViewOrderScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fairpriceapp.data.CerealsViewModel
import com.example.fairpriceapp.data.OrderViewModel

@Composable
fun AppNavHost(
    cerealsViewModel: CerealsViewModel = viewModel(),
    orderViewModel: OrderViewModel = viewModel() // ViewModel for Orders
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) { LoginScreen(navController) }
        composable(Routes.REGISTER) { RegisterScreen(navController) }
        composable(Routes.ADD_CEREAL) { AddCerealScreen(navController) }
        composable(Routes.VIEW_CEREAL) { ViewCerealsScreen(navController, cerealsViewModel) }
        composable(Routes.VIEW_ORDERS) {
            ViewOrderScreen(orderViewModel, navController) // Passing the ViewModel for Orders
        }
        composable(
            "${Routes.UPDATE_CEREAL}/{cerealId}",
            arguments = listOf(navArgument("cerealId") { type = NavType.StringType }) // Define argument type
        ) { backStackEntry ->
            val cerealId = backStackEntry.arguments?.getString("cerealId") ?: ""
            UpdateCerealScreen(navController, cerealId) // Pass the cerealId safely
        }
    }
}


