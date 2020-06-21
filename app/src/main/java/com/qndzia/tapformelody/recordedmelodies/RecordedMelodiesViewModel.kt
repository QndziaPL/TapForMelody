package com.qndzia.tapformelody.recordedmelodies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class RecordedMelodiesViewModel(
    datasource: MelodyDao
) : ViewModel()
{

    private var _onBackPressed = MutableLiveData<Boolean>()
    var onBackPressed: LiveData<Boolean> = _onBackPressed

    fun goBack() {
        _onBackPressed.value = true
    }

    fun onFinishedNavBack() {
        _onBackPressed.value = false
    }

    val database = datasource

    var list: LiveData<List<Melody>> = datasource.getAll()

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    fun deleteMelody(melody: Melody) {
        uiScope.launch {
            database.delete(melody)
        }
    }

    fun deleteAllMelodies() {
        uiScope.launch {
            database.clear()
        }
    }




}