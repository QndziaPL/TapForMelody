package com.qndzia.tapformelody.database

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.*
import com.qndzia.tapformelody.notes.Note
import java.lang.Exception
import java.lang.RuntimeException
import java.util.*

@Database(entities = [Melody::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MelodyDatabase : RoomDatabase() {

    abstract val melodyDao: MelodyDao

    companion object {

        @Volatile
        private var INSTANCE: MelodyDatabase? = null

        fun getInstance(context: Context): MelodyDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MelodyDatabase::class.java,
                        "melody_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

class Converters {
    @TypeConverter
    fun fromNote(value: Note): String? {

        return value.noteName
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @TypeConverter
    fun fromString(date: String): Note? {
        return Arrays.stream(Note.values()).filter { it.noteName == date }
            .findAny().orElseThrow { RuntimeException("enum not found") }
    }
}