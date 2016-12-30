package com.example.op.fitnessdiary.GUI.MainLogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.op.fitnessdiary.ClassObject.Account;
import com.example.op.fitnessdiary.DAO.DBAccountHelper;
import com.example.op.fitnessdiary.GUI.Celebrate.Celebrate_main;
import com.example.op.fitnessdiary.GlobalInfo;
import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.Processor.AccountProcessor;
import com.example.op.fitnessdiary.R;

import java.util.ArrayList;

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

        final Button createButton = (Button) this.findViewById(R.id.button_createAccount);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent myIntent = new Intent(CreateAccount.this, MainLogin.class);
                //CreateAccount.this.startActivity(myIntent);
                //finish();
                if (createNewAccount())
                {
                    Toast.makeText(CreateAccount.this, "Insert successfull", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(CreateAccount.this, MainActivity.class);
                    CreateAccount.this.startActivity(myIntent);
                    finish();
                }
                else
                {
                    Toast.makeText(CreateAccount.this, "FAIL", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button testButton = (Button) this.findViewById(R.id.button_test_insert);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBAccountHelper db = new DBAccountHelper(CreateAccount.this);
                String query = "SELECT * FROM Account";
                ArrayList<Account> list = new ArrayList<Account>();
                list = (ArrayList<Account>) db.getListAccount(query);
                String buffer = "Nickname: " + list.get(2).getNickname()
                        + "DOB: " +  list.get(2).getDOB() +
                        "Email: " +  list.get(2).getEmail();

                        Toast.makeText(CreateAccount.this, buffer, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean createNewAccount()
    {
        String nickname = ((EditText)findViewById(R.id.editText_signup_username)).getText().toString();
        String email = ((EditText)findViewById(R.id.editText_signup_email)).getText().toString();
        String dob = ((EditText)findViewById(R.id.editText_signup_dob)).getText().toString();
        String password = ((EditText)findViewById(R.id.editText_signup_password)).getText().toString();
        String gender = ((Spinner)findViewById(R.id.spinner_signup_sex)).getSelectedItem().toString();

        Account account = new Account(nickname, email, dob, gender,password);
        AccountProcessor pc = AccountProcessor.getInstance();

        if ( pc.insertAccount(account, CreateAccount.this))
        {
            ((EditText)findViewById(R.id.editText_signup_username)).setText("");
            ((EditText)findViewById(R.id.editText_signup_email)).setText("");
            ((EditText)findViewById(R.id.editText_signup_dob)).setText("");
            ((EditText)findViewById(R.id.editText_signup_password)).setText("");
            ((EditText)findViewById(R.id.editText_signup_height)).setText("");
            ((EditText)findViewById(R.id.editText_signup_weight)).setText("");

            ((GlobalInfo) GlobalInfo.getInstance()).curNickname = account.getNickname();
            return true;
        }
        return false;
    }
}
