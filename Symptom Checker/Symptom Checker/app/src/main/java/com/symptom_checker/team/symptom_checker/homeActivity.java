package com.symptom_checker.team.symptom_checker;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class homeActivity extends AppCompatActivity {

    Button goToEmergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String[] gender = {"Male", "Female", "Other"};
        String[] whoFor = {"Yourself", "On Behalf of Someone Else"};

        ArrayAdapter<String> genderArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, gender);
        ArrayAdapter<String> forArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, whoFor);

        Spinner spinnerGen = (Spinner) findViewById(R.id.spinGender);
        Spinner spinnerFor = (Spinner) findViewById(R.id.spinFor);

        spinnerGen.setAdapter(genderArrayAdapter);
        spinnerFor.setAdapter(forArrayAdapter);

        goToEmergency = (Button) findViewById(R.id.btnEmergency);
        goToEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:999"));
                startActivity(intent);
            }
        });
    }
}
