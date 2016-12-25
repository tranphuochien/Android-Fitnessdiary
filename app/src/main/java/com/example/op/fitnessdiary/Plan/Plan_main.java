package com.example.op.fitnessdiary.Plan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.MainLogin.MainLogin;
import com.example.op.fitnessdiary.R;

public class Plan_main extends AppCompatActivity {
    private  Button createButton ;
    private  Button processButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_main);

        createButton = (Button) this.findViewById(R.id.button_plan_createplan);
        processButton  = (Button)this.findViewById(R.id.button_plan_processdetail);

        createButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Plan_main.this, Plan_CreatePlan.class);
                Plan_main.this.startActivity(myIntent);
            }
        });

        processButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Plan_main.this, Plan_ProcessDetail.class);
                Plan_main.this.startActivity(myIntent);
            }
        });

    }
}
