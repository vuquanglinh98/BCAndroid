package com.example.dell.monngonviet;

import android.content.Context;
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

public class PlayerAdapter extends BaseAdapter {
    ArrayList<player> listData;
    LayoutInflater inflater;
    ImageView imgAvatar;
    TextView txtName, txtAddress, txtPhone;

    public PlayerAdapter(ArrayList<player> listData, Context context) {
        this.listData = listData;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayList<player> getListData() {
        return listData;
    }

    public void setListData(ArrayList<player> listData) {
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public player getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.layout_monan, null);

        imgAvatar = (ImageView) convertView.findViewById(R.id.imgAnh);
        txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtAddress = (TextView) convertView.findViewById(R.id.txtGioiThieu);
// gán dữ liệu vào từng đối tượng trong item_listview.xml
        player ps = getItem(position);
        imgAvatar.setImageResource(ps.getAvatar());
        txtName.setText(ps.getName().toString());
        txtAddress.setText(ps.getGioiThieu().toString());
        return convertView;
    }
}
