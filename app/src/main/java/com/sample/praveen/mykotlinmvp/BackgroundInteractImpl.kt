package com.sample.praveen.mykotlinmvp

import android.content.Context
import com.sample.praveen.audiorecorder.AudioRecorder
import com.sample.praveen.background.AsynkRegistration
import com.sample.praveen.background.AsynkWord
import com.sample.praveen.interfaces.BackgroundInteractor
import com.sample.praveen.view.MainFragmentView

/**
 * Created by Praveen John on 08,January,2019
 */

class BackgroundInteractImpl(private val context: Context, private val mainView: MainFragmentView) :
    BackgroundInteractor, BackgroundInteractor.OnFinishedlistener {
    /**
     * Implementation of the background Interface
     */

    private val audioRecorder = AudioRecorder()
    private var isFileAvailable: Boolean? = false

    override fun registerUser() {
        //Button click task here
        registerAsynk()

    }

    override fun postWord() {
        //Button click task here

        postWord1()
    }

    override fun recordAudio() {
        //To Start the Audio recorder from Button click
        audioRecorder.startrecord(context)


    }

    override fun stopAudioRec() {
        //To Stop the Audio recorder from Button click

        audioRecorder.stoprecord()

    }

    override fun playAudio() {
        //To Play the recorded audio file
        isFileAvailable = audioRecorder.playfile()
        if (isFileAvailable == false) {
            mainView.updateStatus("File Not found Please Record First")
        } else {
            mainView.updateStatus("Playing File")
        }

    }

    override fun endAudio() {
        //To stop the Playing audio file
        audioRecorder.stopplaying()

    }

    private fun registerAsynk() {
        //Function that is called from the first button click
        val asynkRegistration = AsynkRegistration()
        asynkRegistration.setFinishedListener(this)
        asynkRegistration.execute()
    }

    private fun postWord1() {
        //Function that is called from the second button click

        val asynkWord = AsynkWord()
        asynkWord.setFinished(this)
        asynkWord.execute()
    }

    override fun processedData(data: String) {
        //Callback that is used to update the text view
        mainView.updateStatus(data)
    }

    override fun updateprogressbar(show: Boolean) {
        //Callback that updates the Progressbar status
        mainView.updateprogressbar(show)
    }
}
