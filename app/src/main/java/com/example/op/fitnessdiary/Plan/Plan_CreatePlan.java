package com.example.op.fitnessdiary.Plan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.op.fitnessdiary.Celebrate.Celebrate_main;
import com.example.op.fitnessdiary.ListExercise.ListExercise;
import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.R;

public class Plan_CreatePlan extends AppCompatActivity {
    private Button buttonChooseExercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_create_plan);


        buttonChooseExercise = (Button) this.findViewById(R.id.button_plan_chooseExercise);
        buttonChooseExercise.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Plan_CreatePlan.this, Plan_ListExercise.class);

                Plan_CreatePlan.this.startActivity(myIntent);
            }
        });
    }
}
