
package com.example.firstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Surface {
                BusinessCard()
            }
        }
    }
}


@Composable
fun BusinessCard() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val image = painterResource(
            id = R.drawable.andriod_icon
        )

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Khin Yadanar",
            fontSize = 50.sp,
            color = Color.Red
        )

        Text(
            text = "Android Developer",
            fontSize = 25.sp,
            color = Color.Green
        )

        Spacer(
            modifier = Modifier.padding(bottom = 200.dp)
        )

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFFFF0)
        )

        ContactInfoRow(
            text = "+6011-23379343",
            icon = Icons.Rounded.Phone
        )

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFFFF0)
        )

        ContactInfoRow(
            text = "khin@gmail.com",
            icon = Icons.Rounded.Email
        )

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFFFFF0)
        )
    }
}


@Composable
fun ContactInfoRow(
    text: String,
    icon: ImageVector
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Green,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.weight(3f)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    Surface {
        BusinessCard()
    }
}
