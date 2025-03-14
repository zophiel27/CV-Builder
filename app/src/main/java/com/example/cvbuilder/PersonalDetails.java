package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class PersonalDetails extends AppCompatActivity {

    EditText etName, etPhone, etEmail, etUrl;
    Button btnSave, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        init();

        btnCancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });
        btnSave.setOnClickListener((v)->{
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String url = etUrl.getText().toString();
            String phone = etPhone.getText().toString();

            Intent i = new Intent();
            i.putExtra("name", name);
            i.putExtra("url", url);
            i.putExtra("phone", phone);
            i.putExtra("email", email);

            setResult(RESULT_OK, i);
            finish();
        });
    }
    private void init()
    {
        etPhone = findViewById(R.id.etPhone);
        etUrl = findViewById(R.id.etUrl);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }
}