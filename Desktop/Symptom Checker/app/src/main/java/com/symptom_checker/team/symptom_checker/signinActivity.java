package com.symptom_checker.team.symptom_checker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signinActivity extends AppCompatActivity {

    Button goToSignUp;
    Button goToHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        goToSignUp = (Button) findViewById(R.id.btnSignup);
        goToHomepage = (Button) findViewById(R.id.btnSignIn);

        goToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signinActivity.this, signupActivity.class);
                startActivity(intent);
            }
        });

        goToHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(signinActivity.this, homeActivity.class);
                    startActivity(intent);
            }
        });
    }

    boolean checkLoginCredentials()
    {
        String username = ((EditText) findViewById(R.id.txtUsername)).getText().toString();
        String password = ((EditText) findViewById(R.id.txtPassword)).getText().toString();

        // ...

        return false;
    }
}
