package ph.mart.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ph.mart.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            TodoTheme {
                ThirdLesson()
            }
        }
    }
}

@Composable
fun MainApp(
    modifier: Modifier = Modifier
) {
    var userInput by remember { mutableStateOf("") }
    var isDialogShown by remember { mutableStateOf(false) }

    if (isDialogShown) {
        MyCustomDialog(
            onDismissRequest = { isDialogShown = false },
            onConfirm = { isDialogShown = false },
            text = userInput
        )
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = "Hello!",
            modifier = Modifier.padding(16.dp)
        )

        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Enter something") }
        )

        Button(
            onClick = { isDialogShown = true }
        ) {
            Text("Click Me")
        }
    }
}

@Composable
fun MyCustomDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text("Confirm")
            }
        },
        text = {
            Text("Input: $text")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            MainApp(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}