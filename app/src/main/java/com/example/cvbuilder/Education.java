package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Education extends AppCompatActivity {

    EditText etEduName, etEduProgram;
    Button btnSave, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        init();

        btnCancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
        btnSave.setOnClickListener((v)->{
            String eduName = etEduName.getText().toString().trim();
            String eduProgram = etEduProgram.getText().toString().trim();

            if (!validateField(eduName)) {
                etEduName.setError("Field is required");
                etEduName.requestFocus();
                return;
            }
            if (!validateField(eduProgram)) {
                etEduProgram.setError("Field is required");
                etEduProgram.requestFocus();
                return;
            }

            Intent i = new Intent();
            i.putExtra("education", eduName);
            i.putExtra("program", eduProgram);

            setResult(RESULT_OK, i);
            finish();
        });
    }
    private void init()
    {
        etEduName = findViewById(R.id.etEduName);
        etEduProgram = findViewById(R.id.etEduProgram);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }
    private boolean validateField(String field) {
        return !field.isEmpty();
    }
}