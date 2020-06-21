package com.qndzia.tapformelody.recordedmelodies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.qndzia.tapformelody.database.MelodyDao

class RecordedMelodiesViewModelFactory(
    private val dataSource: MelodyDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecordedMelodiesViewModel::class.java)) {
            return RecordedMelodiesViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}