package com.example.op.fitnessdiary.GUI.MainLogin;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.op.fitnessdiary.ClassObject.Account;
import com.example.op.fitnessdiary.DAO.DBAccountHelper;
import com.example.op.fitnessdiary.GUI.setting.Account_setting_main_fix;
import com.example.op.fitnessdiary.GlobalInfo;
import com.example.op.fitnessdiary.MainActivity;
import com.example.op.fitnessdiary.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.util.ArrayList;

public class MainLogin extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;

    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;

    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        ImageButton signinButton = (ImageButton) this.findViewById(R.id.signinButton);
        ImageButton gmailButton = (ImageButton) this.findViewById(R.id.googleButton);
        TextView tvForgotPassword = (TextView) this.findViewById(R.id.forgotPassTextView);
        TextView tvCreateAccount = (TextView) this.findViewById(R.id.createAccountTextView);
        username = (EditText)this.findViewById(R.id.usernameEt);
        password = (EditText)this.findViewById(R.id.etpassword);

        // [START configure_signin]
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // [END configure_signin]

        // [START build_client]
        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        //Catch event click on Sign in Button
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainLogin.this, "signin clicked", Toast.LENGTH_SHORT).show();
                signInCommom();
            }
        });

        //Catch event click on Gmail Button
        gmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });



        //----------Sign out button---------------
        Button signout = (Button) this.findViewById(R.id.button_test_quit);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
        //--------------------------------------




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

    private void signInCommom() {
        String sUsername =username.getText().toString();
        String sPassword = password.getText().toString();

        DBAccountHelper db = new DBAccountHelper(MainLogin.this);
        String query = "SELECT * FROM Account WHERE nickname = '" + sUsername + "'";
        Account acc = null;
        acc = (Account) db.getAccount(query);

        if (acc.getPassword().equals(sPassword))
        {
            Toast.makeText(MainLogin.this, "Hi " + acc.getNickname(), Toast.LENGTH_SHORT).show();
            ((GlobalInfo) GlobalInfo.getInstance()).curNickname = acc.getNickname();


            Intent myIntent = new Intent(this, MainActivity.class);
            this.startActivity(myIntent);
            finish();
        }
        else{
            Toast.makeText(MainLogin.this, "Username or Password wrong", Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }

    }

    public void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d(TAG, "Got cached sign-in");
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    hideProgressDialog();
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }


    // [START onActivityResult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    // [END onActivityResult]

    // [START handleSignInResult]
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            Toast.makeText(MainLogin.this, getString(R.string.signed_in_fmt, acct.getDisplayName()), Toast.LENGTH_SHORT).show();

            updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false);
        }
    }
    // [END handleSignInResult]

    // [START signIn]
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // [END signIn]

    // [START signOut]
    public void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]
                        updateUI(false);
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END signOut]

    // [START revokeAccess]
    private void revokeAccess() {
        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]
                        updateUI(false);
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END revokeAccess]

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    private void updateUI(boolean signedIn) {
        if (signedIn) {
           // listEx_findViewById(R.id.sign_in_button).setVisibility(View.GONE);
            //listEx_findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
            //Intent myIntent=new Intent(MainLogin.this, MainLogin_LoginSuccess.class);
            //myIntent.putExtra("EXTRA_INFO_ACCOUNT", mGoogleApiClient);
            //startActivity(myIntent);
        } else {
            Toast.makeText(MainLogin.this,R.string.signed_out, Toast.LENGTH_SHORT).show();

            //listEx_findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
            //listEx_findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
        }
    }
}

