package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class References extends AppCompatActivity {
    EditText etRef;
    Button btnSave, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        init();

        btnCancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
        btnSave.setOnClickListener((v)->{
            String ref = etRef.getText().toString().trim();

            if (!validateField(ref)) {
                etRef.setError("Field is required");
                etRef.requestFocus();
                return;
            }

            Intent i = new Intent();
            i.putExtra("references", ref);

            setResult(RESULT_OK, i);
            finish();
        });
    }
    private void init()
    {
        etRef = findViewById(R.id.etReferences);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }
    private boolean validateField(String field) {
        return !field.isEmpty();
    }
}