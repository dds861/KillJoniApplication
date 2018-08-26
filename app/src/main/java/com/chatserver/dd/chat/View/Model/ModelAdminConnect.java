package com.chatserver.dd.chat.View.Model;

import com.google.gson.annotations.SerializedName;

public class ModelAdminConnect {

    /**
     * 0 : 210644
     * 1 : 2018-08-06 19:20:46
     * 2 : 2.134.252.210
     * 3 : PARIS
     * playerId : 210644
     * eventTime : 2018-08-06 19:20:46
     * ipAddress : 2.134.252.210
     * lastName : PARIS
     */

    @SerializedName("0")
    private String _$0;
    @SerializedName("1")
    private String _$1;
    @SerializedName("2")
    private String _$2;
    @SerializedName("3")
    private String _$3;
    private String playerId;
    private String eventTime;
    private String ipAddress;
    private String lastName;

    public String get_$0() {
        return _$0;
    }

    public void set_$0(String _$0) {
        this._$0 = _$0;
    }

    public String get_$1() {
        return _$1;
    }

    public void set_$1(String _$1) {
        this._$1 = _$1;
    }

    public String get_$2() {
        return _$2;
    }

    public void set_$2(String _$2) {
        this._$2 = _$2;
    }

    public String get_$3() {
        return _$3;
    }

    public void set_$3(String _$3) {
        this._$3 = _$3;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
