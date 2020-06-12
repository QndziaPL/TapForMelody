package com.qndzia.tapformelody.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.qndzia.tapformelody.notes.Note

@Entity(tableName = "recorded_melody_table")
data class Melody(
    @PrimaryKey(autoGenerate = true)
    var melodyId: Long = 0L,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "time_of_record")
    val timeOfRecord: Long = System.currentTimeMillis()

//    ,
//    @ColumnInfo(name = "melody")
//    val melody: List<Note>


    )