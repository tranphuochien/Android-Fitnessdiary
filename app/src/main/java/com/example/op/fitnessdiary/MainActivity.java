package com.example.op.fitnessdiary;

import android.widget.Button;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.op.fitnessdiary.album.Album_main;
import com.example.op.fitnessdiary.baseStats.baseStats_main;
import com.example.op.fitnessdiary.createEvent.CreateEvent_main;
import com.example.op.fitnessdiary.setting.Account_setting_main_fix;


public class MainActivity extends AppCompatActivity {

    private Button mySetting;
    private Button myBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}
