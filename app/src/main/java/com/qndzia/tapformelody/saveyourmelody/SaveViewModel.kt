package com.qndzia.tapformelody.saveyourmelody

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDao
import com.qndzia.tapformelody.database.MelodyDatabase
import kotlinx.coroutines.*

class SaveViewModel(
    val myStringMelody: String, myMelody: Melody,
    dataSource: MelodyDao, application: Application
) : AndroidViewModel(application) {

    //    private val dblist: LiveData<List<Melody>>
    val database = dataSource

    private var viewModelJob = Job()

    private val dbScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    private var _melody = MutableLiveData<Melody>()
    val melody: LiveData<Melody> = _melody

    private var _onSavePressed = MutableLiveData<Boolean>()
    val onSavePressed: LiveData<Boolean> = _onSavePressed

    init {
        _melody.value = myMelody
//        dblist = database.getAll()

    }

    fun onSavePressed() {
        _onSavePressed.value = true
    }

    fun triggerSaveCoroutineFun(melody: Melody) {
        dbScope.launch {
            saveInDb(melody)

        }
    }


    fun assignMelodyValues(title: String) {
        var melodyToSave = _melody.value
        melodyToSave!!.title = title
        triggerSaveCoroutineFun(melodyToSave)

    }

    private suspend fun saveInDb(melody: Melody) {
        withContext(Dispatchers.IO) {
            database.insert(melody)
        }


    }

/*
poprzednia wersja \/ \/ \/


 */
//    fun saveInDb(title: String) {
//
//        dbScope.launch {
//
//            var melodyToSave = _melody.value
//            if (melodyToSave != null) {
//                melodyToSave.title = title
//                database.insert(melodyToSave)
//
//
//            } else {
//                Toast.makeText(
//                    getApplication(),
//                    "unable to insert $melodyToSave to db",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//
//        }
//        doneSaving()
//
//    }

    fun doneSaving() {
        _onSavePressed.value = false
    }


}