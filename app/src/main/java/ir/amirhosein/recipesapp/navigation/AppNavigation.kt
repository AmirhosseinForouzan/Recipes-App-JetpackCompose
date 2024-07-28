package ir.amirhosein.recipesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.amirhosein.recipesapp.R
import ir.amirhosein.recipesapp.screens.DetailScreen
import ir.amirhosein.recipesapp.screens.MainScreen

@Composable
fun AppNavigation() {
    val imageId = arrayOf(
        R.drawable.kabab,
        R.drawable.ghormesabzi,
        R.drawable.fesenjan,
        R.drawable.gheymeh,
        R.drawable.bademjan,
        R.drawable.abgoosht
    )

    val names = arrayOf(
        "kabab",
        "Ghorme Sabzi",
        "Fesenjan",
        "Gheymeh",
        "Bademjan",
        "Abgoosht"
    )

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MainScreen") {
        composable(route = "MainScreen") {
            MainScreen(imageId, names, navController)
        }
        composable(route = "DetailScreen/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            DetailScreen(
                photos = imageId,
                names = names,
                itemIndex = backStackEntry.arguments?.getInt("index")
            )
        }
    }
}