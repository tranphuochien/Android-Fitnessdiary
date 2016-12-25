package com.example.op.fitnessdiary.Plan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.op.fitnessdiary.ListExercise.Dancing;
import com.example.op.fitnessdiary.ListExercise.Exercise;
import com.example.op.fitnessdiary.ListExercise.ListExercise;
import com.example.op.fitnessdiary.R;

import java.util.ArrayList;

public class Plan_ListExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan__list_exercise);

        ArrayList<Exercise> list = this.getListExcercise();
        final ListView listView = (ListView) findViewById(R.id.listview_plan);
        listView.setAdapter(new CustomListAdapter(this, list));

    }

    private ArrayList<Exercise> getListExcercise()
    {
        ListExercise list = new ListExercise();

        return list.getListExercise();
    }
}
