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


enum class IntervalEnumNotes(
    val set: List<Pair<Note, Note>>
    , val halftoneIndex: Int
) {
    PRYMALUBOKTAWA(
        listOf(
            Pair(Note.C, Note.C),
            Pair(Note.Csharp, Note.Csharp),
            Pair(Note.D, Note.D),
            Pair(Note.Dsharp, Note.Dsharp),
            Pair(Note.E, Note.E),
            Pair(Note.F, Note.F),
            Pair(Note.Fsharp, Note.Fsharp),
            Pair(Note.G, Note.G),
            Pair(Note.Gsharp, Note.Gsharp),
            Pair(Note.A, Note.A),
            Pair(Note.Asharp, Note.Asharp),
            Pair(Note.H, Note.H)
        ),
        0
    ),
    SEKUNDAMLUBSEPTYMAW(
        listOf(
            Pair(Note.C, Note.Csharp), Pair(Note.Csharp, Note.C),
            Pair(Note.Csharp, Note.D), Pair(Note.D, Note.Csharp),
            Pair(Note.D, Note.Dsharp), Pair(Note.Dsharp, Note.D),
            Pair(Note.Dsharp, Note.E), Pair(Note.E, Note.Dsharp),
            Pair(Note.E, Note.F), Pair(Note.F, Note.E),
            Pair(Note.F, Note.Fsharp), Pair(Note.Fsharp, Note.F),
            Pair(Note.Fsharp, Note.G), Pair(Note.G, Note.Fsharp),
            Pair(Note.G, Note.Gsharp), Pair(Note.Gsharp, Note.G),
            Pair(Note.Gsharp, Note.A), Pair(Note.A, Note.Gsharp),
            Pair(Note.A, Note.Asharp), Pair(Note.Asharp, Note.A),
            Pair(Note.Asharp, Note.H), Pair(Note.H, Note.Asharp),
            Pair(Note.H, Note.C), Pair(Note.C, Note.H)
        ),
        1
    ),
    SEKUNDAWLUBSEPTYMAM(
        listOf(
            Pair(Note.C, Note.D), Pair(Note.D, Note.C),
            Pair(Note.Csharp, Note.Dsharp), Pair(Note.Dsharp, Note.Csharp),
            Pair(Note.D, Note.E), Pair(Note.E, Note.D),
            Pair(Note.Dsharp, Note.F), Pair(Note.F, Note.Dsharp),
            Pair(Note.E, Note.Fsharp), Pair(Note.Fsharp, Note.E),
            Pair(Note.F, Note.G), Pair(Note.G, Note.F),
            Pair(Note.Fsharp, Note.Gsharp), Pair(Note.Gsharp, Note.Fsharp),
            Pair(Note.G, Note.A), Pair(Note.A, Note.G),
            Pair(Note.Gsharp, Note.Asharp), Pair(Note.Asharp, Note.Gsharp),
            Pair(Note.A, Note.H), Pair(Note.H, Note.A),
            Pair(Note.Asharp, Note.C), Pair(Note.C, Note.Asharp),
            Pair(Note.H, Note.Csharp), Pair(Note.Csharp, Note.H)
        ),
        2
    ),
    TERCJAMLUBSEKSTAW(
        listOf(
            Pair(Note.C, Note.Dsharp), Pair(Note.Dsharp, Note.C),
            Pair(Note.Csharp, Note.E), Pair(Note.E, Note.Csharp),
            Pair(Note.D, Note.F), Pair(Note.F, Note.D),
            Pair(Note.Dsharp, Note.Fsharp), Pair(Note.Fsharp, Note.Dsharp),
            Pair(Note.E, Note.G), Pair(Note.G, Note.E),
            Pair(Note.F, Note.Gsharp), Pair(Note.Gsharp, Note.F),
            Pair(Note.Fsharp, Note.A), Pair(Note.A, Note.Fsharp),
            Pair(Note.G, Note.Asharp), Pair(Note.Asharp, Note.G),
            Pair(Note.Gsharp, Note.H), Pair(Note.H, Note.Gsharp),
            Pair(Note.A, Note.C), Pair(Note.C, Note.A),
            Pair(Note.Asharp, Note.Csharp), Pair(Note.Csharp, Note.Asharp),
            Pair(Note.H, Note.D), Pair(Note.D, Note.H)
        ),
        3
    ),
    TERCJAWLUBSEKSTAM(
        listOf(
            Pair(Note.C, Note.E), Pair(Note.E, Note.C),
            Pair(Note.Csharp, Note.F), Pair(Note.F, Note.Csharp),
            Pair(Note.D, Note.Fsharp), Pair(Note.Fsharp, Note.D),
            Pair(Note.Dsharp, Note.G), Pair(Note.G, Note.Dsharp),
            Pair(Note.E, Note.Gsharp), Pair(Note.Gsharp, Note.E),
            Pair(Note.F, Note.A), Pair(Note.A, Note.F),
            Pair(Note.Fsharp, Note.Asharp), Pair(Note.Asharp, Note.Fsharp),
            Pair(Note.G, Note.H), Pair(Note.H, Note.G),
            Pair(Note.Gsharp, Note.C), Pair(Note.C, Note.Gsharp),
            Pair(Note.A, Note.Csharp), Pair(Note.Csharp, Note.A),
            Pair(Note.Asharp, Note.D), Pair(Note.D, Note.Asharp),
            Pair(Note.H, Note.Dsharp), Pair(Note.Dsharp, Note.H)
        ),
        4
    ),
    KWARTACZLUBKWINTACZ(
        listOf(
            Pair(Note.C, Note.F), Pair(Note.F, Note.C),
            Pair(Note.Csharp, Note.Fsharp), Pair(Note.Fsharp, Note.Csharp),
            Pair(Note.D, Note.G), Pair(Note.G, Note.D),
            Pair(Note.Dsharp, Note.Gsharp), Pair(Note.Gsharp, Note.Dsharp),
            Pair(Note.E, Note.A), Pair(Note.A, Note.E),
            Pair(Note.F, Note.Asharp), Pair(Note.Asharp, Note.F),
            Pair(Note.Fsharp, Note.H), Pair(Note.H, Note.Fsharp),
            Pair(Note.G, Note.C), Pair(Note.C, Note.G),
            Pair(Note.Gsharp, Note.Csharp), Pair(Note.Csharp, Note.Gsharp),
            Pair(Note.A, Note.D), Pair(Note.D, Note.A),
            Pair(Note.Asharp, Note.Dsharp), Pair(Note.Dsharp, Note.Asharp),
            Pair(Note.H, Note.E), Pair(Note.E, Note.H)
        ),
        5
    ),
    TRYTON(
        listOf(
            Pair(Note.C, Note.Fsharp), Pair(Note.Fsharp, Note.C),
            Pair(Note.Csharp, Note.G), Pair(Note.G, Note.Csharp),
            Pair(Note.D, Note.Gsharp), Pair(Note.Gsharp, Note.D),
            Pair(Note.Dsharp, Note.A), Pair(Note.A, Note.Dsharp),
            Pair(Note.E, Note.Asharp), Pair(Note.Asharp, Note.E),
            Pair(Note.F, Note.H), Pair(Note.H, Note.F)
        ),
        6
    )

}
