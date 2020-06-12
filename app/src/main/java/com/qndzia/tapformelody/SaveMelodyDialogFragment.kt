package com.qndzia.tapformelody

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class SaveMelodyDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.save_melody_dialog, null))

                .setPositiveButton("save", DialogInterface.OnClickListener { dialog, which ->


                })
                .setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                    getDialog()?.cancel()
                })
            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")
    }
}