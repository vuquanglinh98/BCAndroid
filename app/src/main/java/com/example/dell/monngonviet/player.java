package com.example.dell.monngonviet;

import java.io.Serializable;

/**
 * Created by Administrator on 20/10/2017.
 */

public class player implements Serializable {
    int code;
    private int avatar;
    private String name;
    private  String GioiThieu;

    public player(int code, int avatar, String name, String gioiThieu) {
        this.code = code;
        this.avatar = avatar;
        this.name = name;
        GioiThieu = gioiThieu;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGioiThieu() {
        return GioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        GioiThieu = gioiThieu;
    }
}

