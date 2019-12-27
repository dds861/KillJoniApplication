package com.chatserver.dd.chat.blocks.server

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.Serverserver.dd.Server.blocks.Server.AdapterServer
import com.chatserver.dd.chat.R
import com.chatserver.dd.chat.model.Server
import kotlinx.android.synthetic.main.activity_chat.*


class ActivityServer : AppCompatActivity() {

    private lateinit var viewModel: ViewModelServerActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server)

        showToast("Started")
        viewModel = ViewModelProvider(this).get(ViewModelServerActivity::class.java)
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

    fun setDataToRecyclerView(userList: List<Server>) {
        recyclerViewMain.apply {
            layoutManager = LinearLayoutManager(this@ActivityServer)
            adapter = AdapterServer(userList)
        }
    }
}
