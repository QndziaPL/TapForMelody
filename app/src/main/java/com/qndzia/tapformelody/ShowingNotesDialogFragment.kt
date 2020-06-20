package com.qndzia.tapformelody

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.qndzia.tapformelody.database.Melody
import kotlinx.android.synthetic.main.dialog_showing_notes.*

class ShowingNotesDialogFragment(val melody: Melody) : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
//            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater


            builder.setView(inflater.inflate(R.layout.dialog_showing_notes, null))
            view?.setOnClickListener {
                dialog?.dismiss()
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        songNotesTextView.text = melody.melody.toString()

    }



}