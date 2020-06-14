package com.qndzia.tapformelody.songlist

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.qndzia.tapformelody.MainActivity
import com.qndzia.tapformelody.R
import kotlinx.coroutines.withContext

class SongListAdapter(private val librarySongList: List<Song>) :
    RecyclerView.Adapter<SongListAdapter.SongListViewHolder>() {

    class SongListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.song_viewholder, parent, false)) {

//        private var songTitle: TextView? = null
//        private var songAuthor: TextView? = null
//        private var playMelody: Button? = null
//        private var playYoutube: Button? = null
//
//        init {
//            songTitle = itemView.findViewById(R.id.songTitle)
//            songAuthor = itemView.findViewById(R.id.songAuthor)
//            playMelody = itemView.findViewById(R.id.playMelody)
//            playYoutube = itemView.findViewById(R.id.playYoutube)
//        }
//
//        fun bind(song: Song) {
//            songTitle?.text = song.title
//            songAuthor?.text = song.author
//        }

        val songTitle: TextView = itemView.findViewById(R.id.songTitle)
        val songAuthor: TextView = itemView.findViewById(R.id.songAuthor)
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
//        holder.bind(song)
        holder.songTitle.text = song.title
        holder.songAuthor.text = song.author
        holder.playMelody.setOnClickListener {
            Toast.makeText(
                holder.songAuthor.context,
                "Not recorded yet. Work in progress!!!",
                Toast.LENGTH_LONG
            ).show()
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