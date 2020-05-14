package com.example.dell.monngonviet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by KA on 10/13/2017.
 */

public class mhc extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_a);
        Thread bamgio=new Thread(){
            public void run()
            {
                try {
                    sleep(4000);
                } catch (Exception e) {

                }
                finally
                {
                    Intent intent= new Intent(mhc.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        bamgio.start();
    }
    //sau khi chuyển sang màn hình chính, kết thúc màn hình chào
    protected void onPause(){
        super.onPause();
        finish();
    }

}
