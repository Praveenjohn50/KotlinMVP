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


class AsynkRegistration : AsyncTask<Void, Rdata, Rdata>() {
    /**
     * An Asynk task to demonstrate Kotlin MVP
     */
    private val data = Rdata()
    private var onFinishedlistener: BackgroundInteractor.OnFinishedlistener? = null

    override fun onPreExecute() {
        super.onPreExecute()
        //Updating the Text view
        onFinishedlistener!!.processedData("Registering User...")
        //Updating the Progressbar
        onFinishedlistener?.updateprogressbar(true)


    }

    override fun doInBackground(vararg voids: Void): Rdata {
        //Do Something
        //Do your code here  (e.g)Network calls
        data.replydata = "Register"
        return data
    }

    override fun onPostExecute(s: Rdata) {
        super.onPostExecute(s)
        //Updating the Progressbar
        onFinishedlistener?.updateprogressbar(false)
        //Updating the Text view
        onFinishedlistener!!.processedData(s.replydata!!)

    }


    fun setFinishedListener(onFinishedlistener: BackgroundInteractor.OnFinishedlistener) {
        this.onFinishedlistener = onFinishedlistener
    }
}