package com.qndzia.tapformelody.recordermelodies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDatabase
import com.qndzia.tapformelody.databinding.FragmentRecordedMelodiesBinding
import kotlinx.android.synthetic.main.fragment_recorded_melodies.*


class RecordedMelodiesFragment() : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: FragmentRecordedMelodiesBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_recorded_melodies, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = MelodyDatabase.getInstance(application).melodyDao

        val viewModelFactory = RecordedMelodiesViewModelFactory(dataSource, application)

        val viewModel = ViewModelProvider(requireActivity(), viewModelFactory)
            .get(RecordedMelodiesViewModel::class.java)



        binding.viewModel = viewModel

        val adapter = RecordedMelodiesAdapter2()

        // tu nie jestem pewien \/ \/ \/ \/ \/ \/
        binding.recordedMelodiesRecyclerView.adapter = adapter



        viewModel.melodies.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })


        return binding.root
    }



}
