package com.example.musicbox.ui

import android.content.ClipData.Item
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.musicbox.R
import com.example.musicbox.adapter.ItemAdapter
import com.example.musicbox.data.Datasource
import com.example.musicbox.data.MusicRepository
import com.example.musicbox.databinding.FragmentMusiclistBinding

class MusiclistFragment : Fragment() {
    private lateinit var binding : FragmentMusiclistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_musiclist, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var songs = MusicRepository().loadSongs()
        var recyclerview = binding.recylerViewSongList

        recyclerview.adapter = ItemAdapter(songs)
        recyclerview.setHasFixedSize(true)
    }

}