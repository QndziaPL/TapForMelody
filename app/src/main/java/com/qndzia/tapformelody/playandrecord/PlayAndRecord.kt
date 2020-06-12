package com.qndzia.tapformelody.playandrecord

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.SaveMelodyDialogFragment
import com.qndzia.tapformelody.database.MelodyDatabase
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

//        val application = requireNotNull(this.activity).application
//
//        val dataSource = MelodyDatabase.getInstance(application).melodyDao

        viewModel = ViewModelProvider(requireActivity()).get(PlayAndRecordViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.isRecording.observe(viewLifecycleOwner,
            Observer {
                if (it) {
                    recordButton.text = "Rec"
                    notesPlayed.setTextColor(Color.RED)
                    playButton.visibility = View.INVISIBLE
                    saveButton.visibility = View.INVISIBLE
                    menuButton.visibility = View.INVISIBLE
                    searchButton.visibility = View.INVISIBLE

                } else {
                    recordButton.text = ""
                    notesPlayed.setTextColor(Color.BLACK)
                    playButton.visibility = View.VISIBLE
                    saveButton.visibility = View.VISIBLE
                    menuButton.visibility = View.VISIBLE
                    searchButton.visibility = View.VISIBLE

                }
            })

        viewModel.myMelody.observe(viewLifecycleOwner,
            Observer { notesPlayed.text = viewModel.myMelody.value })

        viewModel.noteListSize.observe(viewLifecycleOwner,
            Observer {
                if (it == 14 && viewModel.isRecording.value == true) Toast.makeText(
                    context,
                    "You can record only 1 note more!!!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            })

        viewModel.showSaveDialog.observe(viewLifecycleOwner,
            Observer {
                if (it) {
                    val dialogPopup = SaveMelodyDialogFragment()
                    dialogPopup.show(parentFragmentManager, "save_dialog")
                    viewModel.hideSaveDialog()
                }
            })



        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        saveButton.setOnClickListener {

//        }
//    }


}
