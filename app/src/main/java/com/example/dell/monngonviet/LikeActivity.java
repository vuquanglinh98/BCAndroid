package com.example.dell.monngonviet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by KA on 11/10/2017.
 */

public class LikeActivity extends MainActivity1 {
    ListView LVDS;
    PlayerAdapter adapter;
    ArrayList<player> listData;
    ImageView imgAddPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getData();
        initView();


    }
    private void initView() {
        adapter = new PlayerAdapter(listData, LikeActivity.this);
        LVDS= (ListView) findViewById(R.id.lvData);
        LVDS.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        imgAddPlayer= (ImageView) findViewById(R.id.imgAddPlayer);
        imgAddPlayer.setOnClickListener(Add_Click);
        LVDS.setOnItemLongClickListener(this);

    }

    View.OnClickListener Add_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent inte = new Intent(LikeActivity.this, AddpersonActivity.class);
            startActivityForResult(inte, 10);
        }
    };

    private void getData() {
        listData = new ArrayList<>();
        listData.add(new player(0, R.drawable.muco, "Mực Ống Xào Măng Trúc","Để khử mùi tanh của mực, bạn dùng ít rượu pha gừng đạp dập để rửa. Không thích mực, bạn có thể thay bằng tôm"));
        listData.add(new player(1, R.drawable.exhh, "Ếch Xào Hoa Hẹ","Để tăng hương vị cho món ăn, bạn có thẻ cho thêm 1 thìa cà phê dầu mè (vừng)"));
        listData.add(new player(2, R.drawable.excb, "Ếch Xào Cà Bát","Thịt ếch làm xong nên nấu ngay, nếu để lau ếch sẽ bị mất mùi và nhạt thịt"));
        listData.add(new player(3, R.drawable.dp, "Đậu Phụng Sốt Tứ Xuyên"," Để đậu không bị nát, bạn cho đậu vào đĩa, ráo bọt rán giòn và vừng lên"));
        listData.add(new player(4, R.drawable.dh, "Đậu Phụng Sốt Dưa Chua"," Những trái dừa tươi, vừa chín tới sẽ không quá cứng cũng không quá mềm, nhấn ngón tay vào vỏ dừa sẽ không bị lõm vào. Phần vỏ có nấm mốc, rỉ nước hay bị nứt là những dấu hiệu cho thấy tría dừa đã bị hư"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();

        switch (id) {
            case R.id.action_search:
                // Gọi màn hình AditionSportActivity
                break;
            case R.id.mnInfor:
                break;}
        return super.onOptionsItemSelected(item);
    }
    // onActivityRessult là hàm nhận giá trị truyền về từ các Activity khác thông qua request Code và ResultCode
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 10: // Kiểm tra nếu requestCode = 10 thì sẽ chạy hàm dưới
                if (data != null) {
                    // Lấy ra giá trị truyền về từ AddpersonActivity và gán vào đối tượng person
                    player player = (player) data.getSerializableExtra("ADD");
                    if (resultCode == 100) {
                        // gán thuộc tính code trong Person bằng số lượng của adapter + 1
                        player.setCode(adapter.getCount() + 1);
                        adapter.getListData().add(0, player);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(LikeActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(LikeActivity.this, "Có lỗi sảy ra, vui lòng thử lại", Toast.LENGTH_SHORT).show();
                break;
            case 20:
                if (data != null) {
                    // Lấy ra dữ liệu được truyền về từ EditActivity
                    player select = (player) data.getSerializableExtra("EDIT");
                    if (resultCode == 200) {
                        for (player item : adapter.getListData()) {
                            if (item.getCode() == select.getCode()) {
                                item.setName(select.getName());
                                item.setGioiThieu(select.getGioiThieu());
                                break;
                            }
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    } else if (resultCode == 300) {
                        int ID = data.getExtras().getInt("DEL");
                        int position = -1;
                        for (int i = 0; i < adapter.getCount(); i++) {
                            if (adapter.getItem(i).getCode() == ID) {
                                position = i;
                                break;
                            }
                        }
                        if (position < 0) {
                            Toast.makeText(LikeActivity.this, "Không xác định được vị trí", Toast.LENGTH_SHORT).show();
                        } else {
                            adapter.getListData().remove(position);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(LikeActivity.this, "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        }
    }

    // onItemLongClick là sự kiện khi nhấn giữ vào một item listview
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(LikeActivity.this, EditActivity.class);
        intent.putExtra("EDIT", adapter.getItem(position));
        startActivityForResult(intent, 20);
        return true;
    }

}
