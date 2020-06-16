package com.qndzia.tapformelody.recordermelodies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.Melody


class RecordedMelodiesAdapter2 : RecyclerView.Adapter<ViewHolder>() {

    var data = listOf<Melody>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


}


class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val melodyTitle: TextView = itemView.findViewById(R.id.recMelodyTitle)
    val timeRecorded: TextView = itemView.findViewById(R.id.melodyRecordTime)

    fun bind(item: Melody) {
        val res = itemView.context.resources

        melodyTitle.text = item.title
        timeRecorded.text = item.timeOfRecord.toString()

//        qualityImage.setImageResource(when (item.sleepQuality) {
//            0 -> R.drawable.ic_sleep_0
//            1 -> R.drawable.ic_sleep_1
//            2 -> R.drawable.ic_sleep_2
//            3 -> R.drawable.ic_sleep_3
//            4 -> R.drawable.ic_sleep_4
//            5 -> R.drawable.ic_sleep_5
//            else -> R.drawable.ic_sleep_active
//        })
    }


    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)

            val view = layoutInflater.inflate(R.layout.recorded_melodies_view_holder, parent, false)

            return ViewHolder(view)
        }
    }
}