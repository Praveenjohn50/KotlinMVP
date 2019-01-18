package com.sample.praveen.mykotlinmvp

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.sample.praveen.fragments.MainFragmentImpl
import com.sample.praveen.presenter.MainFragmentPresenter
import com.sample.praveen.view.MainFragmentView

/**
 * Created by Praveen John on 07,January,2019
 */
class MainFragment : Fragment(), View.OnClickListener, MainFragmentView {

    /**
     * This is the main Fragment that loads during the application startup
     */

    private var rootview: View? = null
    private var mButtonPost: Button? = null
    private var mButtonWord: Button? = null
    private var mButtonStartRecord: Button? = null
    private var mButtonStopRecord: Button? = null
    private var mButtonPlayStart: Button? = null
    private var mButtonPlayEnd: Button? = null
    private var mDisplaytextView: TextView? = null
    private var mainFragmentPresenter: MainFragmentPresenter? = null
    private var mProgressBar :ProgressBar?=null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootview = inflater.inflate(R.layout.fragment_main, container, false) //Inflate the fragment
        return rootview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initview(view) //Initializing the view

    }

    private fun initview(view: View) {
        mButtonPost = view.findViewById(R.id.create_user_post) as Button
        mButtonWord = view.findViewById(R.id.send_word_post) as Button
        mButtonStartRecord = view.findViewById(R.id.start_record) as Button
        mButtonStopRecord = view.findViewById(R.id.stop_record) as Button
        mButtonPlayStart = view.findViewById(R.id.play_start) as Button
        mButtonPlayEnd = view.findViewById(R.id.play_end) as Button
        mDisplaytextView = view.findViewById(R.id.display_text_view) as TextView
        mProgressBar=view.findViewById(R.id.progressbar) as ProgressBar
        mButtonPost!!.setOnClickListener(this)
        mButtonWord!!.setOnClickListener(this)
        mButtonStartRecord!!.setOnClickListener(this)
        mButtonStopRecord!!.setOnClickListener(this)
        mButtonPlayStart!!.setOnClickListener(this)
        mButtonPlayEnd!!.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.create_user_post -> mainFragmentPresenter?.onRegisterButtonClick()
            R.id.send_word_post -> mainFragmentPresenter?.onPostButtonClick()
            R.id.start_record -> mainFragmentPresenter?.onRecordButtonClick()
            R.id.stop_record -> mainFragmentPresenter?.onStopButtonClick()
            R.id.play_start -> mainFragmentPresenter?.onPlayButtonClick()
            R.id.play_end -> mainFragmentPresenter?.onEndButtonClick()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainFragmentPresenter = MainFragmentImpl(BackgroundInteractImpl(context!!, this))
    }

    override fun updateStatus(data: String) {
        //Updating the Text view
        mDisplaytextView?.text = data
    }
    override fun updateprogressbar(show: Boolean) {
        //Updating the progress bar
        //if Boolean true sets progressbar visible
        //if boolean falase sets the progressbar invisible
        if(show)
        {
            mProgressBar?.visibility=View.VISIBLE
        }
        else
        {
            mProgressBar?.visibility=View.INVISIBLE
        }

    }

}