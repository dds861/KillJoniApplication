package com.chatserver.dd.chat.blocks.chat

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chatserver.dd.chat.R
import com.chatserver.dd.chat.model.Chat
import kotlinx.android.synthetic.main.activity_chat.*


class ActivityChat : AppCompatActivity() {

    private lateinit var viewModel: ViewModelChatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        showToast("Started")
        viewModel = ViewModelProvider(this).get(ViewModelChatActivity::class.java)
        getData()
    }

    private fun getData() {
        viewModel.liveData.observe(this, Observer {
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
}
