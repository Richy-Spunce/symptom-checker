package com.symptom_checker.team.symptom_checker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signupActivity extends AppCompatActivity {

    DatabaseHandler db_handler = new DatabaseHandler(this);
    Button registerRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        registerRecord = (Button) findViewById(R.id.btnRegister);
        registerRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }



    void register ()
    {
        final String firstname = ((EditText) findViewById(R.id.txtFirstname)).getText().toString();
        final String lastname = ((EditText) findViewById(R.id.txtLastname)).getText().toString();
        final String dob = ((EditText) findViewById(R.id.txtDOB)).getText().toString();
        final String email = ((EditText) findViewById(R.id.txtEmail)).getText().toString();
        final String password = ((EditText) findViewById(R.id.txtPassword)).getText().toString();
        final String nhsnum = ((EditText) findViewById(R.id.txtNHSNum)).getText().toString();
        
        LoginDetails new_record = new LoginDetails(1, firstname, lastname,
                dob, email, password, nhsnum);
        
        db_handler.addRecord(new_record);
        Log.d("Database:","Inserting new record." + firstname + lastname);
    }
}
