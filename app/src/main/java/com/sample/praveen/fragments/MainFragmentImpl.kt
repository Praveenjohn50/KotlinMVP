package com.sample.praveen.fragments

import com.sample.praveen.interfaces.BackgroundInteractor
import com.sample.praveen.presenter.MainFragmentPresenter

/**
 * Created by Praveen John on 08,January,2019
 */
class MainFragmentImpl(private val backgroundInteractor: BackgroundInteractor) : MainFragmentPresenter {
    // Implementation of the Main Fragment


    override fun onRegisterButtonClick() {
        backgroundInteractor.registerUser()

    }

    override fun onPostButtonClick() {
        backgroundInteractor.postWord()

    }

    override fun onRecordButtonClick() {
        backgroundInteractor.recordAudio()

    }

    override fun onStopButtonClick() {
        backgroundInteractor.stopAudioRec()

    }

    override fun onPlayButtonClick() {
        backgroundInteractor.playAudio()
    }

    override fun onEndButtonClick() {
        backgroundInteractor.endAudio()
    }
}
