package com.qndzia.tapformelody.songlist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.recordermelodies.TakeMelodyToMainScreen

class SongListAdapter(private val librarySongList: List<Song>,
var takeMelodyToMainScreen: TakeMelodyToMainScreen) :
    RecyclerView.Adapter<SongListAdapter.SongListViewHolder>() {

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
    ): SongListAdapter.SongListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SongListViewHolder(inflater, parent)
    }


    override fun onBindViewHolder(holder: SongListViewHolder, position: Int) {
        val song: Song = librarySongList[position]
        holder.songTitle.text = song.title
        holder.songAuthor.text = song.author

        val mediaPlayer = MediaPlayer.create(holder.songAuthor.context, song.mp3)

        holder.playMelody.setOnClickListener {

            val melodyToSend = song.melody
            melodyToSend.title = song.title
            takeMelodyToMainScreen.takeMelody(melodyToSend)

//            mediaPlayer.start()
//
//            Toast.makeText(
//                holder.songAuthor.context,
//                "Not everything recorder yet. Work in progress!!!",
//                Toast.LENGTH_LONG
//            ).show()
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

                Log.e("TAG", e.toString())
            }
        }
    }

    override fun getItemCount() = librarySongList.size
}