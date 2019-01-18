package com.sample.praveen.presenter

/**
 * Created by Praveen John on 08,January,2019
 */
interface MainFragmentPresenter {
    // Main Fragment Presenter to Handle the Ui changes and Send the Information to the Background
    fun onRegisterButtonClick()
    fun onPostButtonClick()
    fun onRecordButtonClick()
    fun onStopButtonClick()
    fun onPlayButtonClick()
    fun onEndButtonClick()
}