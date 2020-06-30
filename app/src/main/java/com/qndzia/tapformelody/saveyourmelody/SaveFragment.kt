package com.qndzia.tapformelody.saveyourmelody

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
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
                val newTitle = if (recMelodyTitle.text.toString() == "") "yourMelody" else recMelodyTitle.text.toString()
                viewModel.assignMelodyValues(newTitle)
                findNavController().navigate(SaveFragmentDirections.actionSaveFragmentToPlayAndRecord())
                viewModel.doneSaving()
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recMelodyTitle.requestFocus()
        showKeyboard()
    }

    private fun showKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}
