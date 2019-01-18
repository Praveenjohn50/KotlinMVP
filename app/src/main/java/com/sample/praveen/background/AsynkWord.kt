package com.sample.praveen.background

import android.os.AsyncTask
import android.util.Log
import com.sample.praveen.interfaces.BackgroundInteractor
import com.sample.praveen.model.Rdata
import org.json.JSONObject
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

/**
 * Created by Praveen John on 08,January,2019
 */
class AsynkWord : AsyncTask<Void, Rdata, Rdata>() {
    private val data = Rdata()
    private var finished: BackgroundInteractor.OnFinishedlistener? = null
    /**
     * An Asynk task to demonstrate Kotlin MVP
     */

    fun setFinished(finished: BackgroundInteractor.OnFinishedlistener) {
        this.finished = finished
    }

    override fun onPreExecute() {
        super.onPreExecute()
        //Updating the Text View
        finished!!.processedData("Loading.....")
        //Updating the Progressbar
        finished?.updateprogressbar(true)

    }

    override fun doInBackground(vararg voids: Void): Rdata {
        //Do Something
        //Do your code here  (e.g)Network calls
        data.replydata = "Do Something"


        return data
    }

    override fun onPostExecute(s: Rdata) {
        super.onPostExecute(s)
        finished!!.processedData(s.replydata!!)
        finished?.updateprogressbar(false)

    }


}