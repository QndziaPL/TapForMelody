package com.qndzia.tapformelody.matchedlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MatchedListViewModel : ViewModel() {

    private var _onBackPressed = MutableLiveData<Boolean>()
    var onBackPressed: LiveData<Boolean> = _onBackPressed

    fun goBack() {
        _onBackPressed.value = true
    }

    fun onFinishedNavBack() {
        _onBackPressed.value = false
    }

}