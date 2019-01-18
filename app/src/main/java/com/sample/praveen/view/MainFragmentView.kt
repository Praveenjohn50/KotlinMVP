package com.sample.praveen.view

/**
 * Created by Praveen John on 08,January,2019
 */

interface MainFragmentView {
    //To Pass Information From the background to the Ui
    fun updateStatus(data: String)
    fun updateprogressbar(show:Boolean)
}