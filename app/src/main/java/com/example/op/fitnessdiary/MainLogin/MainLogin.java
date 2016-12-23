package com.example.op.fitnessdiary.MainLogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.R;

public class MainLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        ImageButton signinButton = (ImageButton) this.findViewById(R.id.signinButton);
        ImageButton gmailButton = (ImageButton) this.findViewById(R.id.googleButton);
        TextView tvForgotPassword = (TextView) this.findViewById(R.id.forgotPassTextView);
        TextView tvCreateAccount = (TextView) this.findViewById(R.id.createAccountTextView);

        //Catch event click on Sign in Button
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainLogin.this, "signin clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //Catch event click on Gmail Button
        gmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainLogin.this, "gmail clicked", Toast.LENGTH_SHORT).show();
            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainLogin.this, ForgotPassword.class);
                MainLogin.this.startActivity(myIntent);
                finish();
            }
        });

        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainLogin.this, CreateAccount.class);
                MainLogin.this.startActivity(myIntent);
                finish();
            }
        });
    }
}
