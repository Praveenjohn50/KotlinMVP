package com.sample.praveen.mykotlinmvp

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.FrameLayout

@SuppressLint("ByteOrderMark")
class MainActivity : AppCompatActivity() {
    var mainFrame: FrameLayout? = null
    var fragment: Fragment? = null
    var fragmentManager: FragmentManager? = null
    private val TAG = "PermissionDemo"
    private val RECORD_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()     //Initialize the Main Activity view
        loadfragment() //Load the Main Fragment
        setupPermissions() //Setup the user Permission
    }




    private fun initview() {
        mainFrame = findViewById(R.id.main_frame)
        fragment = Fragment()
        fragmentManager = supportFragmentManager

    }


    private fun loadfragment() {
        val mainFragment = MainFragment()
        val fragmenttrasaction = fragmentManager!!.beginTransaction()
        fragmenttrasaction.add(R.id.main_frame, mainFragment)
        fragmenttrasaction.addToBackStack(mainFragment.tag)
        fragmenttrasaction.commit()
    }
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.RECORD_AUDIO)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to record denied")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            RECORD_REQUEST_CODE)


    }



}
