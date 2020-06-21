package com.qndzia.tapformelody

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.melodyToString
import kotlinx.android.synthetic.main.dialog_showing_notes.*

class ShowingNotesDialogFragment(val melody: Melody) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.dialog_showing_notes, container, false)
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog = dialog!!
        dialog.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            it.window!!.setLayout(width, height)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        songNotesTextView.text = melodyToString(melody)
        view.setOnClickListener {
            dialog!!.dismiss()
        }
    }

}