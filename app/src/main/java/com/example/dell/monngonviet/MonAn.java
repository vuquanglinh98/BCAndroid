package com.example.dell.monngonviet;

import java.io.Serializable;

/**
 * Created by Administrator on 20/10/2017.
 */

public class MonAn extends DanhMuc implements Serializable {
    public int MaMonAn;
    public String TenMonAn;
    public String GioiThieu;
    public byte[] Anh;

    public MonAn(int maDanhMuc, String tenDanhMuc, int maMonAn, String tenMonAn, String gioiThieu, byte[] anh) {
        super(maDanhMuc, tenDanhMuc);
        MaMonAn = maMonAn;
        TenMonAn = tenMonAn;
        GioiThieu = gioiThieu;
        Anh = anh;
    }

    public int getMaMonAn() {
        return MaMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        MaMonAn = maMonAn;
    }

    public String getTenMonAn() {
        return TenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        TenMonAn = tenMonAn;
    }

    public String getGioiThieu() {
        return GioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        GioiThieu = gioiThieu;
    }

    public byte[] getAnh() {
        return Anh;
    }

    public void setAnh(byte[] anh) {
        Anh = anh;
    }
}

