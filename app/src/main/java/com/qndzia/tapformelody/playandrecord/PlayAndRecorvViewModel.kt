package com.qndzia.tapformelody.playandrecord

import android.app.Application
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Handler
import android.view.Gravity
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.qndzia.tapformelody.R

import com.qndzia.tapformelody.notes.Note

//lateinit var soundPool: SoundPool

class PlayAndRecordViewModel(application: Application) : AndroidViewModel(application) {

    private var _isRecording = MutableLiveData<Boolean>()
    val isRecording: LiveData<Boolean> = _isRecording

    private var _myMelody = MutableLiveData<String>()
    val myMelody: LiveData<String> = _myMelody

    private var _noteListSize = MutableLiveData<Int>()
    val noteListSize: LiveData<Int> = _noteListSize

    private val noteList = mutableListOf<Note>()

    private var blockAdding = true

    private var _showSaveDialog = MutableLiveData<Boolean>()
    val showSaveDialog: LiveData<Boolean> = _showSaveDialog

    var soundC: Int
    var soundCsharp: Int
    var soundD: Int
    var soundDsharp: Int
    var soundE: Int
    var soundF: Int
    var soundFsharp: Int
    var soundG: Int
    var soundGsharp: Int
    var soundA: Int
    var soundAsharp: Int
    var soundH: Int
    var soundC2: Int

    init {
        _isRecording.value = false
        _myMelody.value = ""
        _showSaveDialog.value = false

        soundC = soundPool.load(getApplication(), R.raw.c, 1)
        soundCsharp = soundPool.load(getApplication(),R.raw.csharp, 1)
        soundD = soundPool.load(getApplication(),R.raw.d, 1)
        soundDsharp = soundPool.load(getApplication(),R.raw.dsharp, 1)
        soundE = soundPool.load(getApplication(),R.raw.e, 1)
        soundF = soundPool.load(getApplication(),R.raw.f, 1)
        soundFsharp = soundPool.load(getApplication(),R.raw.fsharp, 1)
        soundG = soundPool.load(getApplication(),R.raw.g, 1)
        soundGsharp = soundPool.load(getApplication(),R.raw.gsharp, 1)
        soundA = soundPool.load(getApplication(),R.raw.a, 1)
        soundAsharp = soundPool.load(getApplication(),R.raw.asharp, 1)
        soundH = soundPool.load(getApplication(),R.raw.h, 1)
        soundC2 = soundPool.load(getApplication(),R.raw.c2, 1)








    }

    companion object {
        var audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        var soundPool = SoundPool.Builder()
            .setMaxStreams(20)
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

    private fun keyPressed(note: Note, sound: Int) {

        soundPool.play(sound, 1F, 1F, 1, 0, 1F)


//        val mediaPlayer = MediaPlayer.create(getApplication(), note.sound)
//        mediaPlayer.start()
//        Handler().postDelayed({
//            mediaPlayer.release()
//        }, 1000)



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

    fun onRecordPressed() {

        if (_isRecording.value == true) {
            _isRecording.value = false
            blockAdding = true
            val toast = Toast.makeText(
                getApplication(), "REC is OFF",
                Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.TOP, 0, 80)
            toast.show()
        } else {
            val toast = Toast.makeText(
                getApplication(), "REC is ON!!!",
                Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.TOP, 0, 80)
            toast.show()

            _isRecording.value = true
            _myMelody.value = ""
            noteList.clear()
            blockAdding = false
        }
    }

    // trzeba bęedzie rozwiązać problem z nowymi instancjami mediaPlayera
    // podobnie z opcją samego grania, nie tylko z zapisem
    fun onPlayPressed() {
        if (noteList.isNotEmpty()) {
            Toast.makeText(getApplication(), "Your melody is playing", Toast.LENGTH_SHORT).show()
            noteList.forEach {
                Thread.sleep(300)
                val mediaPlayer = MediaPlayer.create(getApplication(), it.sound)
                mediaPlayer.start()
                Handler().postDelayed({
                    mediaPlayer.release()
                }, 300)
            }
        } else {
            Toast.makeText(getApplication(), "Record something first", Toast.LENGTH_SHORT).show()
        }
    }

    fun onSavePressed() {
        if (noteList.isNotEmpty() && isRecording.value == false) {
            _showSaveDialog.value = true
        } else if (isRecording.value == true) {
            Toast.makeText(getApplication(), "Recording still ON", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(getApplication(), "Nothing to save", Toast.LENGTH_SHORT).show()
        }
    }

    fun hideSaveDialog() {
        _showSaveDialog.value = false
    }





}