package ch.kri.birthdayparty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ch.kri.birthdayparty.ui.theme.BirthdayPartyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayPartyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Birthday(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Birthday(name: String, modifier: Modifier = Modifier) {
    val pic = painterResource(id = R.drawable.balloons)

    Box{
        Image(painter = pic, contentDescription = null, contentScale = ContentScale.Crop)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Happy Birthday",
                fontSize = 50.sp,
                color = Color.Red,
                modifier = Modifier.background(Color.Transparent)
            )
            Text(
                text = "to you!",
                fontSize = 50.sp,
                color = Color.Cyan,
                modifier = Modifier.background(Color.Transparent)
            )
            Text(
                text = "(you're really old)",
                fontSize = 30.sp,
                color = Color.Green,
                modifier = Modifier.background(Color.Transparent)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BirthdayPartyTheme {
        Birthday("Android")
    }
}