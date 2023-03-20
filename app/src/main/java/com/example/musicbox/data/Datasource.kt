package com.example.musicbox.data

import com.example.musicbox.R
import com.example.musicbox.data.model.Song

class Datasource {
    var musicList = listOf<Song>(
        Song("Öptüm", "Tarkan", R.drawable.note_icon, "3:47"),
        Song("We will win", "Episodes", R.drawable.note_icon, "1:52"),
        Song("In the End", "Marc Gebelli", R.drawable.note_icon, "9:27"),
        Song("Loyality", "Steven Bankor", R.drawable.note_icon, "5:23"),
        Song("Dream with Me", "Lilly Beckers", R.drawable.note_icon, "2:38")
    )

    fun getSongs() : List<Song> {
        return musicList
    }
}