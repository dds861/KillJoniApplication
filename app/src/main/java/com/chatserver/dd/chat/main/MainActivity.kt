package com.chatserver.dd.chat.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.chatserver.dd.chat.R
import com.chatserver.dd.chat.blocks.admin.ActivityAdmin
import com.chatserver.dd.chat.blocks.chat.ActivityChat
import com.chatserver.dd.chat.blocks.players.ActivityPlayers
import com.chatserver.dd.chat.blocks.server.ActivityServer
import com.chatserver.dd.chat.blocks.vip.ActivityVip
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()


    }

    private fun initView() {
        btn_AllWords.setOnClickListener(this)
        btn_Server.setOnClickListener(this)
        btn_Vip.setOnClickListener(this)
        btn_Admins.setOnClickListener(this)
        btn_Cmd.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent?
        when (v.id) {
            R.id.btn_AllWords -> {
                // TODO 18/09/06
                intent = Intent(applicationContext, ActivityChat::class.java)
                startActivity(intent)
            }
            R.id.btn_Server -> {
                // TODO 18/09/06
                intent = Intent(applicationContext, ActivityServer::class.java)
                startActivity(intent)
            }
            R.id.btn_Vip -> {
                // TODO 18/09/06
                intent = Intent(applicationContext, ActivityVip::class.java)
                startActivity(intent)
            }
            R.id.btn_Admins -> {
                // TODO 18/09/06
                intent = Intent(applicationContext, ActivityAdmin::class.java)
                startActivity(intent)
            }
            R.id.btn_Cmd -> {
                intent = Intent(applicationContext, ActivityPlayers::class.java)
                startActivity(intent)
            }
            else -> {
            }
        }
    }
}