package com.qndzia.tapformelody.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qndzia.tapformelody.notes.Note
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "recorded_melody_table")
data class Melody(
    @PrimaryKey(autoGenerate = true)
    var melodyId: Long = 0L,

    @ColumnInfo(name = "title")
    var title: String = "title",

    @ColumnInfo(name = "time_of_record")
    var timeOfRecord: Long = System.currentTimeMillis()

    ,
//    @TypeConverters(NoteListConverter::class)
    @ColumnInfo(name = "melody")
    var melody: List<Note>
) : Parcelable {
    override fun toString(): String {

//        return "${melody.forEach { it.noteName + " "}}"
        return "Melody(melodyId=$melodyId, title='$title', timeOfRecord=$timeOfRecord, melody=$melody)"
    }


}

fun melodyToString(melody: Melody): String {
    var str = ""
    melody.melody.forEach { str += it.noteName + " - "}
    return str
}

