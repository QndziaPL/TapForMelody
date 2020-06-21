package com.qndzia.tapformelody.notes

import android.os.Parcelable
import com.qndzia.tapformelody.R
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Note(
    val noteName: String, val sound: Int, val id: Int
) : Parcelable {

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