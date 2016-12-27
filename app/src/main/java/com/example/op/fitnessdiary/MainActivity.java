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

import com.example.op.fitnessdiary.Celebrate.Celebrate_main;
import com.example.op.fitnessdiary.MainLogin.MainLogin;
import com.example.op.fitnessdiary.Plan.Plan_main;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void onClickEvents(View v){
        Intent myIntent = new Intent(this, CreateEvent_main.class);
        this.startActivity(myIntent);

    }

    public void onClickPlan(View v){
        Intent myIntent = new Intent(this, Plan_main.class);
        this.startActivity(myIntent);
    }

    public void onClickLogin(View v){
        Intent myIntent = new Intent(this, MainLogin.class);
        this.startActivity(myIntent);
    }

    public void onClickCelebrate(View v){
        Intent myIntent = new Intent(this, Celebrate_main.class);
        this.startActivity(myIntent);
    }
}
