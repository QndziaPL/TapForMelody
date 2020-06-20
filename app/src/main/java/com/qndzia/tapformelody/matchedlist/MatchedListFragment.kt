package com.qndzia.tapformelody.matchedlist

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
import com.qndzia.tapformelody.databinding.FragmentMatchedListBinding
import com.qndzia.tapformelody.recordedmelodies.TakeMelodyToMainScreen


private lateinit var viewModel: MatchedListViewModel

class MatchedListFragment : Fragment(), TakeMelodyToMainScreen{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val arguments = MatchedListFragmentArgs.fromBundle(requireArguments())

        val binding = FragmentMatchedListBinding.inflate(inflater)

        val viewModelFactory = MatchedListViewModelFactory()

        viewModel = ViewModelProvider(
            requireActivity(),
            viewModelFactory
        ).get(MatchedListViewModel::class.java)

       binding.viewModel = viewModel

        val adapter = MatchedListAdapter(arguments.matchedList.songList, this)

        binding.songListRecyclerView.layoutManager = LinearLayoutManager(context)

        binding.songListRecyclerView.adapter = adapter

        viewModel.onBackPressed.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(MatchedListFragmentDirections.actionMatchedListFragmentToPlayAndRecord())
                viewModel.onFinishedNavBack()
            }
        })

        return binding.root
    }

    override fun takeMelody(melody: Melody) {
        findNavController().navigate(
            MatchedListFragmentDirections.actionMatchedListFragmentToPlayAndRecord(
                melodySavedOrFromLibrary = melody
            )
        )
    }

}