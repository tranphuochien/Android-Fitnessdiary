package com.example.op.fitnessdiary.GUI.Plan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.op.fitnessdiary.R;

public class Plan_listitem_detailday extends AppCompatActivity {
    private Button buttonChooseEx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_listitem_detailday);

        buttonChooseEx = (Button) this.findViewById(R.id.button_createplan_chooseExercise);


        buttonChooseEx.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Plan_listitem_detailday.this, Plan_ListExercise.class);

                // Yêu cầu chạy Example1Activity.
                Plan_listitem_detailday.this.startActivity(myIntent);
            }
        });
    }
}
