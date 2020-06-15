package com.qndzia.tapformelody

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.save_melody_dialog.*
import java.lang.IllegalStateException

class SaveMelodyDialogFragment : DialogFragment() {




    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.save_melody_dialog, null))

                .setPositiveButton("save", DialogInterface.OnClickListener { dialog, which ->
                    Log.d("dialogev",melodyNameEditText.toString() )

//                    findNavController().navigate(
//                        SaveMelodyDialogFragmentDirections.actionSaveMelodyDialogFragmentToPlayAndRecord(
//                            melodyTitle = melodyNameEditText.toString()
//                        )
//                    )

                })
                .setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                    getDialog()?.cancel()
                })

            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")
    }

    //
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        return   inflater.inflate(R.layout.save_melody_dialog, container,false)
//
//
//    }




}