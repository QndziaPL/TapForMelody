package com.qndzia.tapformelody.playandrecord

import android.app.Application
import android.media.AudioAttributes
import android.media.SoundPool
import android.view.Gravity
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.database.Melody
import com.qndzia.tapformelody.database.MelodyDao
import com.qndzia.tapformelody.notes.IntervalEnumNotes
import com.qndzia.tapformelody.notes.Note
import com.qndzia.tapformelody.songlist.Song
import com.qndzia.tapformelody.songlist.defaultSongList

import kotlinx.coroutines.*
import java.lang.Exception


class PlayAndRecordViewModel(
    labelsOn: Boolean,
    dataSource: MelodyDao, application: Application
) : AndroidViewModel(application) {

    val database = dataSource

    private var _labelsOnLiveData = MutableLiveData<Boolean>()
    val labelsOnLiveData: LiveData<Boolean> = _labelsOnLiveData

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

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

    // it should be false only while recording - otherwise block adding new notes to current melody
    private var blockAdding = true

    private var _navigateToSaveFragment = MutableLiveData<Boolean>()
    val navigateToSaveFragment: LiveData<Boolean> = _navigateToSaveFragment


    private var _showMenu = MutableLiveData<Boolean>()
    val showMenu: LiveData<Boolean> = _showMenu

    private var _preventSavingRecordedOnceAgain = MutableLiveData<Boolean>()

    private var _showSnackbarWithMatchingSongs = MutableLiveData<Boolean>()
    val showSnackbarWithMatchingSongs: LiveData<Boolean> = _showSnackbarWithMatchingSongs

    private var _onStopPressed = MutableLiveData<Boolean>()
    val onStopPressed: LiveData<Boolean> = _onStopPressed


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
        _preventSavingRecordedOnceAgain.value = false
        _onStopPressed.value = true


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
            .setMaxStreams(50)
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
    }

    private fun melodyIntervalIndexes(melody: Melody): String {
        val justmelody = melody.melody
        var mii = ""
        var index = 0
        for (note in justmelody) {
            if (index == justmelody.size - 1) break

            var note1 = justmelody[index]
            if (note1 == Note.C2) note1 = Note.C

            var note2 = justmelody[index + 1]
            if (note2 == Note.C2) note2 = Note.C

            val pair = Pair(note1, note2)

            when {
                IntervalEnumNotes.PRYMALUBOKTAWA.set.contains(pair) -> {
                    mii += IntervalEnumNotes.PRYMALUBOKTAWA.halftoneIndex
                }
                IntervalEnumNotes.SEKUNDAMLUBSEPTYMAW.set.contains(pair) -> {
                    mii += IntervalEnumNotes.SEKUNDAMLUBSEPTYMAW.halftoneIndex
                }
                IntervalEnumNotes.SEKUNDAWLUBSEPTYMAM.set.contains(pair) -> {
                    mii += IntervalEnumNotes.SEKUNDAWLUBSEPTYMAM.halftoneIndex
                }
                IntervalEnumNotes.TERCJAMLUBSEKSTAW.set.contains(pair) -> {
                    mii += IntervalEnumNotes.TERCJAMLUBSEKSTAW.halftoneIndex
                }
                IntervalEnumNotes.TERCJAWLUBSEKSTAM.set.contains(pair) -> {
                    mii += IntervalEnumNotes.TERCJAWLUBSEKSTAM.halftoneIndex
                }
                IntervalEnumNotes.KWARTACZLUBKWINTACZ.set.contains(pair) -> {
                    mii += IntervalEnumNotes.KWARTACZLUBKWINTACZ.halftoneIndex
                }
                IntervalEnumNotes.TRYTON.set.contains(pair) -> {
                    mii += IntervalEnumNotes.TRYTON.halftoneIndex
                }
                else -> {
                    throw Exception("something went wrong with melodyIntervalIndexes function or in IntervalEnumNotes")
                }
            }
            index++
        }

        return mii
    }


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

    fun preventSaving() {
        _preventSavingRecordedOnceAgain.value = true
    }


    fun onRecordPressed() {
        _preventSavingRecordedOnceAgain.value = false

        if (_isRecording.value == true) {
            _isRecording.value = false
            blockAdding = true

        } else {
            _isRecording.value = true
            _myMelody.value = ""
            noteList.clear()
            _noteListSize.value = noteList.size
            blockAdding = false

        }
    }

    fun onMelodyFinishedRecording() {
        _mySuperMelody.value = Melody(melody = noteList)

    }

    fun onMelodyStartedRecording() {
        _mySuperMelody.value = Melody(melody = listOf())
    }

    fun stopPlayingOnNavigating() {
        _onStopPressed.value = true
        _isPlaying.value = false
    }

    fun onPlayPressed() {

        if (noteList.isNotEmpty()) {
            _onStopPressed.value = _onStopPressed.value != true

            uiScope.launch {

                noteList.forEach {
                    if (_onStopPressed.value == true) {
                        this.cancel()
                        _isPlaying.value = false

                    }
                    delay(300)
                    val sound = listOfPoolSounds[(it.id - 1)]
                    soundPool.play(sound, 1F, 1F, 1, 0, 1F)
                }

            }.apply { _isPlaying.value = isActive }
                .invokeOnCompletion {
                    _isPlaying.value = false
                    _onStopPressed.value = true
                }

        } else {
            Toast.makeText(getApplication(), "Record something first", Toast.LENGTH_SHORT).show()
        }
    }

    fun stopShowingSearchSnackbar() {
        _showSnackbarWithMatchingSongs.value = false
    }

    fun onSearchPressed() {
//        val osp = matchSongs(mySuperMelody.value, defaultSongList)
        val osp = matchSongsByIntervals(mySuperMelody.value!!, defaultSongList)
        if (osp.isNotEmpty()) {
            _showSnackbarWithMatchingSongs.value = true

        } else {
            Toast.makeText(
                getApplication(),
                "sorry, can't recognize your melody :(",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun onMenuPressed() {
        _showMenu.value = true
    }

    fun turnOffMenuNavigation() {
        _showMenu.value = false
    }

    fun labelsOnOff() {
        _labelsOnLiveData.value = _labelsOnLiveData.value != true
    }

    fun onSavePressed() {
        if (_preventSavingRecordedOnceAgain.value == false) {

            if (noteList.isNotEmpty() && isRecording.value == false) {
                _navigateToSaveFragment.value = true
            } else if (isRecording.value == true) {
                Toast.makeText(getApplication(), "Recording still ON", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(getApplication(), "Nothing to save", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(
                getApplication(), "Bro, You already have it!\n" +
                        "Record something new :)", Toast.LENGTH_LONG
            ).show()
        }
    }

    fun loadRecordedMelody(melody: Melody, recOrLib: String) {
        if (recOrLib == "recorded") {
            _myMelody.value = "\"${melody.title}\""
        }
        _mySuperMelody.value = melody
        noteList.clear()
        noteList.addAll(melody.melody)
        _noteListSize.value = noteList.size
    }

    fun onNavigatingToSaveFragmentFinished() {
        _navigateToSaveFragment.value = false
    }


    /**
    NEW FEATURE!!! now it filters your melody in ALL KEYS! Doesn't matter what key you started,
    only intervals matter!!!

     */
    private fun isSongMatchedByIntervals(yourMelody: Melody?, libraryMelody: Melody) : Boolean {
        return melodyIntervalIndexes(libraryMelody).contains(melodyIntervalIndexes(yourMelody!!))
    }

    fun matchSongsByIntervals(yourMelody: Melody, library: List<Song>) : List<Song> {
        val matchList = mutableListOf<Song>()
        library.forEach {

            if (isSongMatchedByIntervals(libraryMelody = it.melody, yourMelody = yourMelody)) {
                matchList.add(it)
            }

        }
        return matchList
    }

}