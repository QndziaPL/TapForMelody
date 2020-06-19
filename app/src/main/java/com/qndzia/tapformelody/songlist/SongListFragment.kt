package com.qndzia.tapformelody.songlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.databinding.FragmentSongListBinding
import com.qndzia.tapformelody.recordermelodies.TakeMelodyToMainScreen

private lateinit var viewModel: SongListViewModel

class SongListFragment : Fragment(), TakeMelodyToMainScreen {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSongListBinding.inflate(inflater)

        val viewModelFactory = SongListViewModelFactory()

        viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(SongListViewModel::class.java)

        binding.viewModel = viewModel

        val adapter = SongListAdapter(defaultSongList, this)

        binding.songListRecyclerView.layoutManager = LinearLayoutManager(context)

        binding.songListRecyclerView.adapter = adapter

        viewModel.onBackPressed.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(SongListFragmentDirections.actionSongListFragmentToPlayAndRecord())
                viewModel.onFinishedNavBack()
            }
        })

        return binding.root
    }

    override fun takeMelody(melody: Melody) {
        findNavController().navigate(
            SongListFragmentDirections.actionSongListFragmentToPlayAndRecord(
                melodySavedOrFromLibrary = melody
            )
        )
    }

}
