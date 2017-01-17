package com.example.op.fitnessdiary;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Entry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp1=this.getSharedPreferences("Login", 0);

        String unm=sp1.getString("username", null);
        String pass = sp1.getString("password", null);

        if (unm.equals("") && pass.equals(""))
        {
            setContentView(R.layout.activity_main_login);
        }
        else
        {
            setContentView(R.layout.activity_main);
        }

    }
}
