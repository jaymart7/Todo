package ph.mart.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import ph.mart.todo.data.fruits
import ph.mart.todo.ui.common.MyTopAppBar

@Composable
fun FruitDetailsScreen(
    onBack: () -> Unit,
    fruitId: String,
    modifier: Modifier = Modifier
) {
    val fruit = fruits.first { it.id == fruitId }
    val index = fruits.indexOf(fruit)
    var fruitName by remember { mutableStateOf(fruit.name) }

    Scaffold(
        modifier = modifier,
        topBar = {
            MyTopAppBar(
                onBack = onBack,
                text = "Fruit Details"
            )
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = {
                    fruits[index] = fruit.copy(name = fruitName)
                    onBack()
                }
            ) {
                Text("Update")
            }
        }
    ) { paddingValues ->
        FruitDetailsScreen(
            onValueChange = { fruitName = it },
            fruitName = fruitName,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun FruitDetailsScreen(
    onValueChange: (String) -> Unit,
    fruitName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = fruitName,
            onValueChange = onValueChange,
            label = { Text("Name") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )
    }
}