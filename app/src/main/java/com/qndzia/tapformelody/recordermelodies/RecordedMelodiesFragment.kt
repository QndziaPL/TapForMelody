package com.qndzia.tapformelody.recordermelodies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.MelodyDatabase

private lateinit var viewModel: RecordedMelodiesViewModel

class RecordedMelodiesFragment() : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application

        val dataSource = MelodyDatabase.getInstance(application).melodyDao

        val viewModelFactory = RecordedMelodiesViewModelFactory(
            dataSource, application
        )

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(RecordedMelodiesViewModel::class.java)

        return inflater.inflate(R.layout.recorded_melodies_view_holder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewManager = LinearLayoutManager(activity)

        viewAdapter = RecordedMelodiesAdapter(viewModel.list.value!!)

        recyclerView = requireActivity().findViewById(R.id.recordedMelodiesRecyclerView)

        recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

}
