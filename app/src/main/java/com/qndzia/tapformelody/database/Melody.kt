package com.qndzia.tapformelody.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.qndzia.tapformelody.notes.Note

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
    var melody: List<Note>)
{
    override fun toString(): String {
        return "Melody(melodyId=$melodyId, title='$title', timeOfRecord=$timeOfRecord, melody=$melody)"
    }
}
