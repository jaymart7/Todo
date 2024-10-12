package ph.mart.todo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import ph.mart.todo.data.Screen.FruitDetails
import ph.mart.todo.data.Screen.FruitList

@Composable
fun ThirdLesson(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FruitList,
        modifier = modifier
    ) {
        composable<FruitList> {
            FruitListScreen(
                onClick = { fruit ->
                    navController.navigate(FruitDetails(fruit.id))
                }
            )
        }

        composable<FruitDetails> { backStackEntry ->
            val args = backStackEntry.toRoute<FruitDetails>()

            FruitDetailsScreen(
                onBack = { navController.popBackStack() },
                fruitId = args.fruitId
            )
        }
    }

}