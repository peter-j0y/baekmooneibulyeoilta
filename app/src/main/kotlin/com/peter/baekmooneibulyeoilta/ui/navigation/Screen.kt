package com.peter.baekmooneibulyeoilta.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen(HOME_ROUTE)
    object Board : Screen(BOARD_ROUTE)
    object Setting : Screen(SETTING_ROUTE)
}