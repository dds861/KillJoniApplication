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


class ActivityPlayers : AppCompatActivity() {

    private lateinit var viewModel: ViewModelPlayersActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        init()

        showToast("Started")
        progress_bar.visibility = View.VISIBLE
        getData()
    }

    private fun getLiveData() {
        viewModel = ViewModelProvider(this).get(ViewModelPlayersActivity::class.java)

    }

    private fun init() {
        fl_btn_cmd.setOnClickListener {
            tv_list_is_empty.visibility = View.GONE
            progress_bar.visibility = View.VISIBLE
            getData()
        }
    }

    private fun getData() {
        getLiveData()
        viewModel.liveData.observe(this, Observer {

            progress_bar.visibility = View.GONE

            if (it.data.p.isEmpty()) {
                tv_list_is_empty.visibility = View.VISIBLE
            } else {
                tv_list_is_empty.visibility = View.VISIBLE
            }

            setDataToRecyclerView(it)
        })
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun setDataToRecyclerView(status: Status) {
        recyclerViewMain.apply {
            layoutManager = LinearLayoutManager(this@ActivityPlayers)
            adapter = AdapterPlayers(status)
        }
    }
}
