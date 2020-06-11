package com.qndzia.tapformelody.playandrecord

import android.app.Application
import android.media.MediaPlayer
import android.os.Handler
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.qndzia.tapformelody.notes.Note


class PlayAndRecordViewModel(application: Application) : AndroidViewModel(application) {


    private var _isRecording = MutableLiveData<Boolean>()
    val isRecording: LiveData<Boolean> = _isRecording

    private var _myMelody = MutableLiveData<String>()
    val myMelody:  LiveData<String> = _myMelody





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
        var mediaPlayer = MediaPlayer.create(getApplication(), note.sound)
        mediaPlayer.start()
        Handler().postDelayed({
            mediaPlayer.release()
        }, 1000)

        _myMelody.value = _myMelody.value + note.noteName + " "

//        while(_isRecording.value == true) {
//            _myMelody.value?.apply { add(note) }
//        }

    }

    fun onRecordPressed() {
        _isRecording.value = _isRecording.value == false

    }






    init {
        _isRecording.value = false
        _myMelody.value = ""
    }

}