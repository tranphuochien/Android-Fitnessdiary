package com.example.op.fitnessdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.op.fitnessdiary.Celebrate.Celebrate_main;
import com.example.op.fitnessdiary.MainLogin.MainLogin;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    }
}
