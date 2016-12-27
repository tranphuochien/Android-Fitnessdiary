package com.example.op.fitnessdiary.MainLogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.op.fitnessdiary.R;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //Init spinner
        String array_spinner[];
        array_spinner=new String[2];
        array_spinner[0]="Male";
        array_spinner[1]="Female";
        Spinner s = (Spinner) findViewById(R.id.spinner_signup_sex);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);

        Button createButton = (Button) this.findViewById(R.id.button_createAccount);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CreateAccount.this, MainLogin.class);
                CreateAccount.this.startActivity(myIntent);
                finish();
            }
        });
    }
}
