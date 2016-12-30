package com.example.op.fitnessdiary.GUI.Plan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.op.fitnessdiary.R;

import java.util.ArrayList;

public class Plan_CreatePlan extends AppCompatActivity {
    private EditText editTextNumDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_create_plan);

        editTextNumDay = (EditText) this.findViewById(R.id.editText_plan_numday);

        editTextNumDay.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,    int before, int count) {
                if(s.length() != 0) {
                    int numDay = Integer.valueOf(editTextNumDay.getText().toString());
                    ArrayList<DetailDay> list = getListDetailDay(numDay);

                    final ListView listView = (ListView) findViewById(R.id.listview_create_plan);
                    listView.setAdapter(new CustomListPlanAdapter(Plan_CreatePlan.this, list));
                }
            }
        });

        Button buttonSetPlan = (Button) this.findViewById(R.id.button_setplan);

        // Sét đặt sự kiện Click vào Button1.
        buttonSetPlan.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Plan_CreatePlan.this, "setPlan clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<DetailDay> getListDetailDay(int numDay) {
        ArrayList<DetailDay> list = new ArrayList<DetailDay>();
        for (int i = 0; i < numDay; i++)
        {
            DetailDay day = new DetailDay(i + 1);
            list.add(day);
        }

        return list;

    }
}
