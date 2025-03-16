package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Experience extends AppCompatActivity {
    EditText etExpName, etExpTime;
    Button btnSave, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        init();

        btnCancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
        btnSave.setOnClickListener((v)->{
            String expName = etExpName.getText().toString().trim();
            String expTime = etExpTime.getText().toString().trim();

            if (!validateField(expName)) {
                etExpName.setError("Field is required");
                etExpName.requestFocus();
                return;
            }
            if (!validateField(expTime)) {
                etExpTime.setError("Field is required");
                etExpTime.requestFocus();
                return;
            }

            Intent i = new Intent();
            i.putExtra("experience", expName);
            i.putExtra("time", expTime);

            setResult(RESULT_OK, i);
            finish();
        });
    }
    private void init()
    {
        etExpName = findViewById(R.id.etExpName);
        etExpTime = findViewById(R.id.etExpTime);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }
    private boolean validateField(String field) {
        return !field.isEmpty();
    }
}