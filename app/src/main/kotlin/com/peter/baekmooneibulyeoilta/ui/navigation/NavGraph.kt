package com.peter.baekmooneibulyeoilta.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.peter.baekmooneibulyeoilta.BoardScreen
import com.peter.baekmooneibulyeoilta.HomeScreen
import com.peter.baekmooneibulyeoilta.SettingScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.Board.route) {
            BoardScreen()
        }
        composable(Screen.Setting.route) {
            SettingScreen()
        }
    }
}