package com.qndzia.tapformelody.recordedmelodies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.Melody
import java.text.SimpleDateFormat


class RecordedMelodiesAdapter2(var dbOperations: DatabaseOperations,
                               var takeMelodyToMainScreen: TakeMelodyToMainScreen) : RecyclerView.Adapter<ViewHolder>() {

    var data = listOf<Melody>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
        holder.deleteButton.setOnClickListener {
            dbOperations.delete(item)
        }
        holder.playRecordedButton.setOnClickListener {
            takeMelodyToMainScreen.takeMelody(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


}

interface DatabaseOperations{
    fun delete(melody: Melody)
//    fun deleteAll()
}
interface TakeMelodyToMainScreen{
    fun takeMelody(melody: Melody)
}

interface ShowMelodyNotesDialogInterface{
    fun showMelodyDialog(melody: Melody)
}

class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val melodyTitle: TextView = itemView.findViewById(R.id.recMelodyTitle)
    private val timeRecorded: TextView = itemView.findViewById(R.id.melodyRecordTime)
    val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
    val playRecordedButton: Button = itemView.findViewById(R.id.playRecordedButton)

    fun bind(item: Melody) {
        melodyTitle.text = item.title.capitalize()
        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss")
        val result = item.timeOfRecord
        timeRecorded.text = sdf.format(result)
    }

    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)

            val view = layoutInflater.inflate(R.layout.recorded_melodies_view_holder, parent, false)

            return ViewHolder(view)
        }
    }


}