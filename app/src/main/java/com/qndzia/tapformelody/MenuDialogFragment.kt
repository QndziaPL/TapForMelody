package com.qndzia.tapformelody

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_play_and_record.*
import kotlinx.android.synthetic.main.menu_dialog.*
import java.lang.IllegalStateException

class MenuDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.menu_dialog, null))

//            builder.


            builder.create()



        } ?: throw IllegalStateException("Activity cannot be null")
    }


}