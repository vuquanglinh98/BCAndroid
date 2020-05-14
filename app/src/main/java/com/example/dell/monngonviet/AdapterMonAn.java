package com.example.dell.monngonviet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 20/10/2017.
 */

public class AdapterMonAn extends BaseAdapter{
    Context context;
    ArrayList<MonAn>list;

    public AdapterMonAn(Context context, ArrayList<MonAn> list) {
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
        View row = inflater.inflate(R.layout.layout_monan,null);
        ImageView imgAnh = (ImageView) row.findViewById(R.id.imgAnh);
        TextView txtName = (TextView) row.findViewById(R.id.txtName);
        TextView txtGioiThieu = (TextView) row.findViewById(R.id.txtGioiThieu);

        final MonAn monAn = list.get(i);
        txtName.setText(monAn.TenMonAn);
        txtGioiThieu.setText(monAn.GioiThieu);
        Bitmap Anhnen = BitmapFactory.decodeByteArray(monAn.Anh, 0, monAn.Anh.length);
        imgAnh.setImageBitmap(Anhnen);
        return  row;

    }
}


