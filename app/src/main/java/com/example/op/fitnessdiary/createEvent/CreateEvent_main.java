package com.example.op.fitnessdiary.createEvent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.R;

public class CreateEvent_main extends AppCompatActivity {

    private ImageView userAvatar;
    private TextView userStt;
    private Button takingPts;
    private Button live;
    private Button album;
    private Button event;
    private Button checkIn;
    private Button setTime;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_main);

        this.userAvatar = (ImageView) this.findViewById(R.id.CreateEvent_avatar);
        this.userStt = (TextView) this.findViewById(R.id.CreateEvent_statusText);
        this.takingPts = (Button) this.findViewById(R.id.CreateEvent_photoBtn);
        this.live = (Button) this.findViewById(R.id.CreateEvent_liveStreamBtn);
        this.album = (Button) this.findViewById(R.id.CreateEvent_albumBtn);
        this.event = (Button) this.findViewById(R.id.CreateEvent_chooseEventBtn);
        this.checkIn = (Button) this.findViewById(R.id.CreateEvent_checkinBtn);
        this.setTime = (Button) this.findViewById(R.id.CreateEvent_setTimeBtn);
        this.start = (Button) this.findViewById(R.id.CreateEvent_startBtn);

        this.userAvatar.setImageResource(R.mipmap.ic_launcher);

        this.start.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){

                Toast.makeText(CreateEvent_main.this, "Bat dau su kien", Toast.LENGTH_SHORT).show();
                // xu ly start event o day
            }
        });
    }

    public void onClickCancel(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
        finish();
    }
}
