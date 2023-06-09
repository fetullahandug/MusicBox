package com.example.musicbox.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.musicbox.R
import com.example.musicbox.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {

    private val viewModel: MusicViewModel by viewModels()
    private lateinit var binding: FragmentMusicBinding

    private var music_index = 0
    private var music_cover: Int = 0
    private var music_title = ""
    private var music_singer = ""
    private var music_length: String = ""

    private var cameFromList = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            music_cover = it.getInt("music_cover")
            music_title = it.getString("music_title").toString()
            music_singer = it.getString("music_singer").toString()
            music_length = it.getString("music_length").toString()
            music_index = it.getInt("music_index")
        }

        viewModel.cameFromListSetTrue()
        viewModel.setFirstSongIndex(music_index)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.imageViewCoverOnMusic.setImageResource(music_cover)
        binding.textViewMusicTitle.text = music_title
        binding.textViewMusicSinger.text = music_singer

        binding.ibReturn.setOnClickListener {
            var navController = binding.ibReturn.findNavController()
            navController.navigate(MusicFragmentDirections.actionMusicFragmentToMusiclistFragment())
        }

        binding.mbNext.setOnClickListener {
            nextSongUI()
            cameFromList = false
        }

        binding.mbPrevious.setOnClickListener {
            previousSongUI()
            cameFromList = false
        }
    }

    fun nextSongUI() {
        viewModel.nextSong(cameFromList, music_index)
        cameFromList = false
    }

    fun previousSongUI() {
        viewModel.previousSong(cameFromList, music_index)
        cameFromList = false
    }

}
