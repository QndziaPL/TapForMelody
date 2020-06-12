package com.qndzia.tapformelody.database

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.*
import com.qndzia.tapformelody.notes.Note

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
    fun fromNote(value: Note): Int {
        return value.id
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @TypeConverter
    fun toNote(value: Int): Note {
        val filter = listOf(
            Note.C, Note.Csharp, Note.D, Note.Dsharp,
            Note.E, Note.F, Note.Fsharp, Note.G, Note.Gsharp, Note.A,
            Note.Asharp, Note.H, Note.C2
        ).filter { it.id == value }
        return filter[0]
    }
}

class ListOfNoteSConverters{
    @TypeConverter
    fun fromList(){

    }
}