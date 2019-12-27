package com.chatserver.dd.chat.blocks.vip

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.Serverserver.dd.Server.blocks.Server.AdapterVip
import com.chatserver.dd.chat.R
import com.chatserver.dd.chat.model.Vip
import kotlinx.android.synthetic.main.activity_chat.*


class ActivityVip : AppCompatActivity() {

    private lateinit var viewModel: ViewModelVipActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vip)

        showToast("Started")
        viewModel = ViewModelProvider(this).get(ViewModelVipActivity::class.java)
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

    fun setDataToRecyclerView(list: List<Vip>) {
        recyclerViewMain.apply {
            layoutManager = LinearLayoutManager(this@ActivityVip)
            adapter = AdapterVip(list)
        }
    }
}
