package com.qndzia.tapformelody.playandrecord

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.databinding.FragmentPlayAndRecordBinding
import kotlinx.android.synthetic.main.fragment_play_and_record.*


class PlayAndRecord : Fragment() {

    lateinit var viewModel: PlayAndRecordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentPlayAndRecordBinding.inflate(inflater)

        viewModel = ViewModelProvider(requireActivity()).get(PlayAndRecordViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.isRecording.observe(viewLifecycleOwner,
            Observer {
                if (it) {
                    recordButton.text = "Rec"
//                    notesPlayed.text = viewModel.nutki
                } else {
                    recordButton.text = ""
//                    notesPlayed.text = viewModel.nutki
                }
            })

        viewModel.myMelody.observe(viewLifecycleOwner,
        Observer { notesPlayed.text = viewModel.myMelody.value })


        return binding.root
    }
}
