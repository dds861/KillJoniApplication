package com.chatserver.dd.chat.Status.Presenter;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.chatserver.dd.chat.Status.Model.CmdRunConsole;
import com.chatserver.dd.chat.R;

import java.util.ArrayList;

public class CmdMain {

    private Context context;


    public CmdMain(Context context) {
        this.context = context;
    }

    public void cmdCommandsRadioGroup(ArrayList<String> playerName, RadioGroup radioGroup, EditText edMessage) {
        String cmdCommand;

        for (int i = 0; i < playerName.size(); i++) {
            String playerName1 = playerName.get(i);


            switch (radioGroup.getCheckedRadioButtonId()) {
//                case R.id.rbPlayersKick:
//                    cmdCommand = "amx_kick " + playerName1;
//                    break;
//                case R.id.rbPlayersSlap:
//                    cmdCommand = "amx_slap " + playerName1;
//                    break;
//                case R.id.rbPlayersSlay:
//                    cmdCommand = "amx_slay " + playerName1;
//                    break;
//                case R.id.rbPlayersBan:
//                    cmdCommand = "amx_ban 10 " + playerName1 + " banned";
//                    break;
//                case R.id.rbPlayersGag:
//                    cmdCommand = "gag " + playerName1;
//                    break;
//                case R.id.rbMessageAllPlayers:
//                    cmdCommand = "amx_say " + edMessage.getText().toString();
//                    break;
//                case R.id.rbMessageAllAdmins:
//                    cmdCommand = "amx_chat " + edMessage.getText().toString();
//                    break;
//                case R.id.rbMessagePrivate:
//                    cmdCommand = "amx_psay " + playerName1 + " " + edMessage.getText().toString();
//                    break;
//                case R.id.rbMessageAllHudLeft:
//                    cmdCommand = "amx_tsay green " + edMessage.getText().toString();
//                    break;
//                case R.id.rbMessageAllHudCenter:
//                    cmdCommand = "amx_csay green " + edMessage.getText().toString();
//                    break;

                default:
                    Toast.makeText(context, "Select action", Toast.LENGTH_SHORT).show();
                    cmdCommand = "";
            }

            CmdRunConsole consoleCmd = new CmdRunConsole(context);
            consoleCmd.executeCmdConsole(cmdCommand);
        }
    }

    public void executeStatusCmdCommands(View view, int viewId) {
        CmdRunConsole cmdCommandStart = new CmdRunConsole(view.getContext());
        switch (viewId) {

            case R.id.btnStart:
                cmdCommandStart.cmdStartServer();
                break;
            case R.id.btnStop:
                cmdCommandStart.cmdStopServer();
                break;
            case R.id.btnRestart:
                cmdCommandStart.cmdRestartServer();
                break;
            case R.id.btnChangeMap:
                CmdRunConsole consoleCmd = new CmdRunConsole(context);
                consoleCmd.executeCmdConsole("changelevel cs_mansion");
                break;

            default:
                Toast.makeText(context, "Select action", Toast.LENGTH_SHORT).show();
        }


    }


}
