package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Certifications extends AppCompatActivity {
    EditText etCert;
    Button btnSave, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certifications);

        init();

        btnCancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
        btnSave.setOnClickListener((v)->{
            String cert = etCert.getText().toString().trim();

            if (!validateField(cert)) {
                etCert.setError("Field is required");
                etCert.requestFocus();
                return;
            }

            Intent i = new Intent();
            i.putExtra("certifications", cert);

            setResult(RESULT_OK, i);
            finish();
        });
    }
    private void init()
    {
        etCert = findViewById(R.id.etCertifications);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }
    private boolean validateField(String field) {
        return !field.isEmpty();
    }

}