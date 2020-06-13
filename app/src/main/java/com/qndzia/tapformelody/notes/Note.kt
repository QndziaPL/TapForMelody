package com.qndzia.tapformelody.notes

import android.util.Log
import androidx.room.TypeConverters
import com.qndzia.tapformelody.R

//@TypeConverters(Converters::class)
//enum class Note(val noteName: String, val sound: Int, val id: Int
////                , val soundPool: Int
//) {
//
//    C("C", R.raw.c, 1),
//
//    Csharp("C#", R.raw.csharp, 2),
//
//    D("D", R.raw.d, 3),
//
//    Dsharp("D#", R.raw.dsharp, 4),
//
//    E("E", R.raw.e, 5),
//
//    F("F", R.raw.f, 6),
//
//    Fsharp("F#", R.raw.fsharp, 7),
//
//    G("G", R.raw.g, 8),
//
//    Gsharp("G#", R.raw.gsharp, 9),
//
//    A("A", R.raw.a, 10),
//
//    Asharp("A#", R.raw.asharp, 11),
//
//    H("H", R.raw.h, 12),
//
//    C2("C2", R.raw.c2, 13)
//
//}

//@TypeConverters(Converters::class)
data class Note(
    val noteName: String, val sound: Int, val id: Int
//                , val soundPool: Int
) {

    companion object {
        val C = Note("C", R.raw.c, 1)
        val Csharp = Note("C#", R.raw.csharp, 2)
        val D = Note("D", R.raw.d, 3)
        val Dsharp = Note("D#", R.raw.dsharp, 4)
        val E = Note("E", R.raw.e, 5)
        val F = Note("F", R.raw.f, 6)
        val Fsharp = Note("F#", R.raw.fsharp, 7)
        val G = Note("G", R.raw.g, 8)
        val Gsharp = Note("G#", R.raw.gsharp, 9)
        val A = Note("A", R.raw.a, 10)
        val Asharp = Note("A#", R.raw.asharp, 11)
        val H = Note("H", R.raw.h, 12)
        val C2 = Note("C", R.raw.c2, 13)
    }

    override fun toString(): String {
        return "Note(noteName='$noteName', sound=$sound, id=$id)"
    }

    fun toStringFromList(): String {
        return noteName
    }


}