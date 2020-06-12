package com.qndzia.tapformelody.songlist

import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.notes.Note

class Song(
    val title: String,
    val author: String,
    val melody: List<Note>,
    val mp3: Int = R.raw.c,
    val link: String
) {

    fun play() {

    }
}