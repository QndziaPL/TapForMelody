package com.qndzia.tapformelody.saveyourmelody

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SaveViewModel(
    val myStringMelody: String, val myMelody: Melody,
    val database: MelodyDao, application: Application
) : AndroidViewModel(application) {


    val dblist: LiveData<List<Melody>>


    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val dbScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    private var _melody = MutableLiveData<Melody>()
    val melody: LiveData<Melody> = _melody

    private var _onSavePressed = MutableLiveData<Boolean>()
    val onSavePressed: LiveData<Boolean> = _onSavePressed

    init {
        _melody.value = myMelody
        dblist = database.getAll()
    }




    fun onSavePressed() {
        _onSavePressed.value = true
    }

    fun saveInDb(title: String) {
        _melody.value!!.title = title
        Log.d("tag", "new title: $title")
        dbScope.launch {

            database.insert(_melody.value!!)
            Log.d("tag", "chyba wejszło")

        }
    }



    fun doneSaving() {
        _onSavePressed.value = false
        Toast.makeText(getApplication(), "dblistsize: ${dblist.value?.size}", Toast.LENGTH_LONG).show()

    }


}