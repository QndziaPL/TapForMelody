package com.qndzia.tapformelody.playandrecord

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.MelodyDatabase
import com.qndzia.tapformelody.databinding.FragmentPlayAndRecordBinding
import com.qndzia.tapformelody.songlist.SongList
import com.qndzia.tapformelody.songlist.defaultSongList
import kotlinx.android.synthetic.main.fragment_play_and_record.*


private lateinit var viewModel: PlayAndRecordViewModel

class PlayAndRecord : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentPlayAndRecordBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val dataSource = MelodyDatabase.getInstance(application).melodyDao

        val arguments = PlayAndRecordArgs.fromBundle(requireArguments())

        val viewModelFactory =
            PlayAndRecordViewModelFactory(arguments.labelsOn, dataSource, application)

        viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(PlayAndRecordViewModel::class.java)

        binding.viewModel = viewModel



        viewModel.isRecording.observe(viewLifecycleOwner,
            Observer {
                if (it) {
                    viewModel.onMelodyStartedRecording()
                    recordButton.text = getString(R.string.rec_button_text)
                    notesPlayed.setTextColor(Color.RED)
                    playButton.visibility = View.INVISIBLE
                    saveButton.visibility = View.INVISIBLE
                    menuButton.visibility = View.INVISIBLE
                    searchButton.visibility = View.INVISIBLE


                } else {
                    viewModel.onMelodyFinishedRecording()
                    recordButton.text = ""
                    notesPlayed.setTextColor(Color.BLACK)
                    playButton.visibility = View.VISIBLE
                    saveButton.visibility = View.VISIBLE
                    menuButton.visibility = View.VISIBLE
                    searchButton.visibility = View.VISIBLE
                    if (viewModel.noteListSize.value == 0) {
                        searchButton.visibility = View.INVISIBLE

                    }


                }
            })

        viewModel.isPlaying.observe(viewLifecycleOwner,
            Observer {
                if (it) {
                    playButton.isClickable = false
                    menuButton.isClickable = false
                    saveButton.isClickable = false
                    recordButton.isClickable = false
                    searchButton.isClickable = false
                } else {
                    playButton.isClickable = true
                    menuButton.isClickable = true
                    saveButton.isClickable = true
                    recordButton.isClickable = true
                    searchButton.isClickable = true

                }
            })



        viewModel.myMelody.observe(viewLifecycleOwner,
            Observer { notesPlayed.text = viewModel.myMelody.value })

        viewModel.noteListSize.observe(viewLifecycleOwner,
            Observer {
                if (it == 14 && viewModel.isRecording.value == true) {
                    Toast.makeText(
                        context,
                        "You can record only 1 note more!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (it == 0) {
                    searchButton.visibility = View.INVISIBLE

                } else {
                    if (viewModel.isRecording.value == false) {
                        searchButton.visibility = View.VISIBLE

                    }
                }

            })

        viewModel.navigateToSaveFragment.observe(viewLifecycleOwner,
            Observer {
                if (it) {

                    findNavController().navigate(
                        PlayAndRecordDirections.actionPlayAndRecordToSaveFragment(
                            viewModel.myMelody.value!!,
                            viewModel.mySuperMelody.value!!
                        )
                    )
                    viewModel.onNavigatingToSaveFragmentFinished()

                }
            })


        viewModel.showMenu.observe(viewLifecycleOwner,
            Observer {
                if (it) {

                    val popup = PopupMenu(activity, menuButton)
                    val menuInflater: MenuInflater = popup.menuInflater
                    menuInflater.inflate(R.menu.main_menu, popup.menu)
                    popup.show()

                    popup.setOnMenuItemClickListener { item ->
                        when (item.itemId) {
                            R.id.labelsOn -> {
                                viewModel.labelsOnOff()
                            }
                            R.id.songLibrary -> {
                                findNavController().navigate(
                                    PlayAndRecordDirections.actionPlayAndRecordToSongListFragment()
                                )
                            }
                            R.id.recordedMelodies -> {
                                findNavController().navigate(
                                    PlayAndRecordDirections.actionPlayAndRecordToRecordedMelodiesFragment()
                                )
                            }
                        }
                        true
                    }

                    popup.setOnDismissListener {
                        viewModel.turnOffMenuNavigation()
                    }

                }
            })

        viewModel.labelsOnLiveData.observe(viewLifecycleOwner,
            Observer {
                if (it) {
                    keyCLabel.visibility = View.VISIBLE
                    keyCsharpLabel.visibility = View.VISIBLE
                    keyDLabel.visibility = View.VISIBLE
                    keyDsharpLabel.visibility = View.VISIBLE
                    keyELabel.visibility = View.VISIBLE
                    keyFLabel.visibility = View.VISIBLE
                    keyFsharpLabel.visibility = View.VISIBLE
                    keyGLabel.visibility = View.VISIBLE
                    keyGsharpLabel.visibility = View.VISIBLE
                    keyALabel.visibility = View.VISIBLE
                    keyAsharpLabel.visibility = View.VISIBLE
                    keyHLabel.visibility = View.VISIBLE
                    keyC2Label.visibility = View.VISIBLE

                } else {
                    keyCLabel.visibility = View.GONE
                    keyCsharpLabel.visibility = View.GONE
                    keyDLabel.visibility = View.GONE
                    keyDsharpLabel.visibility = View.GONE
                    keyELabel.visibility = View.GONE
                    keyFLabel.visibility = View.GONE
                    keyFsharpLabel.visibility = View.GONE
                    keyGLabel.visibility = View.GONE
                    keyGsharpLabel.visibility = View.GONE
                    keyALabel.visibility = View.GONE
                    keyAsharpLabel.visibility = View.GONE
                    keyHLabel.visibility = View.GONE
                    keyC2Label.visibility = View.GONE

                }
            })

        viewModel.showSnackbarWithMatchingSongs.observe(viewLifecycleOwner, Observer {
            if (it){
                Snackbar.make(requireView(), "It's a match! You played something famous!", Snackbar.LENGTH_LONG)
                    .setAction("let's check this out") {
                        val list = viewModel.matchSongs(viewModel.mySuperMelody.value, defaultSongList)
                        val songList = SongList(list)

                        findNavController().navigate(PlayAndRecordDirections.actionPlayAndRecordToMatchedListFragment(songList))
                    }
                    .show()
                viewModel.stopShowingSearchSnackbar()
            }
        })


        return binding.root
    }

    override fun onResume() {
        super.onResume()

        val arguments = PlayAndRecordArgs.fromBundle(requireArguments())

        if (arguments.melodySavedOrFromLibrary != null) {
            viewModel.loadRecordedMelody(arguments.melodySavedOrFromLibrary, "recorded")
            viewModel.preventSaving()
        }

        if (arguments.blockSave) viewModel.preventSaving()
    }

}

