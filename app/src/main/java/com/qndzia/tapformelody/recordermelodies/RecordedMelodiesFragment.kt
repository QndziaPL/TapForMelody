package com.qndzia.tapformelody.recordermelodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDatabase
import com.qndzia.tapformelody.databinding.FragmentRecordedMelodiesBinding

private lateinit var viewModel: RecordedMelodiesViewModel
class RecordedMelodiesFragment : Fragment(), DatabaseOperations, TakeMelodyToMainScreen {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentRecordedMelodiesBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val dataSource = MelodyDatabase.getInstance(application).melodyDao

        val viewModelFactory = RecordedMelodiesViewModelFactory(dataSource)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory)
            .get(RecordedMelodiesViewModel::class.java)


        binding.viewModel = viewModel

        val adapter = RecordedMelodiesAdapter2(this, this)

        binding.recordedMelodiesRecyclerView.layoutManager = LinearLayoutManager(context)


        binding.recordedMelodiesRecyclerView.adapter = adapter


        viewModel.list.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it

            }
        })

        viewModel.onBackPressed.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(RecordedMelodiesFragmentDirections.actionRecordedMelodiesFragmentToPlayAndRecord())
                viewModel.onFinishedNavBack()
            }
        })


        return binding.root
    }


    override fun delete(melody: Melody) {
        viewModel.deleteMelody(melody)
    }

    override fun takeMelody(melody: Melody) {
        findNavController().navigate(RecordedMelodiesFragmentDirections.actionRecordedMelodiesFragmentToPlayAndRecord(melodySavedOrFromLibrary = melody))
    }
}
