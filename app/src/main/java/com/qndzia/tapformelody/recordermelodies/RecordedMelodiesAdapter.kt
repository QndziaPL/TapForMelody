package com.qndzia.tapformelody.recordermelodies

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.Melody

class RecordedMelodiesAdapter (private val recordedMelodies: List<Melody>) :
    RecyclerView.Adapter<RecordedMelodiesAdapter.RecordedMelodiesViewHolder>() {

    class RecordedMelodiesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.recorded_melodies_view_holder, parent, false)) {

        val melodyTitle: TextView = itemView.findViewById(R.id.recMelodyTitle)
        val timeRecorded: TextView = itemView.findViewById(R.id.melodyRecordTime)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecordedMelodiesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecordedMelodiesViewHolder(inflater, parent)
    }


    override fun onBindViewHolder(holder: RecordedMelodiesViewHolder, position: Int) {
        val melody: Melody = recordedMelodies[position]
        holder.melodyTitle.text = melody.title
        holder.timeRecorded.text = melody.timeOfRecord.toString()


    }

    override fun getItemCount() = recordedMelodies.size
}