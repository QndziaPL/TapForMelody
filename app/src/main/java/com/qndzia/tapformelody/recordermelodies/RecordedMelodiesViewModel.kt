package com.qndzia.tapformelody.recordermelodies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class RecordedMelodiesViewModel(
    val database: MelodyDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val dbScope = CoroutineScope(Dispatchers.Default + viewModelJob)

    val list: LiveData<List<Melody>> = database.getAll()

}