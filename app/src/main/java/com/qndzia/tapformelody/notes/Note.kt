package com.qndzia.tapformelody.notes

import com.qndzia.tapformelody.R

//data class Note (
//    val name: String,
//    val sound: Int
//)

enum class Note(val noteName: String, val sound: Int) {

    C("C", R.raw.c),

    Csharp("Csharp", R.raw.csharp),

    D("D", R.raw.d),

    Dsharp("Dsharp", R.raw.dsharp),

    E("E", R.raw.e),

    F("F", R.raw.f),

    Fsharp("Fsharp", R.raw.fsharp),

    G("G", R.raw.g),

    Gsharp("Gsharp", R.raw.gsharp),

    A("A", R.raw.a),

    Asharp("Asharp", R.raw.asharp),

    H("H", R.raw.h),

    C2("C2", R.raw.c2),
}