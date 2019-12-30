package com.chatserver.dd.chat.blocks.players

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chatserver.dd.chat.R
import com.chatserver.dd.chat.model.Status
import kotlinx.android.synthetic.main.content_player.view.*

class AdapterPlayers(val status: Status) : RecyclerView.Adapter<AdapterPlayers.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_player, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_PlayerPid.text = (position + 1).toString()
        holder.itemView.tv_Name.text = status.data.p[position].name
        holder.itemView.tv_Score.text = status.data.p[position].score.toString()
        holder.itemView.tv_Time.text = status.data.p[position].time

    }

    override fun getItemCount(): Int {
        return status.data.p.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}