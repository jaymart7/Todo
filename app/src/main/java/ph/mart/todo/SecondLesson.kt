package ph.mart.todo

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ph.mart.todo.data.Fruit
import ph.mart.todo.data.fruits
import ph.mart.todo.ui.theme.TodoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitListScreen(
    onClick: (Fruit) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Fruit List") }
            )
        }
    ) { paddingValues ->
        MyList(
            onClick = onClick,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun MyList(
    onClick: (Fruit) -> Unit,
    modifier: Modifier = Modifier
) {
//    val fruits = listOf("Apple", "Banana", "Orange")

    /*val moreFruits = mutableListOf<String>()
    repeat(200) {
        moreFruits.add("Fruit $it")
    }

    var isDialogShown by remember { mutableStateOf(false) }
    var selectedFruit: Fruit? by remember { mutableStateOf(null) }

    if (isDialogShown) {
        MyCustomDialog(
            onDismissRequest = { isDialogShown = false },
            onConfirm = { isDialogShown = false },
            text = selectedFruit?.name ?: ""
        )
    }*/

    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(fruits) { fruit ->
            FruitItem(
                onClick = onClick,
                fruit = fruit
            )
        }
    }
}

@Composable
private fun FruitItem(
    onClick: (Fruit) -> Unit,
    fruit: Fruit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .clickable { onClick(fruit) }
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(fruit.icon),
                contentDescription = "Fruit icon"
            )

            Text(
                text = fruit.id,
                fontWeight = FontWeight.Bold,
            )

            Text(fruit.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    TodoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MyList(
                modifier = Modifier.padding(innerPadding),
                onClick = { }
            )
        }
    }
}