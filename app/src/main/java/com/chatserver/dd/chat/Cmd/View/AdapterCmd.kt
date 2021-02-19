package com.chatserver.dd.chat.Cmd.View

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chatserver.dd.chat.Cmd.Presenter.IPresenterCmd
import com.chatserver.dd.chat.R

class AdapterCmd(private val sorted: List<ViewStatusPlayers.P?>, iPresenterCmd: IPresenterCmd?) : RecyclerView.Adapter<AdapterCmd.ViewHolder>() {
    private var iPresenterCmd: IPresenterCmd? = null
    private var lastSelectedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_cmd, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewStatusPlayers2 = sorted[position]
        holder.tv_PlayerPid.text = viewStatusPlayers2?.pid.toString()
        holder.tv_Name.text = viewStatusPlayers2?.name
        holder.tv_Score.text = viewStatusPlayers2?.score.toString()
        holder.tv_Time.text = viewStatusPlayers2?.time
        holder.radioButton.isChecked = lastSelectedPosition == position
    }

    override fun getItemCount(): Int {
        return sorted.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tv_PlayerPid: TextView
        val tv_Name: TextView
        val tv_Score: TextView
        val tv_Time: TextView
        val radioButton: RadioButton
        private val linearLayout: LinearLayout
        override fun onClick(view: View) {
            lastSelectedPosition = adapterPosition
            notifyDataSetChanged()
            Log.i("autolog", "tv_Name.getText(): " + tv_Name.text)
            iPresenterCmd!!.onSetNameToEditText(tv_Name.text.toString())
        }

        init {
            tv_PlayerPid = itemView.findViewById<View>(R.id.tv_PlayerPid) as TextView
            tv_Name = itemView.findViewById<View>(R.id.tv_Name) as TextView
            tv_Score = itemView.findViewById<View>(R.id.tv_Score) as TextView
            tv_Time = itemView.findViewById<View>(R.id.tv_Time) as TextView
            radioButton = itemView.findViewById(R.id.radiobtn_player_select)
            linearLayout = itemView.findViewById(R.id.linearLayout)
            linearLayout.setOnClickListener(this)
            tv_PlayerPid.setOnClickListener(this)
            tv_Name.setOnClickListener(this)
            tv_Score.setOnClickListener(this)
            tv_Time.setOnClickListener(this)
            radioButton.setOnClickListener(this)
        }
    }

    init {
        this.iPresenterCmd = iPresenterCmd
    }
}