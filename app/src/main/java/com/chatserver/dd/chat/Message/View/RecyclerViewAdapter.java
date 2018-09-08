package com.chatserver.dd.chat.Message.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chatserver.dd.chat.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<User> item;
    Context context ;

    public RecyclerViewAdapter(Context context, List<User> item ) {
        Log.d("123", "RecyclerViewAdapter");
        this.item = item;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("123", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.content_message, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("123", "onBindViewHolder");
//        holder.tv_PlayerPid.setText(item.get(position).getName());
//        holder.hobby.setText(item.get(position).getHobby());
    }

    @Override
    public int getItemCount() {
        Log.d("123", "getItemCount");
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_PlayerPid;
        private TextView tv_PlayerName;
        private TextView tv_PlayerScore;
        private TextView tv_PlayerTime;
        private CheckBox checkBox_player_select;


        public ViewHolder(View itemView) {
            super(itemView);
            Log.d("123", "ViewHolder");

            this.tv_PlayerPid = (TextView) itemView.findViewById(R.id.tv_Id);
            this.tv_PlayerName = (TextView) itemView.findViewById(R.id.tv_Name);
            this.tv_PlayerScore = (TextView) itemView.findViewById(R.id.tv_Score);
            this.tv_PlayerTime = (TextView) itemView.findViewById(R.id.tv_Time);
            this.checkBox_player_select = itemView.findViewById(R.id.checkBox_player_select);
        }
    }
}
