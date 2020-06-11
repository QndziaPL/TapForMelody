package com.qndzia.tapformelody

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.Delayed

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        keyC.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.c)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyCsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.csharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyD.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.d)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyDsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.dsharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyE.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.e)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyF.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.f)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyFsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.fsharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyG.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.g)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyGsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.gsharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyA.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.a)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyAsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.asharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyH.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.h)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyC2.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(applicationContext, R.raw.c2)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }

    }


}


