package com.sample.praveen.interfaces

/**
 * Created by Praveen John on 08,January,2019
 */
interface BackgroundInteractor {
    //An Interface that interacts with the background Process

    fun registerUser()

    fun postWord()

    fun recordAudio()

    fun stopAudioRec()

    fun playAudio()

    fun endAudio()

    interface OnFinishedlistener {
        fun processedData(data: String)
        fun updateprogressbar(show :Boolean)
    }
}
