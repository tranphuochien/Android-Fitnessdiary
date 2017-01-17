package com.example.op.fitnessdiary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.op.fitnessdiary.GUI.Celebrate.Celebrate_main;
import com.example.op.fitnessdiary.GUI.MainLogin.MainLogin;
import com.example.op.fitnessdiary.GUI.Plan.Plan_main;
import com.example.op.fitnessdiary.GUI.album.Album_main_library;
import com.example.op.fitnessdiary.GUI.baseStats.baseStats_main;
import com.example.op.fitnessdiary.GUI.createEvent.CreateEvent_main;
import com.example.op.fitnessdiary.GUI.setting.Account_setting_main_fix;


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
        Intent myIntent = new Intent(this, Album_main_library.class);
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
