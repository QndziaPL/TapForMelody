package com.qndzia.tapformelody.matchedlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.recordedmelodies.TakeMelodyToMainScreen
import com.qndzia.tapformelody.songlist.Song
import com.qndzia.tapformelody.songlist.SongListAdapter

class MatchedListAdapter(private val librarySongList: List<Song>,
                         private var takeMelodyToMainScreen: TakeMelodyToMainScreen
) :
    RecyclerView.Adapter<MatchedListAdapter.SongListViewHolder>() {

    class SongListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.song_viewholder, parent, false)) {

        val songTitle: TextView = itemView.findViewById(R.id.recMelodyTitle)
        val songAuthor: TextView = itemView.findViewById(R.id.melodyRecordTime)
        val playMelody: Button = itemView.findViewById(R.id.playMelody)
        val playYoutube: Button = itemView.findViewById(R.id.playYoutube)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SongListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SongListViewHolder(inflater, parent)
    }


    override fun onBindViewHolder(holder: SongListViewHolder, position: Int) {
        val song: Song = librarySongList[position]
        holder.songTitle.text = song.title
        holder.songAuthor.text = song.author

        holder.playMelody.setOnClickListener {

            val melodyToSend = song.melody
            melodyToSend.title = song.title
            takeMelodyToMainScreen.takeMelody(melodyToSend)

        }
        holder.playYoutube.setOnClickListener {
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse
                    (song.link)
            )
            try {
                holder.songAuthor.context.startActivity(webIntent)
            } catch (e: ActivityNotFoundException) {
            }
        }
    }

    override fun getItemCount() = librarySongList.size
}