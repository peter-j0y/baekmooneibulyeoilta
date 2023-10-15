package com.peter.baekmooneibulyeoilta.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label: String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route: String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = HOME_ROUTE
            ),
            BottomNavigationItem(
                label = "Board",
                icon = Icons.Filled.Person,
                route = BOARD_ROUTE
            ),
            BottomNavigationItem(
                label = "Setting",
                icon = Icons.Filled.Settings,
                route = SETTING_ROUTE
            )
        )
    }
}