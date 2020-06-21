package com.qndzia.tapformelody.saveyourmelody

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDao

class SaveViewModelFactory(private val myStringMelody: String,
private val myMelody: Melody,
    private val dataSource: MelodyDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SaveViewModel::class.java)) {
            return SaveViewModel(myStringMelody,  myMelody, dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}