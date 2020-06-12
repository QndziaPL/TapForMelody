package com.qndzia.tapformelody.playandrecord

import android.app.Application
import android.media.MediaPlayer
import android.os.Handler
import android.view.Gravity
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.qndzia.tapformelody.notes.Note


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


    fun cKeyPressed() {
        keyPressed(Note.C)
    }

    fun cSharpKeyPressed() {
        keyPressed(Note.Csharp)
    }

    fun dKeyPressed() {
        keyPressed(Note.D)
    }

    fun dSharpKeyPressed() {
        keyPressed(Note.Dsharp)
    }

    fun eKeyPressed() {
        keyPressed(Note.E)
    }

    fun fKeyPressed() {
        keyPressed(Note.F)
    }

    fun fSharpKeyPressed() {
        keyPressed(Note.Fsharp)
    }

    fun gKeyPressed() {
        keyPressed(Note.G)
    }

    fun gSharpKeyPressed() {
        keyPressed(Note.Gsharp)
    }

    fun aKeyPressed() {
        keyPressed(Note.A)
    }

    fun aSharpKeyPressed() {
        keyPressed(Note.Asharp)
    }

    fun hKeyPressed() {
        keyPressed(Note.H)
    }

    fun c2KeyPressed() {
        keyPressed(Note.C2)
    }

    private fun keyPressed(note: Note) {
        val mediaPlayer = MediaPlayer.create(getApplication(), note.sound)
        mediaPlayer.start()
        Handler().postDelayed({
            mediaPlayer.release()
        }, 1000)

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


    init {
        _isRecording.value = false
        _myMelody.value = ""
        _showSaveDialog.value = false

    }


}