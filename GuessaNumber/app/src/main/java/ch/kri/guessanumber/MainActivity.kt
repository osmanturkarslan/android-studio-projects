package ch.kri.guessanumber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import ch.kri.guessanumber.ui.theme.GuessANumberTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GuessANumberTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GuessANumber(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

val secretNumber = (1..100).random()

fun guess(inputNumber : Int) : String{

    if (inputNumber > secretNumber){
        return "Too High"
    } else if(inputNumber < secretNumber) {
        return "Too Low"
    } else {
        return "You win!"
    }
}

@Composable
fun GuessANumber(modifier: Modifier = Modifier) {
    var inputNumber by remember { mutableStateOf("0") }
    var answerText by remember { mutableStateOf("no answer yet") }
    Column (
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = inputNumber,
            onValueChange = {inputNumber = it},
            label = { Text("Enter your guess here") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            onClick = { answerText = guess(inputNumber.toInt())}
        ) { Text("Make Guess") }
        Text(text = answerText)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GuessANumberTheme {
        GuessANumber()
    }
}