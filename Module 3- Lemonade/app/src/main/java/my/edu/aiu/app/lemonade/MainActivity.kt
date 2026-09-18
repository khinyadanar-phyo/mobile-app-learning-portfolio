package my.edu.aiu.app.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            LemonadeApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {

    var currentStep by remember {
        mutableStateOf(1)
    }

    var squeezeCount by remember {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontSize = 24.sp
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {

            when (currentStep) {

                // STEP 1: Pick a lemon
                1 -> {
                    LemonTextAndImage(
                        text = "Tap the lemon tree to pick a lemon",
                        imageResourceId = R.drawable.lemon_tree,
                        contentDescription = "Lemon tree",

                        onImageClick = {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                    )
                }

                // STEP 2: Squeeze the lemon
                2 -> {
                    LemonTextAndImage(
                        text = "Keep tapping the lemon to squeeze it",
                        imageResourceId = R.drawable.lemon_squeeze,
                        contentDescription = "Lemon",

                        onImageClick = {
                            squeezeCount--

                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        }
                    )
                }

                // STEP 3: Drink the lemonade
                3 -> {
                    LemonTextAndImage(
                        text = "Tap the glass to drink the lemonade",
                        imageResourceId = R.drawable.lemon_drink,
                        contentDescription = "Glass of lemonade",

                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }

                // STEP 4: Empty glass
                4 -> {
                    LemonTextAndImage(
                        text = "The glass is empty. Tap to start again",
                        imageResourceId = R.drawable.lemon_restart,
                        contentDescription = "Empty glass",

                        onImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    text: String,
    imageResourceId: Int,
    contentDescription: String,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Button(
                onClick = onImageClick,

                shape = RoundedCornerShape(16.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer
                )
            ) {

                Image(
                    painter = painterResource(
                        id = imageResourceId
                    ),

                    contentDescription = contentDescription,

                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .padding(8.dp)
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = text,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonPreview() {
    LemonadeApp()
}