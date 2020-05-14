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
 * Created by Administrator on 05/11/2017.
 */

public class AdapterCTMonAn extends BaseAdapter {
    Context context;
    ArrayList<ChiTietMonAn> list;

    public AdapterCTMonAn(Context context, ArrayList<ChiTietMonAn> list) {
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
        View row = inflater.inflate(R.layout.layout_ctmonan,null);
        ImageView Anh = (ImageView) row.findViewById(R.id.Anh);
        TextView TenMonAn = (TextView) row.findViewById(R.id.TenMonAn);
        TextView TomTat = (TextView) row.findViewById(R.id.TomTat);
        TextView NguyenLieu = (TextView) row.findViewById(R.id.NguyenLieu);
        TextView CachLam = (TextView) row.findViewById(R.id.CachLam);

        final ChiTietMonAn chiTietMonAn = list.get(i);
        TenMonAn.setText(chiTietMonAn.TenMonAn);
        TomTat.setText(chiTietMonAn.TomTat);
        NguyenLieu.setText(chiTietMonAn.NguyenLieu);
        CachLam.setText(chiTietMonAn.CachLam);
        Bitmap AnhNEN = BitmapFactory.decodeByteArray(chiTietMonAn.AnhMA, 0, chiTietMonAn.AnhMA.length);
        Anh.setImageBitmap(AnhNEN);
        return  row;

    }
}

