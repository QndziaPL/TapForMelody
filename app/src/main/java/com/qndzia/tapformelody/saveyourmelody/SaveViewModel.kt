package com.qndzia.tapformelody.saveyourmelody

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDao
import kotlinx.coroutines.*

class SaveViewModel(
    val myStringMelody: String, myMelody: Melody,
    dataSource: MelodyDao, application: Application
) : AndroidViewModel(application) {


    val database = dataSource

    private var viewModelJob = Job()

    private val dbScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    private var _melody = MutableLiveData<Melody>()
    val melody: LiveData<Melody> = _melody

    private var _onSavePressed = MutableLiveData<Boolean>()
    val onSavePressed: LiveData<Boolean> = _onSavePressed

    init {
        _melody.value = myMelody

    }

    fun onSavePressed() {
        _onSavePressed.value = true
    }

    private fun triggerSaveCoroutineFun(melody: Melody) {
        dbScope.launch {
            saveInDb(melody)

        }
    }


    fun assignMelodyValues(title: String) {
        val melodyToSave = _melody.value
        melodyToSave!!.title = title
        melodyToSave.timeOfRecord = System.currentTimeMillis()
        triggerSaveCoroutineFun(melodyToSave)

    }

    private suspend fun saveInDb(melody: Melody) {
        withContext(Dispatchers.IO) {
            database.insert(melody)
        }
    }

    fun doneSaving() {
        _onSavePressed.value = false
    }


}