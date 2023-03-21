package com.example.musicbox.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicbox.data.MusicRepository
import com.example.musicbox.data.model.Song

class MusicViewModel : ViewModel() {
    private val repository = MusicRepository()
    private val listOfSongs = repository.songList

    private var _songIndex = MutableLiveData<Int>()
    val songIndex: LiveData<Int>
        get() = _songIndex

    private var _currentSong = MutableLiveData<Song>()
    val currentSong: LiveData<Song>
        get() = _currentSong

    private var _cameFromList = MutableLiveData<Boolean>(true)
    val cameFromList: LiveData<Boolean>
        get() = _cameFromList

    private var _firstSongIndex = MutableLiveData<Int>(0)
    val firstSongIndex: LiveData<Int>
        get() = _firstSongIndex

    init {
        _currentSong.value = listOfSongs.value!![_firstSongIndex.value!!]
    }

    fun nextSong(cameFromList: Boolean, index: Int) {
        if(cameFromList && index < (listOfSongs.value!!.size - 1)) {
            _songIndex.value = index + 1
        }else if(!cameFromList && _songIndex.value!! < (listOfSongs.value!!.size - 1)){
            _songIndex.value = _songIndex.value!! + 1
        }else if(_songIndex.value == listOfSongs.value!!.size-1) {
            _songIndex.value = 0
        }

        _currentSong.value = listOfSongs.value!![_songIndex.value!!]
    }

    fun previousSong(cameFromList: Boolean, index: Int) {
        if(cameFromList && index > 0) {
            _songIndex.value = index - 1
        }else if(!cameFromList && _songIndex.value!! > 0){
            _songIndex.value = _songIndex.value!! - 1
        }else if(_songIndex.value == 1) {
            _songIndex.value = 0
        } else if(_songIndex.value == 0) {
            _songIndex.value = listOfSongs.value!!.size - 1
        }

        _currentSong.value = listOfSongs.value!![_songIndex.value!!]
    }

    fun cameFromListSetTrue() {
        _cameFromList.value = true
    }

    fun setFirstSongIndex(firstSongIndex: Int) {
        _firstSongIndex.value = firstSongIndex
        _songIndex.value = firstSongIndex
        _currentSong.value = listOfSongs.value!![_songIndex.value!!]
    }
}