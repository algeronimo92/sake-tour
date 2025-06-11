package com.alangeronimo.saketour.presentation.screens

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alangeronimo.saketour.presentation.viewmodel.SakeShopViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: SakeShopViewModel
) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            SakeShopListScreen(viewModel) { shop ->
                navController.navigate("detail/${Uri.encode(shop.name)}")
            }
        }
        composable(
            "detail/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val shop = viewModel.findShopByName(name)
            shop?.let { SakeShopDetailScreen(it) { navController.popBackStack() } }
        }
    }
}
