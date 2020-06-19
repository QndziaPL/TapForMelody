package com.qndzia.tapformelody.songlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.recordermelodies.TakeMelodyToMainScreen


class SongListFragment : Fragment(), TakeMelodyToMainScreen {
        private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_song_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = SongListAdapter(defaultSongList, this)

        recyclerView = requireActivity().findViewById(R.id.songListRecyclerView)

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun takeMelody(melody: Melody) {
        findNavController().navigate(SongListFragmentDirections.actionSongListFragmentToPlayAndRecord(melodySavedOrFromLibrary = melody))
    }

}
