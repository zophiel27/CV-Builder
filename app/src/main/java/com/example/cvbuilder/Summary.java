package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Summary extends AppCompatActivity {

    EditText etSummary;
    Button btnSave, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        init();

        btnCancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
        btnSave.setOnClickListener((v)->{
            String summary = etSummary.getText().toString().trim();

            if (!validateField(summary)) {
                // If validation fails, do nothing (user sees the error)
                etSummary.setError("Field is required");
                etSummary.requestFocus();
                return;
            }

            Intent i = new Intent();
            i.putExtra("summary", summary);

            setResult(RESULT_OK, i);
            finish();
        });
    }
    private void init()
    {
        etSummary = findViewById(R.id.etSummary);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }
    private boolean validateField(String field) {
        boolean isValid = true;
        if (field.isEmpty()) {
            isValid = false;
        }
        return isValid;
    }
}