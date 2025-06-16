package com.example.myspotifycontrol.data

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri


fun openSpotifyLoginPage(context: Context){
    val clientId = "3d94f11ab41b45c78288398eb76a06d3"
    val redirectUri = "myspotifycontrol://callback"
    val scopes = "user-read-playback-state user-modify-playback-state user-read-currently-playing"

    val authUrl = "https://accounts.spotify.com/authorize".toUri()
        .buildUpon()
        .appendQueryParameter("client_id", clientId)
        .appendQueryParameter("response_type", "token")
        .appendQueryParameter("redirect_uri", redirectUri)
        .appendQueryParameter("scope", scopes)
        .build()

    val intent = Intent(Intent.ACTION_VIEW, authUrl)
    startActivity(context,intent,null)

}