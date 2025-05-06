package ch.kri.palindromechecker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import ch.kri.palindromechecker.ui.theme.PalindromeCheckerTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PalindromeCheckerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Palindrome(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun isPalindrome(text: String) : Boolean{
    var reversedText = StringBuilder(text).reversed().toString()

    if (text.equals(reversedText)){
        return true;
    }else{
        return false;
    }
}

fun doCheck(inputText: String) : String{
    if (isPalindrome(inputText)){
        return "Is a palindrome"
    } else {
        return "Not a palindrome"
    }
}

@Composable
fun Palindrome(modifier: Modifier = Modifier) {
    var inputText by remember { mutableStateOf("woof") }
    var answerText by remember { mutableStateOf("no answer yet") }
    Column (
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = inputText,
            onValueChange = {inputText = it},
            label = { Text("Enter text here") }
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            onClick = { answerText = doCheck(inputText) }
        ) { Text("Check") }
        Text(text = answerText)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PalindromeCheckerTheme {
        Palindrome()
    }
}