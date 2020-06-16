package com.qndzia.tapformelody.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MelodyDao {

    @Insert
    fun insert(melody: Melody)

    @Delete
    fun delete(melody: Melody)

    @Query("SELECT * from recorded_melody_table WHERE melodyId = :id")
    fun get(id: Long): Melody

    @Query("DELETE FROM recorded_melody_table")
    fun clear()

    @Query("SELECT * FROM recorded_melody_table ORDER BY melodyId DESC")
    fun getAll(): LiveData<List<Melody>>

//    @Query("SELECT * FROM recorded_melody_table ORDER BY melodyId DESC")
//    fun getAll(): LiveData<List<Melody>>

    @Query("SELECT * FROM recorded_melody_table ORDER BY melodyId DESC LIMIT 1")
    fun getMostFreshOne() : Melody?

//    @Query("SELECT * FROM recorded_melody_table ORDER BY melodyId DESC")
//    fun getAll(): LiveData<List<Melody>>



}