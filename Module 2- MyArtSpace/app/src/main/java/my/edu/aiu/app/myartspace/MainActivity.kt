package my.edu.aiu.app.myartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import my.edu.aiu.app.myartspace.ui.theme.MyArtSpaceTheme

data class Artwork(
    val imageResId: Int,
    val title: String,
    val artist: String,
    val year: String
)

val artworks = listOf(
    Artwork(
        imageResId = R.drawable.artwork1,
        title = "Espresso Art",
        artist = "Aisha Rahman",
        year = "2024"
    ),
    Artwork(
        imageResId = R.drawable.artwork2,
        title = "latte Art Photo",
        artist = "Daniel Lee",
        year = "2023"
    ),
    Artwork(
        imageResId = R.drawable.artwork3,
        title = "Cappuccino Art Photo",
        artist = "Nur Aisyah",
        year = "2022"
    ),
    Artwork(
        imageResId = R.drawable.artwork4,
        title = "Mocha Art Photo",
        artist = "Adam Wong",
        year = "2021"
    )
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyArtSpaceTheme {
                MyArtSpaceApp()
            }
        }
    }
}

@Composable
fun MyArtSpaceApp() {

    var currentIndex by remember {
        mutableStateOf(0)
    }

    val currentArtwork = artworks[currentIndex]

    ArtSpaceScreen(
        artwork = currentArtwork,
        currentIndex = currentIndex,
        totalArtworks = artworks.size,
        onPrevious = {
            currentIndex =
                (currentIndex - 1 + artworks.size) % artworks.size
        },
        onNext = {
            currentIndex =
                (currentIndex + 1) % artworks.size
        }
    )
}

@Composable
fun ArtSpaceScreen(
    artwork: Artwork,
    currentIndex: Int,
    totalArtworks: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(
                painter = painterResource(
                    id = artwork.imageResId
                ),
                contentDescription = artwork.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Fit
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = artwork.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "${artwork.artist}, ${artwork.year}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Text(
                text = "${currentIndex + 1} of $totalArtworks",
                style = MaterialTheme.typography.bodyMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = onPrevious
                ) {
                    Text("Previous")
                }

                Button(
                    onClick = onNext
                ) {
                    Text("Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {

    MyArtSpaceTheme {

        ArtSpaceScreen(
            artwork = artworks[0],
            currentIndex = 0,
            totalArtworks = artworks.size,
            onPrevious = {},
            onNext = {}
        )
    }
}