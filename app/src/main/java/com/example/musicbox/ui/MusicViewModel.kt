package com.example.musicbox.ui

import androidx.lifecycle.ViewModel
import com.example.musicbox.data.MusicRepository
import com.example.musicbox.data.model.Song

class MusicViewModel : ViewModel() {
    private val repository = MusicRepository()
    private val listOfSongs = repository.loadSongs()

    private var _songIndex = 0
    val songIndex: Int
        get() = _songIndex

    private var _currentSong = listOfSongs[_songIndex]
    val currentSong: Song
        get() = _currentSong

    fun nextSong(cameFromList: Boolean, index: Int) {
        if(cameFromList && index < (listOfSongs.size - 1)) {
            _songIndex = index + 1
        }else if(!cameFromList && _songIndex < (listOfSongs.size - 1)){
            _songIndex++
        }else if(_songIndex == listOfSongs.size-1) {
            _songIndex = 0
        }

        _currentSong = listOfSongs[_songIndex]
    }

    fun previousSong(cameFromList: Boolean, index: Int) {
        if(cameFromList && index > 0) {
            _songIndex = index - 1
        }else if(!cameFromList && _songIndex > 0){
            _songIndex--
        }else if(songIndex == 1) {
            _songIndex = 0
        } else if(_songIndex == 0) {
            _songIndex = listOfSongs.size - 1
        }

        _currentSong = listOfSongs[_songIndex]
    }
}