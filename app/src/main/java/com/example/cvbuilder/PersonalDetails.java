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
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String url = etUrl.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

//            if (!validateFields(name, email, phone)) {
//                // If validation fails, do nothing (user sees the error)
//                return;
//            }

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
//    private boolean validateFields(String name, String email, String phone) {
//        boolean isValid = true;
//
//        if (name.isEmpty()) {
//            etName.setError("Name is required");
//            etName.requestFocus();
//            isValid = false;
//        }
//
//        if (email.isEmpty()) {
//            etEmail.setError("Email is required");
//            if (isValid) etEmail.requestFocus();
//            isValid = false;
//        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            etEmail.setError("Enter a valid email");
//            if (isValid) etEmail.requestFocus();
//            isValid = false;
//        }
//
//        if (phone.isEmpty()) {
//            etPhone.setError("Phone number is required");
//            if (isValid) etPhone.requestFocus();
//            isValid = false;
//        } else if (phone.length() < 10) {
//            etPhone.setError("Enter a valid phone number");
//            if (isValid) etPhone.requestFocus();
//            isValid = false;
//        }
//
//        return isValid;
//    }
}