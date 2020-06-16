package com.qndzia.tapformelody.recordermelodies

import android.app.Application
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

private lateinit var fakeList: LiveData<List<Melody>>

class RecordedMelodiesViewModel(
    datasource: MelodyDao,
    application: Application
) : ViewModel() {

    val database = datasource

//    val fakeList=  listOf(Melody(title = "chuj", melody = listOf(Note.C, Note.D, Note.E)))




    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

   val melodies = database.getAll()









}