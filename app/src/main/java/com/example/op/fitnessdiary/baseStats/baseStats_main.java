package com.example.op.fitnessdiary.baseStats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.op.fitnessdiary.R;

public class baseStats_main extends AppCompatActivity {

    private Button saveBtn;
    private Button backBtn;
    private EditText height;
    private EditText weight;
    private TextView caloIn;
    private TextView caloOut;
    private TextView water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_stats_main);

        this.saveBtn = (Button) this.findViewById(R.id.BaseStats_saveBtn);
        this.backBtn = (Button) this.findViewById(R.id.BaseStats_backBtn);
        this.height = (EditText) this.findViewById(R.id.BaseStats_heightText);
        this.weight = (EditText) this.findViewById(R.id.BaseStats_weightText);
        this.caloIn = (TextView) this.findViewById(R.id.BaseStats_incomeCaloText);
        this.caloOut = (TextView) this.findViewById(R.id.BaseStats_outcomeCaloText);
        this.water = (TextView) this.findViewById(R.id.BaseStats_waterText);

        this.saveBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                // xu ly tam
                Toast.makeText(baseStats_main.this, "ban da luu thong tin thanh cong", Toast.LENGTH_SHORT).show();


                // xu ly save o day
            }
        });

        this.backBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                // xu ly back o day
            }
        });
    }
}
