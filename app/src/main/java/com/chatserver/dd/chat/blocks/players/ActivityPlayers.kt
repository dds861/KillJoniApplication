package com.chatserver.dd.chat.blocks.players

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chatserver.dd.chat.R
import com.chatserver.dd.chat.model.Status
import kotlinx.android.synthetic.main.activity_player.*


class ActivityPlayers : AppCompatActivity(), UIEventManager {

    private lateinit var viewModel: ViewModelPlayersActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val viewModelPlayersActivityFactory = ViewModelPlayersActivityFactory(this)
        viewModel = ViewModelProvider(this, viewModelPlayersActivityFactory).get(ViewModelPlayersActivity::class.java)
        getData()

        fab_btn_cmd.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
        viewModel.getData().observe(this, Observer {

            setDataToRecyclerView(it)
        })
    }

    fun setDataToRecyclerView(status: Status) {
        recyclerViewMain.apply {
            layoutManager = LinearLayoutManager(this@ActivityPlayers)
            adapter = AdapterPlayers(status)
        }
    }

    override fun viewProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun stopProgressBar() {
        progress_bar.visibility = View.GONE
    }

    override fun viewEmptyText() {
        tv_list_is_empty.visibility = View.VISIBLE
    }

    override fun stopEmptyText() {
        tv_list_is_empty.visibility = View.GONE
    }

    override fun viewToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}
