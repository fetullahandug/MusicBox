package com.example.musicbox.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.musicbox.R
import com.example.musicbox.data.model.Song
import com.example.musicbox.ui.MusicFragment

class MusicRepository {

    private var _songList = MutableLiveData<List<Song>>()
    val songList: LiveData<List<Song>>
        get() = _songList

    init {
        loadSongs()
    }

    fun loadSongs() {
        var list: List<Song> = listOf(
            Song("Öptüm", "Tarkan", R.drawable.note_icon, "3:47"),
            Song("We will win", "Episodes", R.drawable.note_icon, "1:52"),
            Song("In the End", "Marc Gebelli", R.drawable.note_icon, "9:27"),
            Song("Loyality", "Steven Bankor", R.drawable.note_icon, "5:23"),
            Song("Dream with Me", "Lilly Beckers", R.drawable.note_icon, "2:38"),
            Song("I'm with You", "Sandero Davinci", R.drawable.note_icon, "2:15"),
            Song("Darling", "Olli Timons", R.drawable.note_icon, "9:53"),
            Song("Tombul", "Yildiz Tilbe", R.drawable.note_icon, "4:17"),
            Song("Kardesim", "Burak Bulut", R.drawable.note_icon, "3:27"),
            Song("Alla Yar", "Roman Adam", R.drawable.note_icon, "4:57"),
            Song("Italian March", "Bell Ciao", R.drawable.note_icon, "2:45")
        )

        _songList.value = list
    }
}