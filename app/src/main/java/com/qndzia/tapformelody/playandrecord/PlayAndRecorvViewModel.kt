package com.qndzia.tapformelody.playandrecord

import android.app.Application
import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDao
import com.qndzia.tapformelody.notes.Note
import com.qndzia.tapformelody.songlist.Song
import com.qndzia.tapformelody.songlist.defaultSongList

import kotlinx.coroutines.*

//lateinit var soundPool: SoundPool


class PlayAndRecordViewModel(
    private val labelsOn: Boolean,
    val database: MelodyDao, application: Application
) : AndroidViewModel(application) {

    private var _labelsOnLiveData = MutableLiveData<Boolean>()
    val labelsOnLiveData: LiveData<Boolean> = _labelsOnLiveData

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val dbScope = CoroutineScope(Dispatchers.Default + viewModelJob)

    private var _isRecording = MutableLiveData<Boolean>()
    val isRecording: LiveData<Boolean> = _isRecording

    private var _isPlaying = MutableLiveData<Boolean>()
    val isPlaying: LiveData<Boolean> = _isPlaying

    private var _myMelody = MutableLiveData<String>()
    val myMelody: LiveData<String> = _myMelody

    private var _noteListSize = MutableLiveData<Int>()
    val noteListSize: LiveData<Int> = _noteListSize

    private val noteList = mutableListOf<Note>()

    // melody you will record, compare and potentially save in room if u want
    private var _mySuperMelody = MutableLiveData<Melody>()
    val mySuperMelody: LiveData<Melody> = _mySuperMelody

    private var blockAdding = true

    private var _navigateToSaveFragment = MutableLiveData<Boolean>()
    val navigateToSaveFragment: LiveData<Boolean> = _navigateToSaveFragment

    private var _showMenu = MutableLiveData<Boolean>()
    val showMenu: LiveData<Boolean> = _showMenu

    private var _saveToDbProcessOn = MutableLiveData<Boolean>()
    val saveToDbProcessOn : LiveData<Boolean> = _saveToDbProcessOn

//    val assetManager = AssetManager.AssetInputStream()

    //live data z listą melodii z rooma
    val savedMelodies = database.getAll()

    private var soundC: Int
    private var soundCsharp: Int
    private var soundD: Int
    private var soundDsharp: Int
    private var soundE: Int
    private var soundF: Int
    private var soundFsharp: Int
    private var soundG: Int
    private var soundGsharp: Int
    private var soundA: Int
    private var soundAsharp: Int
    private var soundH: Int
    private var soundC2: Int

    private val listOfPoolSounds = mutableListOf<Int>()

    init {
        _isRecording.value = false
        _myMelody.value = ""
        _navigateToSaveFragment.value = false
        _noteListSize.value = 0



        soundC = soundPool.load(getApplication(), R.raw.c, 1)
        soundCsharp = soundPool.load(getApplication(), R.raw.csharp, 1)
        soundD = soundPool.load(getApplication(), R.raw.d, 1)
        soundDsharp = soundPool.load(getApplication(), R.raw.dsharp, 1)
        soundE = soundPool.load(getApplication(), R.raw.e, 1)
        soundF = soundPool.load(getApplication(), R.raw.f, 1)
        soundFsharp = soundPool.load(getApplication(), R.raw.fsharp, 1)
        soundG = soundPool.load(getApplication(), R.raw.g, 1)
        soundGsharp = soundPool.load(getApplication(), R.raw.gsharp, 1)
        soundA = soundPool.load(getApplication(), R.raw.a, 1)
        soundAsharp = soundPool.load(getApplication(), R.raw.asharp, 1)
        soundH = soundPool.load(getApplication(), R.raw.h, 1)
        soundC2 = soundPool.load(getApplication(), R.raw.c2, 1)

        listOfPoolSounds.addAll(
            0, listOf(
                soundC, soundCsharp, soundD, soundDsharp, soundE, soundF, soundFsharp, soundG,
                soundGsharp, soundA, soundAsharp, soundH, soundC2
            )
        )

        _labelsOnLiveData.value = labelsOn

    }

    companion object {
        var audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        var soundPool = SoundPool.Builder()
            .setMaxStreams(30)
            .setAudioAttributes(audioAttributes)
            .build()


    }


    fun cKeyPressed() {
        keyPressed(Note.C, soundC)
    }

    fun cSharpKeyPressed() {
        keyPressed(Note.Csharp, soundCsharp)
    }

    fun dKeyPressed() {
        keyPressed(Note.D, soundD)
    }

    fun dSharpKeyPressed() {
        keyPressed(Note.Dsharp, soundDsharp)
    }

    fun eKeyPressed() {
        keyPressed(Note.E, soundE)
    }

    fun fKeyPressed() {
        keyPressed(Note.F, soundF)
    }

    fun fSharpKeyPressed() {
        keyPressed(Note.Fsharp, soundFsharp)
    }

    fun gKeyPressed() {
        keyPressed(Note.G, soundG)
    }

    fun gSharpKeyPressed() {
        keyPressed(Note.Gsharp, soundGsharp)
    }

    fun aKeyPressed() {
        keyPressed(Note.A, soundA)
    }

    fun aSharpKeyPressed() {
        keyPressed(Note.Asharp, soundAsharp)
    }

    fun hKeyPressed() {
        keyPressed(Note.H, soundH)
    }

    fun c2KeyPressed() {
        keyPressed(Note.C2, soundC2)
//        Toast.makeText(getApplication(), "status klawiszy: ${labelsOnLiveData.value}", Toast.LENGTH_LONG).show()
    }

    private fun saveMelody() {
        dbScope.launch {
//            val melody: Melody =
//                Melody(title = "test1", melody = listOf(Note.C, Note.D, Note.E, Note.D, Note.C))
//            val melody2: Melody =
//                Melody(title = "test2", melody = listOf(Note.G, Note.A, Note.H, Note.D, Note.G))
//            database.insert(melody)
//            database.insert(melody2)
//            Log.d("savemelody", melody.toString())
//            Log.d("listInDb", savedMelodies.value.toString())
        }
    }

//    private fun deleteAll() {
//        dbScope.launch {
//            database.clear()
//        }
//    }


    private fun keyPressed(note: Note, sound: Int) {

        uiScope.launch {
            soundPool.play(sound, 1F, 1F, 1, 0, 1F)
        }


        if (!blockAdding) {

            if (noteList.size < 15) {
                noteList.add(note)
                _myMelody.value = _myMelody.value + note.noteName + " "
                _noteListSize.value = noteList.size

                if (_noteListSize.value == 15) {
                    _isRecording.value = false
                    blockAdding = true
                    val toast = Toast.makeText(
                        getApplication(), "REC is OFF",
                        Toast.LENGTH_SHORT
                    )
                    toast.setGravity(Gravity.TOP, 0, 80)
                    toast.show()
                }
            }
        }
    }

//    fun updateTitleOfYourMelody(newTitle: String){
//
//
//    }

    fun saveInDb(newTitle: String) {
        _mySuperMelody.value?.title = newTitle
        Log.d("TAG", "melody name is now ${mySuperMelody.value?.title}")
        _mySuperMelody.value?.let {

            database.insert(it) }
    }

    fun turnOffSaving() {
        _saveToDbProcessOn.value = false
        uiScope.launch {
            val list = database.getAll()
            Log.d("TAG", list.toString())
        }
    }

    fun onRecordPressed() {
//        deleteAll()
        saveMelody()

        if (_isRecording.value == true) {
            _isRecording.value = false
            blockAdding = true


//            val toast = Toast.makeText(
//                getApplication(), "REC is OFF",
//                Toast.LENGTH_SHORT
//            )
//            toast.setGravity(Gravity.TOP, 0, 80)
//            toast.show()

        } else {
            _isRecording.value = true
            _myMelody.value = ""
            noteList.clear()
            _noteListSize.value = noteList.size
            blockAdding = false
            //creating melody to save and compare
            _mySuperMelody.value = Melody(melody = listOf())

//            val toast = Toast.makeText(
//                getApplication(), "REC is ON!!!",
//                Toast.LENGTH_SHORT
//            )
//            toast.setGravity(Gravity.TOP, 0, 80)
//            toast.show()

        }
    }

    fun onMelodyFinishedRecording() {
        //assigns played notes to your Melody object
        _mySuperMelody.value = Melody(melody = noteList)

    }

    fun onMelodyStartedRecording() {
        //clear previous record
        _mySuperMelody.value = Melody(melody = listOf())
    }


    fun onPlayPressed() {
        if (noteList.isNotEmpty()) {
            Toast.makeText(getApplication(), "Your melody is playing", Toast.LENGTH_SHORT).show()
            uiScope.launch {
                noteList.forEach {

                    delay(300)
                    val sound = listOfPoolSounds[(it.id - 1)]
                    soundPool.play(sound, 1F, 1F, 1, 0, 1F)

                }
            }.apply { _isPlaying.value = isActive }
                .invokeOnCompletion { _isPlaying.value = false }


        } else {
            Toast.makeText(getApplication(), "Record something first", Toast.LENGTH_SHORT).show()
        }
    }

    fun onSearchPressed() {
        val osp = matchSongs(mySuperMelody.value, defaultSongList)
        Log.d("onsearchpressed", osp.toString())
        Toast.makeText(
            getApplication(), "Your melody matches ${osp.size} songs.\n" +
                    "List: $osp", Toast.LENGTH_LONG
        ).show()

    }

    fun onMenuPressed() {
        _showMenu.value = true
        Log.d("showmenu", "onMenuPressed: ${showMenu.value}")

    }

    fun turnOffMenuNavigation() {
        _showMenu.value = false
        Log.d("showmenu", "turnOffMenuNavigation: ${showMenu.value}")

    }

    fun labelsOnOff() {
        _labelsOnLiveData.value = _labelsOnLiveData.value != true
    }


    fun onSavePressed() {

//        val test = isSongMatched(
//            Melody(title = "dupa", melody = listOf(Note.D, Note.A, Note.C, Note.C, Note.C)),
//            defaultSongList[0].melody
//        )
//        Log.d("test", test.toString())


        if (noteList.isNotEmpty() && isRecording.value == false) {
            _navigateToSaveFragment.value = true
        } else if (isRecording.value == true) {
            Toast.makeText(getApplication(), "Recording still ON", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(getApplication(), "Nothing to save", Toast.LENGTH_SHORT).show()
        }
    }

    fun onNavigatingToSaveFragmentFinished() {
        _navigateToSaveFragment.value = false
    }

    fun isSongMatched(yourMelody: Melody?, libraryMelody: Melody): Boolean {

        var yourStringMelody = ""
        yourMelody?.melody?.forEach {
            yourStringMelody += it.toStringFromList()
        }

        var libraryStringMelody = ""
        libraryMelody.melody.forEach {
            libraryStringMelody += it.toStringFromList()
        }

        Log.d("toStringMatchingResults", "your: $yourStringMelody libr: $libraryStringMelody")
        return libraryStringMelody.contains(yourStringMelody)
    }

    fun matchSongs(yourMelody: Melody?, library: List<Song>): List<Song> {
        var matchList = mutableListOf<Song>()
        library.forEach {
            if (isSongMatched(yourMelody, it.melody)) {
                Log.d("match", "${it.title} matches!!!")
                matchList.add(it)
            }

        }
        return matchList
    }


}