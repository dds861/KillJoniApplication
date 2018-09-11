package com.chatserver.dd.chat.Cmd.View;

/**
 * Created by dd on 03.05.2017.
 */

public class UsersCmd {
    //Chat Variables
    private String eventTime;
    private String message;
    private String lastName;

    //Chat contructer
    public UsersCmd(String eventTime, String message, String lastName) {
        this.eventTime      = eventTime;
        this.message        = message;
        this.lastName       = lastName;
    }

    //Getters and Setters

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



}
