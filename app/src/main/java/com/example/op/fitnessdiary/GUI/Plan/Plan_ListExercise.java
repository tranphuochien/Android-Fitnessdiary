package com.example.op.fitnessdiary.GUI.Plan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.op.fitnessdiary.ClassObject.ListExercise.Exercise;
import com.example.op.fitnessdiary.ClassObject.ListExercise.ListExercise;
import com.example.op.fitnessdiary.GUI.ViewHolderListExercise.ListVHExercise;
import com.example.op.fitnessdiary.GUI.ViewHolderListExercise.VHExercise;
import com.example.op.fitnessdiary.R;

import java.util.ArrayList;

public class Plan_ListExercise extends AppCompatActivity {
    private ListView listView;
    private Intent callerIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan__list_exercise);

        //Get intent call this activity
        callerIntent=getIntent();

        //Get all type exercises
        ArrayList<Exercise> list = this.getListExcercise();

        //Load listview
        listView = (ListView) findViewById(R.id.listview_plan);
        listView.setAdapter(new CustomListExerciseAdapter(this, list));

        //Catch event click on a list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Exercise exercise = (Exercise)listView.getItemAtPosition(position);
                //Toast.makeText(Plan_ListExercise.this, "Selected :" + " " + exercise.GetName(), Toast.LENGTH_SHORT).show();
                displayAlertDialog(exercise, callerIntent);
            }
        });
    }

    private ArrayList<Exercise> getListExcercise()
    {
        ListExercise list = new ListExercise();

        return list.getListExercise();
    }

    public void displayAlertDialog(Exercise ex, final Intent callerIntent) {
        LayoutInflater inflater = getLayoutInflater();

        //Choose a holder is corresponding with object ex
        ListVHExercise listVH = ListVHExercise.getInstance();
        final VHExercise holder  = listVH.ChooseVHExercise(ex.GetName());

        holder.fillObject(ex);
        View alertLayout =  holder.setPlan_findViewById(inflater);

        //Set data
        holder.setPlan_setData(this);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Set plan");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Set", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // code for matching password
                Exercise exercise = holder.setPlan_getExercise();

                String duration = String.valueOf(exercise.getDuration());
                String name =  exercise.GetName();

                /*
                Intent myIntent = new Intent(Plan_ListExercise.this, Plan_CreatePlan.class);
                Plan_ListExercise.this.startActivity(myIntent);
                finish();
                */
                Intent intent = new Intent();
                intent.putExtra("edittextvalue","value_here");
                setResult(RESULT_OK, intent);
                finish();

                //Toast.makeText(getBaseContext(), "duration: " + duration + " name: " + name, Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
