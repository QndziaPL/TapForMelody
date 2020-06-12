package com.qndzia.tapformelody.songlist

import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.notes.Note
import kotlin.math.E

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

val defaultSongList = mutableListOf(
    Song(
        "Wszystko czego dzis chcę", "Izabela Trojanowska",
        listOf(
            Note.G, Note.A, Note.H,Note.A, Note.G, Note.H, Note.A, Note.A, Note.A, Note.D, Note.A,
            Note.H, Note.A, Note.G, Note.H, Note.A, Note.A, Note.A, Note.D, Note.A, Note.C, Note.C,
            Note.C, Note.C, Note.C, Note.C, Note.H, Note.H, Note.H, Note.A, Note.G, Note.A, Note.H
        ), link = "https://www.youtube.com/watch?v=olkNnmhMj7Y"
    ),
    Song(
        "Hedwig's Theme ( Harry Potter )", "John Williams",
        listOf(
            Note.H, Note.E, Note.G, Note.Fsharp, Note.E, Note.H, Note.A, Note.Fsharp, Note.E, Note.G,
            Note.Fsharp, Note.Dsharp, Note.F, Note.H, Note.H, Note.E, Note.G, Note.Fsharp, Note.E,
            Note.H, Note.D, Note.Csharp, Note.C, Note.Gsharp, Note.C, Note.H, Note.Asharp,
            Note.Asharp, Note.G, Note.E
        ), link = "https://www.youtube.com/watch?v=GTXBLyp7_Dw"
    ),
    Song("Happy Birthday To You", "Traditional",
    listOf(Note.D, Note.D, Note.E, Note.D, Note.G, Note.Fsharp, Note.D, Note.D, Note.E, Note.D,
    Note.A, Note.G, Note.D, Note.D, Note.D, Note.H, Note.G, Note.Fsharp, Note.E, Note.C, Note.C,
    Note.H, Note.G, Note.A, Note.G),
        link = "https://www.youtube.com/watch?v=qCJSNMqub8g")
)