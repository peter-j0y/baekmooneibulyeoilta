package com.peter.baekmooneibulyeoilta.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.peter.baekmooneibulyeoilta.ui.navigation.BottomNavigationItem
import com.peter.baekmooneibulyeoilta.ui.navigation.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClubApp(

) {
   var navigationSelectedItem by remember { mutableIntStateOf(0) }
   val navController = rememberNavController()

   Scaffold(
      modifier = Modifier.fillMaxSize(),
      bottomBar = {
         NavigationBar {
            BottomNavigationItem().bottomNavigationItems().forEachIndexed { index, bottomNavigationItem ->
               NavigationBarItem(
                  selected = navigationSelectedItem == index,
                  onClick = {
                     navigationSelectedItem = index
                     navController.navigate(bottomNavigationItem.route) {
                        popUpTo(navController.graph.startDestinationId) {
                           saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                     }
                  },
                  label = {
                     Text(text = bottomNavigationItem.label)
                  },
                  icon = {
                     Icon(imageVector = bottomNavigationItem.icon, contentDescription = null)
                  }
               )
            }
         }
      }
   ) { paddingValues ->
      NavGraph(navController, Modifier.padding(paddingValues))
   }
}
