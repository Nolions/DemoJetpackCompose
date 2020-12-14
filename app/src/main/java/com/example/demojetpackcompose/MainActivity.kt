package com.example.demojetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demojetpackcompose.ui.DemoJetpackComposeTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NewsStory()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun NewsStory() {
    val image = imageResource(R.drawable.demo)

    Column(modifier = Modifier.padding(20.dp)) {
        val imageModifier = Modifier
            .preferredHeight(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))

        Image(image, modifier = imageModifier, contentScale = ContentScale.Crop)

        Spacer(Modifier.preferredHeight(10.dp))

        Text(
            "A day wandering through the sandhills " +
                    "in Shark Fin Cove, and a few of the " +
                    "sights I saw",
            style = typography.h6,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text("Davenport, California", style = typography.body2)
        Text("December 2018", style = typography.body2)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoJetpackComposeTheme {
        NewsStory()
    }
}