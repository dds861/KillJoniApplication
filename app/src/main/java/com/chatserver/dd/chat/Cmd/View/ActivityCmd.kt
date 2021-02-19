package com.chatserver.dd.chat.Cmd.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chatserver.dd.chat.Cmd.Model.ModelCmd
import com.chatserver.dd.chat.Cmd.Presenter.PresenterCmd
import com.chatserver.dd.chat.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ActivityCmd : AppCompatActivity(), IViewCmd, View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private var mRecyclerViewMain: RecyclerView? = null
    private var presenterCmd: PresenterCmd? = null
    private var mSendBtn: Button? = null
    private var mEtTextCommands: EditText? = null
    private var mBtnCmdFl: ImageButton? = null
    private var mClearEdittextBtn: Button? = null
    private var subscription: Disposable? = null
    private var mProgressBar: ProgressBar? = null
    private var mListIsEmptyTv: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cmd)
        initView()
        presenterCmd = PresenterCmd(this, ModelCmd())
        onStartListenInputs()
    }

    private fun onStartListenInputs() {
        subscription = Observable.interval(1000, 30000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe { aLong ->
                Log.i("autolog", "aLong: $aLong")
                presenterCmd!!.requestDataFromServer()
            }
    }

    override fun onPause() {
        super.onPause()
        subscription!!.dispose()
    }

    private fun initView() {
        mRecyclerViewMain = findViewById<View>(R.id.recycler_view_players) as RecyclerView
        mEtTextCommands = findViewById<View>(R.id.etTextCommands) as EditText
        mSendBtn = findViewById<View>(R.id.btn_send) as Button
        mSendBtn!!.setOnClickListener(this)
        mBtnCmdFl = findViewById<View>(R.id.IbRefresh) as ImageButton
        mBtnCmdFl!!.setOnClickListener(this)
        mClearEdittextBtn = findViewById<View>(R.id.btn_clear_edittext) as Button
        mClearEdittextBtn!!.setOnClickListener(this)
        mProgressBar = findViewById<View>(R.id.progress_bar) as ProgressBar
        mListIsEmptyTv = findViewById<View>(R.id.tv_list_is_empty) as TextView
    }


    override fun onResponseFailure(throwable: Throwable?) {
        Toast.makeText(this, throwable!!.message, Toast.LENGTH_SHORT).show()
    }

    override var edittext: String?
        get() = mEtTextCommands!!.text.toString()
        set(playerName) {
            mEtTextCommands!!.setText(playerName)
        }

    override fun showToast(text: String?) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_send -> {
                presenterCmd!!.onExecuteCmd(mEtTextCommands!!.text.toString())
                presenterCmd!!.onRefreshButtonClick()
            }
            R.id.IbRefresh -> presenterCmd!!.onRefreshButtonClick()
            R.id.btn_clear_edittext -> mEtTextCommands!!.setText("")
            else -> {
            }
        }
    }

    override fun onCheckedChanged(radioGroup: RadioGroup, i: Int) {
        val playerName = (findViewById<View>(radioGroup.checkedRadioButtonId) as RadioButton).text.toString()
        presenterCmd!!.onSetCmdToEditText(playerName)
    }

    override fun showProgressBar() {
        mProgressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        mProgressBar!!.visibility = View.GONE
    }

    override fun listIsEmpty() {
        mListIsEmptyTv!!.visibility = View.VISIBLE
    }

    override fun listIsNotEmpty() {
        mListIsEmptyTv!!.visibility = View.GONE
    }

    override fun setDataToRecyclerView(sorted: List<ViewStatusPlayers.P?>) {
        val layoutManager = LinearLayoutManager(this@ActivityCmd)
        mRecyclerViewMain!!.layoutManager = layoutManager
        val recyclerViewAdapter = AdapterCmd(sorted, presenterCmd)
        mRecyclerViewMain!!.adapter = recyclerViewAdapter
    }
}