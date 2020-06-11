package com.qndzia.tapformelody.playandrecord

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.qndzia.tapformelody.R
import com.qndzia.tapformelody.databinding.FragmentPlayAndRecordBinding
import kotlinx.android.synthetic.main.fragment_play_and_record.*


class PlayAndRecord : Fragment() {

lateinit var viewModel: PlayAndRecordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentPlayAndRecordBinding.inflate(inflater)

        viewModel = ViewModelProvider(requireActivity()).get(PlayAndRecordViewModel::class.java)
        binding.viewModel = viewModel



//        view?.setOnClickListener {
//            Log.d("chuj", "$it")
//            viewModel.keyPressed(it, context)
//        }




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        keyC.setOnClickListener {
//            var mediaPlayer = MediaPlayer.create(context, R.raw.c)
//            mediaPlayer.start()
//            Handler().postDelayed({
//                mediaPlayer.release()
//            }, 1000)
//        }
        keyCsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.csharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyD.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.d)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyDsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.dsharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyE.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.e)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyF.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.f)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyFsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.fsharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyG.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.g)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyGsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.gsharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyA.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.a)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyAsharp.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.asharp)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyH.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.h)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }
        keyC2.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(context, R.raw.c2)
            mediaPlayer.start()
            Handler().postDelayed({
                mediaPlayer.release()
            }, 1000)
        }


    }

}
