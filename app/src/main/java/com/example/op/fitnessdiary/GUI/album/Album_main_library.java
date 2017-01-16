package com.example.op.fitnessdiary.GUI.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.op.fitnessdiary.R;

public class Album_main_library extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_main_library);
    }



    public void onClickPhotos(View v){
        Intent myIntent = new Intent(this, Album_main.class);
        this.startActivity(myIntent);
    }

    public void onClickVideos(View v){
        Intent myIntent = new Intent(this, Album_main_videos.class);
        this.startActivity(myIntent);
    }

}
