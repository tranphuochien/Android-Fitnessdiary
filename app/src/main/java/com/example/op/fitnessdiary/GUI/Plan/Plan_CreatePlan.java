package com.example.op.fitnessdiary.GUI.Plan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.op.fitnessdiary.GUI.ViewHolderListExercise.ListVHExercise;
import com.example.op.fitnessdiary.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Plan_CreatePlan extends AppCompatActivity {
    private EditText editTextNumDay;
    private static ListView listView;
    private static ArrayList<DetailDay> list;
    private static CustomListPlanAdapter listPlanAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_create_plan);
        Button buttonSetPlan = (Button) this.findViewById(R.id.button_setplan);

        // Sét đặt sự kiện Click vào Button1.
        buttonSetPlan.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Plan_CreatePlan.this, "setPlan clicked", Toast.LENGTH_SHORT).show();
            }
        });

        editTextNumDay = (EditText) this.findViewById(R.id.editText_plan_numday);

        listView = (ListView) findViewById(R.id.listview_create_plan);

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
                    list = getListDetailDay(numDay);
                    listPlanAdapter = new CustomListPlanAdapter(Plan_CreatePlan.this, list);
                    listView.setAdapter(listPlanAdapter );
                }
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ItemClicked item = adapter.getItemAtPosition(position);

                Intent intent = new Intent(Plan_CreatePlan.this,Plan_ListExercise.class);
                //based on item add info to intent
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String stredittext=data.getStringExtra("edittextvalue");
                Toast.makeText(getBaseContext(),stredittext, Toast.LENGTH_SHORT).show();
            }
        }
    }
    private ArrayList<DetailDay> getListDetailDay(int numDay) {
        ArrayList<DetailDay> list = new ArrayList<DetailDay>();


        for (int i = 0; i < numDay; i++)
        {
            DetailDay day = new DetailDay(i + 1, addDate(i));
            list.add(day);
        }

        return list;

    }

    //Add x day to a  current day
    //Input: x day want to add
    //Output: curdayDay + x day
    private String addDate(int x)
    {
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date
        String CurrentDate = mYear + "/" + mMonth + "/" + mDay;

        String dateInString = CurrentDate; // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        c = Calendar.getInstance();

        try {
            c.setTime(sdf.parse(dateInString));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        c.add(Calendar.DATE, x);//insert the number of days you want to be added to the current date
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date resultdate = new Date(c.getTimeInMillis());
        dateInString = sdf.format(resultdate);

        return dateInString;
    }
}
