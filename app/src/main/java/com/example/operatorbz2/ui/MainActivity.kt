package com.example.operatorbz2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.operatorbz2.ui.screens.NewNoteScreen
import com.example.operatorbz2.ui.theme.OperatorBZ2Theme
import com.example.operatorbz2.ui.screens.TabScreen
import com.example.operatorbz2.ui.screens.TextScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OperatorBZ2Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "tab_screen") {
                    composable("tab_screen") {
                        TabScreen(navController = navController)
                    }
                    composable(
                        "text_screen/{itemId}",
                        arguments = listOf(navArgument("itemId") { type = NavType.StringType })
                    ) { it ->
                        val itemId = it.arguments?.getString("itemId") ?: "A0"
                        TextScreen(navController = navController ,itemId = itemId)
                    }
                    composable("new_note_screen") {
                        NewNoteScreen(navController = navController)
                    }
                }
            }
        }
    }
}
