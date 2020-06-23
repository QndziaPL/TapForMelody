package com.qndzia.tapformelody.songlist

import android.os.Parcelable
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.notes.Note
import kotlinx.android.parcel.Parcelize
import kotlin.math.E

@Parcelize
class SongList(val songList: List<Song>) : Parcelable

@Parcelize
class Song(
    val title: String,
    val author: String,
    val melody: Melody,
    val link: String
) : Parcelable {

    override fun toString(): String {
        return "\nTitle=[$title], Author=[$author]"
    }
}

val defaultSongList = mutableListOf(
    Song(
        "Wszystko czego dzis chcę", "Izabela Trojanowska",
        Melody(melody = listOf(
            Note.G, Note.A, Note.H,Note.A, Note.G, Note.H, Note.A, Note.A, Note.A, Note.D, Note.A,
            Note.H, Note.A, Note.G, Note.H, Note.A, Note.A, Note.A, Note.D, Note.A, Note.C2, Note.C2,
            Note.C2, Note.C2, Note.C2, Note.C2, Note.H, Note.H, Note.H, Note.A, Note.G, Note.A))
        , link = "https://www.youtube.com/watch?v=olkNnmhMj7Y"
    ),

    Song(
        "Hedwig's Theme ( Harry Potter )", "John Williams",
        Melody(melody = listOf(
            Note.H, Note.E, Note.G, Note.Fsharp, Note.E, Note.H, Note.A, Note.Fsharp, Note.E, Note.G,
            Note.Fsharp, Note.Dsharp, Note.F, Note.H, Note.H, Note.E, Note.G, Note.Fsharp, Note.E,
            Note.H, Note.D, Note.Csharp, Note.C2, Note.Gsharp, Note.C2, Note.H, Note.Asharp,
            Note.Asharp, Note.G, Note.E
        )), link = "https://www.youtube.com/watch?v=GTXBLyp7_Dw"
    ),

    Song("Happy Birthday To You", "Traditional",
        Melody(melody = listOf(Note.D, Note.D, Note.E, Note.D, Note.G, Note.Fsharp, Note.D, Note.D, Note.E, Note.D,
    Note.A, Note.G, Note.D, Note.D, Note.D, Note.H, Note.G, Note.Fsharp, Note.E, Note.C2, Note.C2,
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
        Note.A, Note.G, Note.F, Note.A, Note.A, Note.G, Note.F, Note.D)),
    link = "https://www.youtube.com/watch?v=CduA0TULnow"
    ),

    Song("Usta Mariana", "Andrzej Rosiewicz",
    Melody(melody = listOf(Note.C2, Note.Asharp, Note.Gsharp, Note.G, Note.F, Note.Dsharp, Note.F, Note.G, Note.C,
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
    link = "https://www.youtube.com/watch?v=PSZxmZmBfnU"
    ),

    Song("Swan Lake Theme", "Pyotr Tchaikovsky",
    Melody(melody = listOf(Note.C2, Note.F, Note.G, Note.Gsharp, Note.Asharp, Note.C2, Note.Gsharp, Note.C2, Note.Gsharp, Note.C2, Note.F,
    Note.Gsharp, Note.F, Note.Csharp, Note.Gsharp, Note.F, Note.Asharp, Note.Gsharp, Note.G, Note.C2, Note.F, Note.G, Note.Gsharp,
        Note.Asharp, Note.C2, Note.Gsharp, Note.C2, Note.Gsharp, Note.C2, Note.F, Note.Gsharp, Note.F, Note.Csharp, Note.Gsharp, Note.F)),
    link = "https://www.youtube.com/watch?v=9cNQFB0TDfY"
    ),

    Song("Bad Romance", "Lady Gaga",
    Melody(melody = listOf(Note.Dsharp, Note.F, Note.G, Note.Dsharp, Note.Gsharp, Note.G, Note.Gsharp, Note.G, Note.F, Note.D, Note.Dsharp, Note.F,
    Note.G, Note.G, Note.G, Note.G, Note.F, Note.Dsharp, Note.Dsharp, Note.F, Note.G, Note.Dsharp, Note.Gsharp, Note.G, Note.Gsharp, Note.G,
    Note.F, Note.D, Note.Dsharp, Note.F, Note.G, Note.G, Note.G, Note.G, Note.F, Note.Dsharp, Note.C, Note.C, Note.G, Note.G, Note.Gsharp, Note.G,
    Note.C, Note.C, Note.G, Note.G, Note.Gsharp, Note.G, Note.C, Note.C, Note.G, Note.G, Note.Gsharp, Note.G, Note.Dsharp, Note.Dsharp, Note.C,
    Note.Dsharp, Note.C, Note.Dsharp)),
    link = "https://www.youtube.com/watch?v=qrO4YZeyl0I"
    ),

    Song("Let It Be", "The Beatles",
    Melody(melody = listOf( Note.G, Note.G, Note.A, Note.E, Note.G, Note.G, Note.C, Note.D,  Note.E, Note.E, Note.E, Note.D, Note.D,
    Note.C, Note.C, Note.E, Note.E, Note.F, Note.E, Note.E, Note.D, Note.E, Note.D, Note.D, Note.C, Note.E, Note.D, Note.C, Note.C, Note.E, Note.G,
    Note.A, Note.G, Note.G, Note.G,  Note.D, Note.C, Note.C, Note.A,  Note.E, Note.E, Note.E, Note.F, Note.E, Note.E, Note.D, Note.E, Note.D, Note.D, Note.C)),
    link = "https://www.youtube.com/watch?v=QDYfEBY9NM4"
    ),

    Song("I Just Called To Say I Love You", "Stevie Wonder",
    Melody(melody = listOf(Note.Gsharp, Note.C, Note.Csharp, Note.Csharp, Note.Gsharp, Note.C, Note.Csharp, Note.Csharp, Note.Gsharp,
    Note.C, Note.Csharp, Note.C, Note.Csharp, Note.Dsharp, Note.F, Note.Dsharp, Note.Csharp, Note.C, Note.Asharp, Note.Asharp, Note.D, Note.Dsharp, Note.Dsharp,
    Note.Asharp, Note.D, Note.Dsharp, Note.Dsharp, Note.Asharp, Note.D, Note.Dsharp, Note.Dsharp, Note.Csharp, Note.Csharp, Note.Dsharp, Note.F, Note.Dsharp,
    Note.Csharp, Note.C, Note.Asharp, Note.Csharp, Note.Csharp, Note.Asharp, Note.Csharp, Note.C, Note.Asharp, Note.C, Note.Csharp, Note.Csharp, Note.Csharp,
    Note.Asharp, Note.Csharp, Note.C, Note.Asharp, Note.Gsharp, Note.Asharp, Note.F)),
    link = "https://www.youtube.com/watch?v=1bGOgY1CmiU"
    ),

    Song("Sweet Dreams Are Made Of This", "Eurythmics",
    Melody(melody = listOf(Note.C2, Note.C2, Note.C, Note.C, Note.Dsharp, Note.Dsharp, Note.C, Note.C, Note.Gsharp, Note.Gsharp, Note.Gsharp, Note.C2, Note.G,
    Note.G, Note.G, Note.C2,Note.C2, Note.C2, Note.C, Note.C, Note.Dsharp, Note.Dsharp, Note.C, Note.C, Note.Gsharp, Note.Gsharp, Note.Gsharp, Note.C2, Note.G,
        Note.G, Note.G, Note.C2, Note.Dsharp, Note.Dsharp, Note.C, Note.Dsharp, Note.Dsharp, Note.Dsharp, Note.D, Note.Dsharp, Note.Dsharp, Note.Dsharp, Note.C,
    Note.Dsharp, Note.F, Note.Dsharp, Note.D, Note.Dsharp, Note.Dsharp, Note.C, Note.Dsharp, Note.Dsharp, Note.Dsharp, Note.D, Note.Dsharp, Note.C, Note.Dsharp,
    Note.C, Note.Dsharp, Note.Dsharp, Note.F, Note.Dsharp, Note.D)),
    link = "https://www.youtube.com/watch?v=qeMFqkcPYcg"
    ),

    Song("Katyusha", "Matvey Blanter",
    Melody(melody = listOf(Note.Fsharp, Note.Gsharp, Note.A, Note.Fsharp, Note.A, Note.A, Note.Gsharp, Note.Fsharp, Note.Gsharp, Note.Csharp, Note.Gsharp, Note.A,
    Note.H, Note.Gsharp, Note.H, Note.H, Note.A, Note.Gsharp, Note.Fsharp, Note.Csharp, Note.Fsharp, Note.E, Note.Fsharp, Note.E, Note.D, Note.D, Note.Csharp, Note.H,
    Note.Csharp, Note.Fsharp, Note.D, Note.H, Note.Csharp, Note.A, Note.H, Note.H, Note.A, Note.Gsharp, Note.Fsharp)),
    link = "https://www.youtube.com/watch?v=IGTRetzZFs0"
    ),

    Song("Spring (The Four Seasons)", "Antonio Vivaldi",
    Melody(melody = listOf(Note.C, Note.E, Note.E, Note.E, Note.D, Note.C, Note.G, Note.G, Note.F, Note.E, Note.E, Note.E, Note.D, Note.C, Note.G, Note.G,
    Note.F, Note.E, Note.F, Note.G, Note.F, Note.E, Note.D, Note.C, Note.G, Note.F, Note.E, Note.F, Note.G, Note.A, Note.G, Note.C, Note.G, Note.F, Note.E,
    Note.F, Note.G, Note.A, Note.G, Note.C, Note.A, Note.G, Note.F, Note.E, Note.D, Note.C, Note.D, Note.C)),
    link = "https://youtu.be/h_qsTFO3xuY"
    ),

    Song("In The Hall of the Mountain King", "Edvard Grieg",
    Melody(melody = listOf(Note.C, Note.D, Note.Dsharp, Note.F, Note.G, Note.Dsharp, Note.G, Note.Fsharp, Note.D, Note.Fsharp, Note.F, Note.Csharp, Note.F,
    Note.C, Note.D, Note.Dsharp, Note.F, Note.G, Note.Dsharp, Note.G, Note.C2, Note.Asharp, Note.G, Note.Dsharp, Note.G, Note.Asharp, Note.C, Note.D, Note.Dsharp,
        Note.F, Note.G, Note.Dsharp, Note.G, Note.Fsharp, Note.D, Note.Fsharp, Note.F, Note.Csharp, Note.F, Note.C, Note.D, Note.Dsharp, Note.F, Note.G, Note.Dsharp,
        Note.G, Note.C2, Note.H, Note.G, Note.H, Note.D, Note.C)),
        link = "https://www.youtube.com/watch?v=lQ2ZEQEyUT0"
    ),

    Song("Game of Thrones Theme", "Ramin Djawadi",
    Melody(melody = listOf(Note.C2, Note.F, Note.Gsharp, Note.Asharp, Note.C2, Note.F, Note.Gsharp, Note.Asharp, Note.G, Note.C, Note.Asharp, Note.Dsharp, Note.G,
    Note.Gsharp, Note.Asharp, Note.Dsharp, Note.Gsharp, Note.G, Note.F)),
    link = "https://www.youtube.com/watch?v=AdQ3JDLlmPI"
    ),

    Song("Cambio Dolor", "Natalia Oreiro",
    Melody(melody = listOf(Note.A, Note.F, Note.E, Note.D, Note.D, Note.G, Note.A, Note.Asharp, Note.G, Note.A, Note.Asharp, Note.Asharp, Note.Asharp, Note.Asharp,
    Note.Asharp, Note.Asharp, Note.C2, Note.Asharp, Note.Asharp, Note.A, Note.A, Note.G, Note.A, Note.A, Note.F, Note.E, Note.D)),
    link = "https://www.youtube.com/watch?v=G6OYDUomYwI"
    ),

    Song("My Heart Will Go On", "Celine Dion",
    Melody(melody = listOf(Note.E, Note.Fsharp, Note.Gsharp, Note.A, Note.Gsharp, Note.Fsharp, Note.E, Note.Fsharp, Note.H, Note.A, Note.Gsharp, Note.E, Note.Csharp, Note.A,
    Note.H
    , Note.E, Note.Fsharp, Note.Gsharp, Note.A, Note.Gsharp, Note.Fsharp, Note.E, Note.Fsharp, Note.H, Note.Gsharp, Note.H, Note.Csharp, Note.H, Note.Fsharp,
    Note.E, Note.E, Note.E, Note.E, Note.Dsharp, Note.E, Note.E, Note.Dsharp, Note.E, Note.Fsharp, Note.Gsharp, Note.Fsharp, Note.E, Note.E, Note.E, Note.E,
    Note.Dsharp, Note.E, Note.E, Note.H, Note.E, Note.Fsharp, Note.H, Note.H, Note.A, Note.Gsharp, Note.Fsharp, Note.Gsharp, Note.A, Note.Gsharp, Note.Fsharp, Note.E,
    Note.Dsharp, Note.E, Note.E, Note.H, Note.E, Note.Fsharp, Note.H, Note.H, Note.A, Note.Gsharp, Note.Fsharp, Note.Gsharp, Note.A, Note.Gsharp, Note.Fsharp,
    Note.E, Note.Dsharp, Note.E, Note.E, Note.Dsharp, Note.E, Note.Fsharp, Note.Gsharp, Note.Fsharp)),
    link = "https://www.youtube.com/watch?v=EcU0qbV70rU"
    ),

    Song("Billie Jean", "Michael Jackson",
    Melody(melody = listOf(Note.Fsharp, Note.Csharp, Note.E, Note.Fsharp, Note.E, Note.Csharp, Note.H, Note.Csharp, Note.Fsharp, Note.Csharp, Note.E, Note.Fsharp,
        Note.E, Note.Csharp, Note.H, Note.Csharp, Note.H, Note.Fsharp, Note.A, Note.H, Note.A, Note.Fsharp, Note.E, Note.Fsharp, Note.H, Note.Fsharp, Note.A, Note.H,
        Note.A, Note.Fsharp, Note.E, Note.Fsharp, Note.Fsharp, Note.Csharp, Note.E, Note.Fsharp, Note.E, Note.Csharp, Note.H, Note.Csharp,Note.Fsharp, Note.Csharp,
        Note.E, Note.Fsharp, Note.E, Note.Csharp, Note.H, Note.Csharp    )),
    link = "https://www.youtube.com/watch?v=Zi_XLOBDo_Y"
    ),

    Song("Uptown Girl", "Billy Joel",
    Melody(melody = listOf(Note.E, Note.Dsharp, Note.E, Note.Fsharp, Note.E, Note.Dsharp, Note.Csharp, Note.H, Note.Gsharp, Note.Fsharp, Note.Gsharp, Note.A, Note.Gsharp,
    Note.Fsharp, Note.E, Note.E, Note.E, Note.E, Note.Dsharp, Note.E, Note.Fsharp, Note.E, Note.Dsharp, Note.Csharp, Note.Csharp, Note.H, Note.Gsharp, Note.H,
    Note.A, Note.Gsharp, Note.A, Note.H, Note.A, Note.Gsharp, Note.Fsharp, Note.E, Note.E, Note.E, Note.Dsharp, Note.E, Note.Fsharp, Note.E, Note.Dsharp, Note.Csharp,
    Note.Csharp, Note.H, Note.H, Note.A, Note.Gsharp, Note.A, Note.H, Note.G, Note.G, Note.H, Note.D, Note.Fsharp, Note.E, Note.A, Note.G, Note.Fsharp, Note.E,
    Note.G, Note.Fsharp, Note.E, Note.D, Note.Csharp, Note.H, Note.G, Note.G, Note.H, Note.D, Note.Fsharp, Note.E, Note.A, Note.G, Note.Fsharp, Note.E,
    Note.G, Note.Fsharp, Note.E, Note.Dsharp, Note.H)),
    link = "https://www.youtube.com/watch?v=hCuMWrfXG4E"
    ),

    Song("The Winner Takes It All", "ABBA",
    Melody(melody = listOf(Note.C, Note.D, Note.E, Note.F, Note.A, Note.A, Note.Asharp, Note.C, Note.D, Note.D, Note.C, Note.C2, Note.Asharp, Note.A, Note.G, Note.Asharp,
    Note.C2, Note.Asharp, Note.A, Note.G, Note.Asharp, Note.C, Note.C, Note.Asharp, Note.Asharp, Note.A, Note.A, Note.C, Note.C, Note.G, Note.G, Note.F, Note.F,
    Note.D, Note.D, Note.C2, Note.C2, Note.Asharp, Note.Asharp, Note.Asharp, Note.Asharp, Note.A, Note.G, Note.A, Note.Asharp)),
    link = "https://www.youtube.com/watch?v=iyIOl-s7JTU"
    ),

    Song("Sound Of Silence", "Simon & Garfunkel",
    Melody(melody = listOf(Note.D, Note.D, Note.F, Note.F, Note.A, Note.A, Note.G, Note.C, Note.C, Note.E, Note.E, Note.G, Note.G, Note.F, Note.F, Note.F, Note.F,
    Note.A, Note.A, Note.C2, Note.C2, Note.D, Note.D, Note.C, Note.F, Note.F, Note.A, Note.A, Note.C2, Note.C2, Note.D, Note.D, Note.C, Note.F, Note.F, Note.D, Note.D,
    Note.D, Note.E, Note.F, Note.F, Note.E, Note.D, Note.C, Note.D, Note.C, Note.A, Note.F, Note.F, Note.F, Note.C2, Note.E, Note.F, Note.D)),
    link = "https://www.youtube.com/watch?v=l0q7MLPo-u8"
    ),

    Song("Kiss From A Rose", "Seal",
    Melody(melody = listOf(Note.G, Note.A, Note.Asharp, Note.C2, Note.Asharp, Note.A, Note.G, Note.F, Note.G, Note.G, Note.F, Note.G, Note.A, Note.Asharp, Note.C2,
    Note.Asharp, Note.A, Note.F, Note.A, Note.G)),
    link = "https://www.youtube.com/watch?v=AMD2TwRvuoU"
    ),

    Song("Don't Speak", "No Doubt",
    Melody(melody = listOf(Note.F, Note.Gsharp, Note.C, Note.Csharp, Note.F, Note.G, Note.F, Note.Gsharp, Note.G, Note.C, Note.E, Note.G, Note.F, Note.G, Note.F,
    Note.C, Note.C, Note.E, Note.G, Note.E, Note.F, Note.F, Note.Gsharp, Note.Csharp, Note.F, Note.G, Note.F, Note.Gsharp, Note.G, Note.C, Note.E, Note.G, Note.F,
    Note.G, Note.Gsharp, Note.C2, Note.C2, Note.Asharp, Note.Asharp, Note.Gsharp, Note.Gsharp)),
    link = "https://www.youtube.com/watch?v=ONg4SK39-Kg"
    ),

    Song("C'est La Vie", "Andrzej Zaucha",
    Melody(melody = listOf(Note.A, Note.A, Note.G, Note.C, Note.D, Note.E, Note.F, Note.F, Note.E, Note.F, Note.C, Note.D, Note.E, Note.A, Note.A, Note.G, Note.F,
    Note.E, Note.F, Note.G)),
    link = "https://www.youtube.com/watch?v=o8x64wd-EU4"
    ),

    Song("Szczęśliwej Drogi Już Czas", "Ryszard Rynkowski",
    Melody(melody = listOf(Note.G, Note.A, Note.H, Note.H, Note.H, Note.H, Note.C2, Note.H, Note.A, Note.A, Note.G, Note.A, Note.A, Note.H, Note.A, Note.G, Note.G, Note.E,
    Note.E, Note.E, Note.G, Note.Fsharp, Note.Fsharp, Note.E, Note.Fsharp, Note.E, Note.E, Note.H, Note.H, Note.H, Note.H, Note.A, Note.G, Note.H, Note.H, Note.C2,
    Note.H, Note.A, Note.A, Note.G, Note.A, Note.H, Note.A, Note.A, Note.A, Note.G, Note.E, Note.H, Note.A, Note.G, Note.G, Note.H, Note.C2, Note.H, Note.A, Note.A,
    Note.G, Note.A, Note.A, Note.G, Note.A, Note.G, Note.G, Note.E)),
    link = "https://www.youtube.com/watch?v=fX_rpjz2o5w"
    ),

    Song("Pokemon Theme", "Janusz Radek",
    Melody(melody = listOf(Note.A, Note.A, Note.A, Note.A, Note.A, Note.G, Note.E, Note.C, Note.C, Note.A, Note.A, Note.G, Note.F, Note.G, Note.Asharp, Note.Asharp, Note.Asharp,
    Note.Asharp, Note.A, Note.A, Note.G, Note.F, Note.A, Note.A, Note.G, Note.F, Note.A, Note.A, Note.C, Note.D, Note.C, Note.A, Note.G, Note.F, Note.D, Note.D, Note.E,
    Note.F, Note.E, Note.D, Note.C, Note.A, Note.C2, Note.D, Note.D, Note.C, Note.A, Note.G, Note.F, Note.F, Note.G, Note.A, Note.A, Note.G, Note.F, Note.A, Note.A, Note.C2,
    Note.D)),
    link = "https://www.youtube.com/watch?v=NJwacipEYX8"
    ),

    Song("James Bond 007 Theme", "Monty Norman",
    Melody(melody = listOf(Note.C, Note.Csharp, Note.D, Note.Csharp, Note.C, Note.Csharp, Note.D, Note.Csharp, Note.C, Note.F, Note.Gsharp, Note.F, Note.Csharp, Note.F,
    Note.Gsharp, Note.F, Note.D, Note.F, Note.Gsharp, Note.F, Note.Csharp, Note.F, Note.Gsharp, Note.F, Note.C, Note.F, Note.Gsharp, Note.F, Note.Csharp, Note.F,
        Note.Gsharp, Note.F, Note.D, Note.F, Note.Gsharp, Note.F, Note.Csharp, Note.F, Note.Gsharp, Note.F, Note.F, Note.Gsharp, Note.E, Note.Dsharp, Note.Gsharp, Note.H,
    Note.C2, Note.Gsharp, Note.G, Note.C, Note.F, Note.D, Note.F, Note.Gsharp, Note.E, Note.Dsharp, Note.Gsharp, Note.H, Note.C2, Note.Gsharp, Note.G, Note.C, Note.E,
    Note.F, Note.F, Note.F, Note.F, Note.G, Note.F, Note.G, Note.Gsharp, Note.Gsharp, Note.Gsharp, Note.G, Note.F, Note.G, Note.C2, Note.C2, Note.C, Note.C2, Note.C2,
    Note.C, Note.C2, Note.C2, Note.C2, Note.C2, Note.C2)),
    link = "https://www.youtube.com/watch?v=SnSJXYv5jKI"
    ),

    Song("Thriller", "Michael Jackson",
    Melody(melody = listOf(Note.D, Note.C, Note.D, Note.F, Note.G, Note.D, Note.D, Note.D, Note.C, Note.D, Note.F, Note.G, Note.D, Note.D, Note.C, Note.D, Note.E, Note.F,
    Note.D, Note.C, Note.A, Note.A, Note.C, Note.D, Note.D, Note.C, Note.D, Note.C, Note.D, Note.F, Note.D, Note.C, Note.A, Note.D, Note.F, Note.A, Note.G, Note.F, Note.D,
    Note.G, Note.G, Note.G, Note.F, Note.F, Note.E, Note.E, Note.D, Note.D, Note.E, Note.F, Note.D, Note.D, Note.F, Note.A, Note.G, Note.F, Note.D,
        Note.G, Note.G, Note.G, Note.F, Note.F, Note.E, Note.E, Note.D, Note.D, Note.E, Note.F, Note.F, Note.G, Note.F, Note.A, Note.F, Note.G, Note.A, Note.C2, Note.A,
    Note.D, Note.C, Note.C2, Note.H, Note.A, Note.F, Note.D, Note.C, Note.D)),
    link = "https://www.youtube.com/watch?v=ZEHsIcsjtdI"
    )


)
// order alfabetical
    .sortedBy { it.title }
