package ir.amirhosein.recipesapp.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ir.amirhosein.recipesapp.screens.components.ColumnItem

@Composable
fun MainScreen(
    imageId: Array<Int>,
    names: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = imageId.size

        items(itemCount) {
            ColumnItem(
                modifier,
                painter = imageId,
                title = names,
                itemIndex = it,
                navController = navController
            )
        }
    }

}

