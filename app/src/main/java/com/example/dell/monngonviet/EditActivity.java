package com.example.dell.monngonviet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by Administrator on 22/10/2017.
 */

public class EditActivity extends LikeActivity {
    ImageView imgEditAvatar;
    EditText edtEditName, edtEditAddress;
    Button btnSaveEdit, btnExitEdit, btnDel;
    player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        // Gọi phương thức ivitView và getData
        initView();
        getData();
    }
    // Khởi tạo initView
    private void initView() {
        imgEditAvatar = (ImageView) findViewById(R.id.imgEditAvatar);
        edtEditName = (EditText) findViewById(R.id.edtEditName);
        edtEditAddress = (EditText) findViewById(R.id.edtEditAddress);
        btnExitEdit = (Button) findViewById(R.id.btnExitEdit);
        btnSaveEdit = (Button) findViewById(R.id.btnEdit);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnSaveEdit.setOnClickListener(SaveEdit_Click);
        btnExitEdit.setOnClickListener(Exit_Edit);
        btnDel.setOnClickListener(Del_Click);
    }
    // Khơi tạo getData
    private void getData() {
        if (getIntent().getExtras() != null) {
            player = (player) getIntent().getSerializableExtra("EDIT");
            int a = player.getCode();
            imgEditAvatar.setImageResource(player.getAvatar());
            edtEditName.setText(player.getName());
            edtEditAddress.setText(player.getGioiThieu());

        }
    }

    View.OnClickListener SaveEdit_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(EditActivity.this, LikeActivity.class);
            int b = player.getCode();
            player person1 = new player(b, player.getAvatar(),
                    edtEditName.getText().toString(), edtEditAddress.getText().toString());
            intent.putExtra("EDIT", person1);
            setResult(200, intent);
            finish();
        }
    };
    View.OnClickListener Del_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(EditActivity.this, LikeActivity.class);
            intent.putExtra("DEL", player.getCode());
            setResult(300, intent);
            finish();
        }
    };
    View.OnClickListener Exit_Edit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
