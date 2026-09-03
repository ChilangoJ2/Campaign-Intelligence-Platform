package com.jay.myfirstapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jay.myfirstapp.ui.camerascreen.CameraScreen
import com.jay.myfirstapp.ui.intentscreen.IntentScreen
import com.jay.myfirstapp.ui.menuscreen.MenuScreen
import com.jay.myfirstapp.ui.mysafaricomscreen.MySafaricomScreen
import com.jay.myfirstapp.ui.productscreen.AddProductScreen
import com.jay.myfirstapp.ui.productscreen.UpdateProductScreen
import com.jay.myfirstapp.ui.productscreen.ViewProductsScreen
import com.jay.myfirstapp.ui.profilescreen.ProfileScreen
import com.jay.myfirstapp.ui.splashscreen.SplashScreen
import com.jay.myfirstapp.ui.theme.homescreens.HomeScreen
import com.jay.myfirstapp.ui.theme.loginscreen.LoginScreen
import com.jay.myfirstapp.ui.theme.registerscreen.RegisterScreen
import com.jay.myfirstapp.ui.theme.screens.calculatorscreen.CalculatorScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ROUTE_SPLASH
    ) {

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }

        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }

        composable(ROUTE_CALCULATOR) {
            CalculatorScreen(navController)
        }

        composable(ROUTE_INTENT) {
            IntentScreen(navController)
        }

        composable(ROUTE_PROFILE) {
            ProfileScreen(navController)
        }

        composable(ROUTE_MENU) {
            MenuScreen(navController)
        }
        composable(ROUTE_CAMERA) {
            CameraScreen()
        }
        composable(ROUTE_MYSAFARICOM) {
            MySafaricomScreen()
        }
        composable(ROUTE_ADD_PRODUCT) {
            AddProductScreen(navController)
        }
        composable(ROUTE_VIEW_PRODUCTS) {
            ViewProductsScreen(navController)
        }
        composable(
            route = ROUTE_UPDATE_PRODUCT
        ) { backStackEntry ->

            val productId =
                backStackEntry.arguments?.getString("productId") ?: ""

            UpdateProductScreen(
                navController = navController,
                productId = productId
            )
        }
    }
}