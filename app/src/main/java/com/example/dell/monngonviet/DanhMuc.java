package com.example.dell.monngonviet;

import java.io.Serializable;

/**
 * Created by KA on 11/6/2017.
 */

public class DanhMuc implements Serializable {
    public int MaDanhMuc;
    public String TenDanhMuc;

    public DanhMuc(int maDanhMuc, String tenDanhMuc) {
        MaDanhMuc = maDanhMuc;
        TenDanhMuc = tenDanhMuc;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        MaDanhMuc = maDanhMuc;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        TenDanhMuc = tenDanhMuc;
    }
}