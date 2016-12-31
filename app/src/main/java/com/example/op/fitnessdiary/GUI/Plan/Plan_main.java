package com.example.op.fitnessdiary.GUI.Plan;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.op.fitnessdiary.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;


public class Plan_main extends AppCompatActivity {
    private  Button createButton ;
    private  Button processButton;
    private LineChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_main);

        createButton = (Button) this.findViewById(R.id.button_plan_createplan);
        processButton  = (Button)this.findViewById(R.id.button_plan_processdetail);

        chart  = (LineChart) findViewById(R.id.chart);

        configChart();

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

    private void configChart()
    {
        List<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry(0, 10));
        entries.add(new Entry(1, 50));
        entries.add(new Entry(2, 80));
        entries.add(new Entry(3, 60));
        entries.add(new Entry(4, 100));

        LineDataSet dataSet = new LineDataSet(entries, "% completion"); // add entries to dataset
        dataSet.setColor(Color.RED);
        dataSet.setValueTextColor(Color.RED); // styling, ...

        YAxis yAxisLeft = chart.getAxisLeft();
        yAxisLeft.setAxisMaximum(100);

        YAxis yAxisRight = chart.getAxisRight();
        yAxisRight.setAxisMaximum(100);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}
