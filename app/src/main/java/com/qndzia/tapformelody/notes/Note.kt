package com.qndzia.tapformelody.notes

import androidx.room.TypeConverters
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.Converters

@TypeConverters(Converters::class)
enum class Note(val noteName: String, val sound: Int, val id: Int
//                , val soundPool: Int
) {

    C("C", R.raw.c, 1),

    Csharp("C#", R.raw.csharp, 2),

    D("D", R.raw.d, 3),

    Dsharp("D#", R.raw.dsharp, 4),

    E("E", R.raw.e, 5),

    F("F", R.raw.f, 6),

    Fsharp("F#", R.raw.fsharp, 7),

    G("G", R.raw.g, 8),

    Gsharp("G#", R.raw.gsharp, 9),

    A("A", R.raw.a, 10),

    Asharp("A#", R.raw.asharp, 11),

    H("H", R.raw.h, 12),

    C2("C2", R.raw.c2, 13)

}