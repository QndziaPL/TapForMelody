package com.qndzia.tapformelody.songlist

import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.notes.Note

class Song(
    val title: String,
    val author: String,
    val melody: Melody,
    val link: String
) {

    override fun toString(): String {
        return "\nTitle=[$title], Author=[$author]"
    }
}

val defaultSongList = mutableListOf(
    Song(
        "Wszystko czego dzis chcę", "Izabela Trojanowska",
        Melody(melody = listOf(
            Note.G, Note.A, Note.H,Note.A, Note.G, Note.H, Note.A, Note.A, Note.A, Note.D, Note.A,
            Note.H, Note.A, Note.G, Note.H, Note.A, Note.A, Note.A, Note.D, Note.A, Note.C, Note.C,
            Note.C, Note.C, Note.C, Note.C, Note.H, Note.H, Note.H, Note.A, Note.G, Note.A, Note.H))
        , link = "https://www.youtube.com/watch?v=olkNnmhMj7Y"
    ),

    Song(
        "Hedwig's Theme ( Harry Potter )", "John Williams",
        Melody(melody = listOf(
            Note.H, Note.E, Note.G, Note.Fsharp, Note.E, Note.H, Note.A, Note.Fsharp, Note.E, Note.G,
            Note.Fsharp, Note.Dsharp, Note.F, Note.H, Note.H, Note.E, Note.G, Note.Fsharp, Note.E,
            Note.H, Note.D, Note.Csharp, Note.C, Note.Gsharp, Note.C, Note.H, Note.Asharp,
            Note.Asharp, Note.G, Note.E
        )), link = "https://www.youtube.com/watch?v=GTXBLyp7_Dw"
    ),

    Song("Happy Birthday To You", "Traditional",
        Melody(melody = listOf(Note.D, Note.D, Note.E, Note.D, Note.G, Note.Fsharp, Note.D, Note.D, Note.E, Note.D,
    Note.A, Note.G, Note.D, Note.D, Note.D, Note.H, Note.G, Note.Fsharp, Note.E, Note.C, Note.C,
    Note.H, Note.G, Note.A, Note.G)),
        link = "https://www.youtube.com/watch?v=qCJSNMqub8g"
    ),

    Song("Wlazł kotek na płotek", "Traditional",
    Melody(melody = listOf(Note.G, Note.E, Note.E, Note.F, Note.D, Note.D, Note.C, Note.E, Note.G,
    Note.G, Note.E, Note.E, Note.F, Note.D, Note.D, Note.C, Note.E, Note.C)),
    link = "https://www.youtube.com/watch?v=5Y4sdAspkSc"
    ),

    Song("Oops!... I did it again", "Britney Spears",
        Melody(melody = listOf(Note.A, Note.D, Note.Csharp, Note.D, Note.E, Note.D, Note.D, Note.C, Note.E,
        Note.G, Note.F, Note.C, Note.G, Note.A, Note.G, Note.F, Note.A, Note.G, Note.F, Note.D, Note.Csharp,
        Note.A, Note.D, Note.Csharp, Note.D, Note.E, Note.D, Note.C, Note.C, Note.E, Note.G, Note.Asharp,
        Note.A, Note.G, Note.F, Note.A, Note.A, Note.G, Note.F, Note.A)),
    link = "https://www.youtube.com/watch?v=CduA0TULnow"
    ),

    Song("Usta Mariana", "Andrzej Rosiewicz",
    Melody(melody = listOf(Note.C, Note.Asharp, Note.Gsharp, Note.G, Note.F, Note.Dsharp, Note.F, Note.G, Note.C,
    Note.C, Note.C, Note.Dsharp, Note.F, Note.Asharp, Note.C, Note.Csharp, Note.C, Note.Asharp, Note.Gsharp, Note.F)),
    link = "https://www.youtube.com/watch?v=bluD4WhrffU"
    ),

    Song("Twinkle Twinkle Little Star", "Mozart",
    Melody(melody = listOf(Note.C, Note.C, Note.G, Note.G, Note.A, Note.A, Note.G, Note.F, Note.F, Note.E, Note.E,
    Note.D, Note.D, Note.C, Note.G, Note.G, Note.F, Note.F, Note.E, Note.E, Note.D, Note.G, Note.G, Note.F,
        Note.F, Note.E, Note.E, Note.D, Note.C, Note.C, Note.G, Note.G, Note.A, Note.A, Note.G, Note.F, Note.F,
    Note.E, Note.E, Note.D, Note.D, Note.C)),
    link = "https://www.youtube.com/watch?v=zE0Fwm7gv1c"
    ),

    Song("Somewhere Over The Rainbow", "Judy Garland",
    Melody(melody = listOf(Note.C, Note.C2, Note.H, Note.G, Note.A, Note.H, Note.C2, Note.C, Note.A, Note.G, Note.F, Note.F,
    Note.E, Note.C, Note.D, Note.E, Note.F, Note.D, Note.H, Note.C, Note.D, Note.E, Note.C)),
    link = "https://www.youtube.com/watch?v=PSZxmZmBfnU")


)