package com.example.dell.monngonviet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 05/11/2017.
 */

public class AdapterDanhMuc  extends BaseAdapter {
    Context context;
    ArrayList<DanhMuc> list;

    public AdapterDanhMuc(Context context, ArrayList<DanhMuc> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.layout_danhmuc,null);
        TextView TENDANHSACH = (TextView) row.findViewById(R.id.TENDANHSACH);
        final DanhMuc danhMuc = list.get(i);
        TENDANHSACH.setText(danhMuc.TenDanhMuc);
        return  row;

    }
}

