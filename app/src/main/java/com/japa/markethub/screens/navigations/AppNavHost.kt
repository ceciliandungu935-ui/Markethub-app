package com.japa.markethub.screens.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.japa.markethub.screens.auth.LoginScreen
import com.japa.markethub.screens.auth.RegisterScreen
import com.japa.markethub.screens.onboarding.OnBoarding1Screen
import com.japa.markethub.screens.onboarding.OnBoarding2Screen
import com.japa.markethub.screens.home.Homescreen
import com.japa.markethub.screens.intent.IntentScreen
import com.japa.markethub.screens.scaffold.ScaffoldScreen
import com.japa.markethub.screens.splash.SplashScreenScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASHSCREEN
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            Homescreen(navController)
        }


        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }


        composable(ROUT_REGISTER) {
            RegisterScreen(navController)
        }



        composable(ROUT_ONBOARDING1) {
            OnBoarding1Screen(navController)
        }

        composable(ROUT_ONBOARDING2) {
            OnBoarding2Screen(navController)
        }

        composable(ROUT_ONBOARDING3) {
            OnBoarding1Screen(navController)
        }

        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }

        composable(ROUT_SPLASHSCREEN) {
            SplashScreenScreen(navController)
        }

        composable(ROUT_SCAFFOLDSCREEN) {
            ScaffoldScreen(navController)
        }








    }

}