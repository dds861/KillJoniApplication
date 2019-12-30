package com.chatserver.dd.chat.blocks.chat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chatserver.dd.chat.R
import com.chatserver.dd.chat.constants.ConstantsApp
import com.chatserver.dd.chat.model.Chat
import kotlinx.android.synthetic.main.activity_chat.*


class ActivityChat : AppCompatActivity(), UIEventManager {


    private lateinit var viewModel: ViewModelChatActivity
    lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)


        val viewModelChatActivityFactory = ViewModelChatActivityFactory(this)
        viewModel = ViewModelProvider(this, viewModelChatActivityFactory).get(ViewModelChatActivity::class.java)

        getData()
        init()

    }

    private fun init() {
        fab_update_chat.setOnClickListener {
            getData()
        }

        btn_send_message_to_chat.setOnClickListener {
            sendMessage()
        }

        btn_delete_message.setOnClickListener {
            et_message_to_send.text.clear()
        }
    }

    private fun sendMessage() {
        viewModel.sendMessage(et_message_to_send.text.toString()).observe(this, Observer {
            if (it.status == ConstantsApp.OK) {
                getData()
            }
        })
    }

    private fun getData() {
        viewModel.getData().observe(this, Observer {
            setDataToRecyclerView(it)
        })
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun setDataToRecyclerView(userList: List<Chat>) {
        recyclerViewMain.apply {
            layoutManager = LinearLayoutManager(this@ActivityChat)
            adapter = AdapterChat(userList)
        }
    }

    override fun viewProgressBar() {
        progress_bar_chat.visibility = View.VISIBLE
    }

    override fun stopProgressBar() {
        progress_bar_chat.visibility = View.GONE
    }

    override fun viewToast(s: String) {
        Toast.makeText(applicationContext, s, Toast.LENGTH_SHORT).show()
    }
}
