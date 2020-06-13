package com.qndzia.tapformelody.playandrecord

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.qndzia.tapformelody.database.MelodyDao

class PlayAndRecordViewModelFactory(
    private val dataSource: MelodyDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayAndRecordViewModel::class.java)) {
            return PlayAndRecordViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}