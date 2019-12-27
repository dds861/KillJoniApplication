package com.chatserver.dd.chat.blocks.players

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chatserver.dd.chat.R
import com.chatserver.dd.chat.model.Status

class AdapterPlayers(val status: Status) : RecyclerView.Adapter<AdapterPlayers.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_player, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_Name.text = status.data.p[position].name
        holder.tv_Score.text = status.data.p[position].score.toString()
        holder.tv_Time.text = status.data.p[position].time
    }

    override fun getItemCount(): Int {
        return status.data.p.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_Name: TextView = itemView.findViewById<View>(R.id.tv_Name) as TextView
        var tv_Score: TextView = itemView.findViewById<View>(R.id.tv_Score) as TextView
        var tv_Time: TextView = itemView.findViewById<View>(R.id.tv_Time) as TextView
    }
}