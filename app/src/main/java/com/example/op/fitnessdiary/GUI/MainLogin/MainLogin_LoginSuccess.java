package com.example.op.fitnessdiary.GUI.MainLogin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.op.fitnessdiary.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainLogin_LoginSuccess extends AppCompatActivity implements  GoogleApiClient.OnConnectionFailedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_login_success);

    }
    public void onClickSignout(View v){
        Intent myIntent = new Intent(this, MainLogin.class);
        this.startActivity(myIntent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
