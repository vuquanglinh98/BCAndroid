package com.example.dell.monngonviet;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity2 extends MainActivity {
    final String DATABASE_NAME = "MonNgonVietNamS.sqlite";
    SQLiteDatabase database;
    public ListView Lv;
    ArrayList<MonAn> list;
    AdapterMonAn adapter;
    Intent intent;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = getIntent();
        id = intent.getStringExtra("id");
        addControls();
        readData();
        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("Name", list.get(i).getClass().toString());
                Toast.makeText(getApplicationContext(),list.get(i).getTenMonAn()+"",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
    private void addControls() {
        Lv = (ListView) findViewById(R.id.LvDanhSach);
        list = new ArrayList<>();
        adapter = new AdapterMonAn(this, list);
        Lv.setAdapter(adapter);
    }

    private void readData(){
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT MonAn.MaDanhMuc,TenDanhMuc,MaMonAn,TenMonAn,GioiThieu,Anh FROM MonAn,DanhMuc Where DanhMuc.MaDanhMuc=MonAn.MaDanhMuc and MonAn.MaDanhMuc="+id,null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int MaDanhSach= cursor.getInt(0);
            String TenDanhMuc = cursor.getString(1);
            int MaMonAn= cursor.getInt(2);
            String TenMonAn = cursor.getString(3);
            String GioiThieu = cursor.getString(4);
            byte[] Anh = cursor.getBlob(5);
            list.add(new MonAn(MaDanhSach,TenDanhMuc,MaMonAn,TenMonAn,GioiThieu,Anh ));
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
}