package com.sample.praveen.audiorecorder

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaRecorder
import com.sample.praveen.model.Rdata
import java.io.File
import java.io.FileInputStream
import java.io.IOException

/**
 * Created by Praveen John on 08,January,2019
 */
class AudioRecorder {
    /**
     * This Class Records Audio and stores it to a temporary directory
     * It is not stored permanently
     * There are predefined methods for operation
     */
    private var recorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var audiofile: File? = null


    /* Call this Method to start Audio recording*/
    fun startrecord(context: Context) {
        try {
            recorder = MediaRecorder()
            audiofile = File.createTempFile(Rdata.FILENAME, null, context.cacheDir)
            recorder!!.setAudioSource(MediaRecorder.AudioSource.DEFAULT)
            recorder!!.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            recorder!!.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
            recorder!!.setOutputFile(audiofile!!.path)
            recorder!!.prepare()
            recorder!!.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /* Call this Method to stop Audio recording*/
    fun stoprecord() {
        if (recorder != null) {
            recorder!!.stop()
            recorder!!.reset()
            recorder!!.release()


        }

    }

    /* Call this Method to Play the temporary Audio file recording*/
    fun playfile(): Boolean {
        val file = audiofile
        mediaPlayer = MediaPlayer()
        if (file == null) {
            return false
        }

        try {
            val `is` = FileInputStream(file!!.absolutePath)
            mediaPlayer!!.setDataSource(`is`.fd)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return true
    }


    /* Call this Method to Stop Playing the temporary Audio file recording*/
    fun stopplaying() {

        if (mediaPlayer != null && !mediaPlayer!!.isPlaying) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
        }

    }

}
