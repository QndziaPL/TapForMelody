package com.qndzia.tapformelody.matchedlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MatchedListViewModelFactory : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MatchedListViewModel::class.java)) {
            return MatchedListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}