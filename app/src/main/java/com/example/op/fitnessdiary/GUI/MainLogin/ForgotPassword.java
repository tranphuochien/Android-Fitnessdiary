package com.example.op.fitnessdiary.GUI.MainLogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.op.fitnessdiary.R;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Button recoreryButton = (Button) this.findViewById(R.id.button_recorery);
        recoreryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ForgotPassword.this, MainLogin.class);
                ForgotPassword.this.startActivity(myIntent);
                finish();
            }
        });
    }
}
