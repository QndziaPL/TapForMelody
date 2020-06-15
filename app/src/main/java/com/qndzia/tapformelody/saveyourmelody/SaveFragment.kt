package com.qndzia.tapformelody.saveyourmelody

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.qndzia.tapformelody.database.MelodyDatabase
import com.qndzia.tapformelody.databinding.FragmentSaveBinding
import kotlinx.android.synthetic.main.fragment_save.*


private lateinit var viewModel: SaveViewModel

class SaveFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentSaveBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val dataSource = MelodyDatabase.getInstance(application).melodyDao

        val arguments = SaveFragmentArgs.fromBundle(requireArguments())

        val viewModelFactory = SaveViewModelFactory(
            arguments.myStringMelody,
            arguments.myMelody,
            dataSource,
            application
        )

        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory).get(SaveViewModel::class.java)

        binding.viewModel = viewModel

        viewModel.onSavePressed.observe(viewLifecycleOwner, Observer {
            if (it) {
                viewModel.saveInDb(recMelodyTitle.text.toString())
                viewModel.doneSaving()
                findNavController().navigate(SaveFragmentDirections.actionSaveFragmentToPlayAndRecord())

            }
        })

//        viewModel.dblist.observe(viewLifecycleOwner,
//        Observer {
//            texttestdbsize.text = viewModel.dblist.value.toString()
//        })



        return binding.root
    }

}
