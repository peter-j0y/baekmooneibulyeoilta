package com.peter.baekmooneibulyeoilta

sealed class Screen(val title: Int, val icon: Int, val route: String) {
    object Home : Screen(R.string.home_screen_title, R.drawable.ic_launcher_foreground, HOME_ROUTE)
    object Board : Screen(R.string.board_screen_title, R.drawable.ic_launcher_foreground, BOARD_ROUTE)
    object Setting : Screen(R.string.setting_screen_title, R.drawable.ic_launcher_foreground, SETTING_ROUTE)
}