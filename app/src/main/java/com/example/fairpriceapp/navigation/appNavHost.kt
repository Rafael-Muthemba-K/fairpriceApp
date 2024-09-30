package com.example.fairpriceapp.navigation

import AddCerealScreen
import LoginScreen
import RegisterScreen
import UpdateCerealScreen
import ViewCerealScreen
import ViewOrder
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) { LoginScreen(navController) }
        composable(Routes.REGISTER) { RegisterScreen(navController) }
        composable(Routes.ADD_CEREAL) { AddCerealScreen(navController) }
        composable(Routes.VIEW_CEREAL) { ViewCerealScreen(navController) }
        composable(Routes.VIEW_ORDERS) { ViewOrder(navController) }
        composable(Routes.UPDATE_CEREAL) { backStackEntry ->
            val cerealId = backStackEntry.arguments?.getString("cerealId") ?: ""
            UpdateCerealScreen(navController, cerealId)
        }
    }
}

