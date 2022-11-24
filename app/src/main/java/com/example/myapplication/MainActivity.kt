package com.example.myapplication

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var mPlayerdog: MediaPlayer? = null
    var mPlayercat: MediaPlayer? = null
    var mPlayerbird: MediaPlayer? = null
    var dogbutton: ImageButton? = null
    var catbutton: ImageButton? = null
    var birdbutton: ImageButton? = null
    var audioManager: AudioManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPlayerdog = MediaPlayer.create(this, R.raw.gav)
        mPlayercat = MediaPlayer.create(this, R.raw.miau)
        mPlayerbird = MediaPlayer.create(this, R.raw.tsvirin)
        mPlayerdog!!.setOnCompletionListener { stopPlay() }
        mPlayercat!!.setOnCompletionListener { stopPlay() }
        mPlayerbird!!.setOnCompletionListener { stopPlay() }
        dogbutton = findViewById(R.id.dogbutton)
        catbutton = findViewById(R.id.catbutton)
        birdbutton = findViewById(R.id.birdbutton)

        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
    }

    private fun stopPlay() {
        mPlayerdog!!.stop()
        mPlayercat!!.stop()
        mPlayerbird!!.stop()
        try {
            mPlayerdog!!.prepare()
            mPlayercat!!.prepare()
            mPlayerbird!!.prepare()
            mPlayerdog!!.seekTo(0)
            mPlayercat!!.seekTo(0)
            mPlayerbird!!.seekTo(0)
        } catch (t: Throwable) {
            Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun playcat(view: View?) {
        catbutton!!.isEnabled = true
        mPlayercat!!.start()
    }

    fun playdog(view: View?) {
        dogbutton!!.isEnabled = true
        mPlayerdog!!.start()
    }

    fun playbird(view: View?) {
        birdbutton!!.isEnabled = true
        mPlayerbird!!.start()
    }
}