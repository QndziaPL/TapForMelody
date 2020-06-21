package com.qndzia.tapformelody.songlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SongListViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SongListViewModel::class.java)) {
            return SongListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}