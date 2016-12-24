package com.example.op.fitnessdiary.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.R;

public class Account_setting_main_fix extends AppCompatActivity {
    private ImageView accountImage;
    private Button saveBtn;
    private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting_main_fix);

        this.accountImage = (ImageView) this.findViewById(R.id.Account_image);
        this.saveBtn = (Button) this.findViewById(R.id.Account_save);
        this.cancelBtn = (Button) this.findViewById(R.id.Account_cancel);


        this.accountImage.setImageResource(R.mipmap.avatar_test);

        this.saveBtn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

                // xu ly tam thoi
                Toast.makeText(Account_setting_main_fix.this, "Ban da luu thong tin thanh cong", Toast.LENGTH_SHORT).show();
                // xu ly save o day
            }
        });
    }

    public void onClickCancel(View v){
        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
        finish();
        // xu ly cancel o day
    }
}
