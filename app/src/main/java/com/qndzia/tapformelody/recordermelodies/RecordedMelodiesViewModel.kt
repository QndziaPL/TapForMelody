package com.qndzia.tapformelody.recordermelodies

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDao
import com.qndzia.tapformelody.notes.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class RecordedMelodiesViewModel(
    datasource: MelodyDao,
    application: Application
) : ViewModel()
//    , DatabaseOperations
{


    val database = datasource
    var list: LiveData<List<Melody>>

    init {
        list = datasource.getAll()
    }


    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    val melodies = database.getAll()

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