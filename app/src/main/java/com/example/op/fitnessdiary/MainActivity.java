package com.example.op.fitnessdiary;

<<<<<<< HEAD
import android.widget.Button;

=======
>>>>>>> 7c7cefe53334cdb083c26efcb5d1090889d5936a
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.op.fitnessdiary.album.Album_main;
import com.example.op.fitnessdiary.baseStats.baseStats_main;
import com.example.op.fitnessdiary.createEvent.CreateEvent_main;
import com.example.op.fitnessdiary.setting.Account_setting_main_fix;

import com.example.op.fitnessdiary.Celebrate.Celebrate_main;
import com.example.op.fitnessdiary.MainLogin.MainLogin;
import com.example.op.fitnessdiary.Plan.Plan_main;


public class MainActivity extends AppCompatActivity {

    private Button mySetting;
    private Button myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        this.mySetting = (Button) this.findViewById(R.id.test_intent_to_setting);
        this.myBase = (Button) this.findViewById(R.id.test_intent_to_baseStats);
    }

    public void onClickSetting(View v){
        Intent myIntent = new Intent(this, Account_setting_main_fix.class);
        this.startActivity(myIntent);
    }

    public void onClickBaseStats(View v){
        Intent myIntent = new Intent(this, baseStats_main.class);
        this.startActivity(myIntent);
    }

    public void onClickAlbum(View v){
        Intent myIntent = new Intent(this, Album_main.class);
        this.startActivity(myIntent);
    }

    public void onClickEvent(View v){
        Intent myIntent = new Intent(this, CreateEvent_main.class);
        this.startActivity(myIntent);
=======


        // Lấy ra button theo ID
        Button button1 = (Button) this.findViewById(R.id.button_signin);

        // Sét đặt sự kiện Click vào Button1.
        button1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Tạo một Intent:
                // (Mang nội dung sẽ gửi tới Example1Activity).
                Intent myIntent = new Intent(MainActivity.this, MainLogin.class);

                // Yêu cầu chạy Example1Activity.
                MainActivity.this.startActivity(myIntent);
            }
        });

        // Lấy ra button theo ID
        Button button2 = (Button) this.findViewById(R.id.button_celebrate);

        // Sét đặt sự kiện Click vào Button1.
        button2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Tạo một Intent:
                // (Mang nội dung sẽ gửi tới Example1Activity).
                Intent myIntent = new Intent(MainActivity.this, Celebrate_main.class);

                // Yêu cầu chạy Example1Activity.
                MainActivity.this.startActivity(myIntent);
            }
        });

        // Lấy ra button theo ID
        Button button3 = (Button) this.findViewById(R.id.button_plan);

        // Sét đặt sự kiện Click vào Button1.
        button3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Tạo một Intent:
                // (Mang nội dung sẽ gửi tới Example1Activity).
                Intent myIntent = new Intent(MainActivity.this, Plan_main.class);

                // Yêu cầu chạy Example1Activity.
                MainActivity.this.startActivity(myIntent);
            }
        });
>>>>>>> 7c7cefe53334cdb083c26efcb5d1090889d5936a
    }
}
