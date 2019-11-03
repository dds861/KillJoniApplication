package com.chatserver.dd.chat.Cmd.Presenter;

import com.chatserver.dd.chat.Cmd.Model.IModelCmd;
import com.chatserver.dd.chat.Cmd.View.IViewCmd;
import com.chatserver.dd.chat.Cmd.View.ViewConsoleCmd;
import com.chatserver.dd.chat.Cmd.View.ViewStatusPlayers;

public class PresenterCmd implements IPresenterCmd, IModelCmd.OnFinishedListener, IModelCmd.OnFinishedListenerCmd {


    IViewCmd iViewCmd;
    IModelCmd iModelCmd;

    public PresenterCmd(IViewCmd iViewCmd, IModelCmd iModelCmd) {
        this.iViewCmd = iViewCmd;
        this.iModelCmd = iModelCmd;
    }

    @Override
    public void requestDataFromServer() {
        iViewCmd.showProgressBar();
        iModelCmd.getPlayersList(this);
    }

    @Override
    public void onExecuteCmd(String cmdCommand) {
        iModelCmd.onExecuteCmd(this, cmdCommand);
    }

    @Override
    public void onRefreshButtonClick() {
        if (iViewCmd != null) {

        }
        iModelCmd.getPlayersList(this);


    }

    //replace cmd Command
    @Override
    public void onSetCmdToEditText(String playerName) {

        //String to Array String
        String textInEdittext = iViewCmd.getEdittext();
        String[] ary = textInEdittext.split(" ");
        ary[0] = playerName;

        //array to String
        StringBuilder builder = new StringBuilder();
        for (String s : ary) {
            builder.append(s + " ");
        }
        String str = builder.toString();

        //set string to Edittext
        iViewCmd.setEdittext(str);
    }

    //replace playerName
    @Override
    public void onSetNameToEditText(String playerName) {
        String textInEdittext = iViewCmd.getEdittext();
        String[] ary = textInEdittext.split(" ");
        iViewCmd.setEdittext(ary[0] + " " + playerName);

    }


    @Override
    public void onFinishedPlayers(ViewStatusPlayers viewStatusPlayers) {

        iViewCmd.setDataToRecyclerView(viewStatusPlayers);

        iViewCmd.hideProgressBar();
        if (viewStatusPlayers.getData().getP().size() > 0) {
            iViewCmd.listIsNotEmpty();
        } else {
            iViewCmd.listIsEmpty();
        }
    }

    @Override
    public void onFailurePlayers(Throwable t) {
        iViewCmd.onResponseFailure(t);
    }

    @Override
    public void onFinishedCmd(ViewConsoleCmd viewConsoleCmd) {
        if (viewConsoleCmd != null) {
            iViewCmd.showToast(viewConsoleCmd.getStatus());
        }
    }

    @Override
    public void onFailureCmd(Throwable t) {
        iViewCmd.onResponseFailure(t);
    }


}
