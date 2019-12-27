package com.Serverserver.dd.Server.blocks.Server

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chatserver.dd.chat.R
import com.chatserver.dd.chat.model.Vip

class AdapterVip(val usersAllWords: List<Vip>) : RecyclerView.Adapter<AdapterVip.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_vip, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.eventTime.text = usersAllWords[position].eventTime
        holder.message.text = usersAllWords[position].message
        holder.lastName.text = usersAllWords[position].lastName
    }

    override fun getItemCount(): Int {
        return usersAllWords.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var eventTime: TextView = itemView.findViewById<View>(R.id.eventTimeChat) as TextView
        var message: TextView = itemView.findViewById<View>(R.id.message) as TextView
        var lastName: TextView = itemView.findViewById<View>(R.id.lastName) as TextView
    }
}