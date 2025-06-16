package com.example.myspotifycontrol

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspotifycontrol.data.openSpotifyLoginPage
import com.example.myspotifycontrol.ui.components.ControlLayout
import com.example.myspotifycontrol.ui.theme.MySpotifyControlTheme

class MainActivity : ComponentActivity() {
    private fun handleSpotifyRedirect(intent: Intent?) {
        val uri = intent?.data ?: return

        if (uri.toString().startsWith("myspotifycontrol://callback")) {
            val fragment = uri.fragment // ex: "access_token=xxx&token_type=Bearer&expires_in=3600"
            val params = fragment?.split("&")?.associate {
                val (key, value) = it.split("=")
                key to value
            }

            val accessToken = params?.get("access_token")
            Log.d("SpotifyAuth", "Access Token: $accessToken")

            // Aqui você pode guardar o token com SharedPreferences ou State
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySpotifyControlTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ControlScreen(
                        modifier = Modifier.padding(innerPadding),
                        context = this
                    )
                }
            }
        }
        handleSpotifyRedirect(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleSpotifyRedirect(intent)
    }
}

@Composable
fun ControlScreen(modifier: Modifier = Modifier, context: Context) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 62.dp, end = 16.dp, top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Controle Seu Spotify",
            )
            Button(
                onClick = { openSpotifyLoginPage(context) },
                colors = ButtonColors(
                    containerColor = Color(0xFF1DB954),
                    contentColor = Color.Black,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.Gray
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_action_connect),
                    contentDescription = "parear"
                )
            }
        }
        ControlLayout()
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySpotifyControlTheme {
    }
}