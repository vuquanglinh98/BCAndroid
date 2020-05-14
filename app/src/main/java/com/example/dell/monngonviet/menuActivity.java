package com.example.dell.monngonviet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by KA on 10/15/2017.
 */

public class menuActivity extends MainActivity2 {
    ListView LVDS;
    PlayerAdapter1 adapter;
    ArrayList<player1> arr_player1 = new ArrayList<player1>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniArr();
        LVDS = (ListView) findViewById(R.id.LvDanhSach);
        adapter = new PlayerAdapter1(menuActivity.this, arr_player1);
        LVDS.setAdapter(adapter);
        LVDS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(menuActivity.this, DgActivity.class);
                startActivity(intent);
            }
        });
    }

    public void iniArr() {
        arr_player1.add(new player1("Ứng dụng", "Món Ngon Việt"));
        arr_player1.add(new player1("Phiên bản", "Version 1.0"));
        arr_player1.add(new player1("Nhà sản xuất", "Emotion Infinity"));
        arr_player1.add(new player1("Copyright","Copyright 2015 Emotion Infinity. All rights reserved."));
        arr_player1.add(new player1("Giới thiệu bạn bè", "Giới thiệu với bạn bè về ứng dụng này"));
        arr_player1.add(new player1("Đánh giá", "Đánh giá về ứng dụng mà bạn thích nó"));
        arr_player1.add(new player1("Viết nhận xét", "Hãy gửi những nhận xét về ứng dụng cho chúng tôi"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_search:
                // Gọi màn hình AditionSportActivity
                break;
            case R.id.mnInfor:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
