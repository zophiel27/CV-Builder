package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button btnProfile, btnPersonalDetails, btnSummary, btnEdu, btnExp, btnCert, btnRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                if (name.matches("")){
                    Toast.makeText(Home.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Home.this, Quiz.class);
                    i.putExtra("key_name", name);
                    startActivity(i);
                    finish();
                }
            }
        });
        btnPersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                if (name.matches("")){
                    Toast.makeText(Home.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Home.this, Quiz.class);
                    i.putExtra("key_name", name);
                    startActivity(i);
                    finish();
                }
            }
        });
        btnSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                if (name.matches("")){
                    Toast.makeText(Home.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Home.this, Quiz.class);
                    i.putExtra("key_name", name);
                    startActivity(i);
                    finish();
                }
            }
        });
        btnEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                if (name.matches("")){
                    Toast.makeText(Home.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Home.this, Quiz.class);
                    i.putExtra("key_name", name);
                    startActivity(i);
                    finish();
                }
            }
        });
        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                if (name.matches("")){
                    Toast.makeText(Home.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Home.this, Quiz.class);
                    i.putExtra("key_name", name);
                    startActivity(i);
                    finish();
                }
            }
        });
        btnCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                if (name.matches("")){
                    Toast.makeText(Home.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Home.this, Quiz.class);
                    i.putExtra("key_name", name);
                    startActivity(i);
                    finish();
                }
            }
        });
        btnRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                if (name.matches("")){
                    Toast.makeText(Home.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(Home.this, Quiz.class);
                    i.putExtra("key_name", name);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
    private void init(){
        btnProfile = findViewById(R.id.btnProfile);
        btnPersonalDetails = findViewById(R.id.btnPersonalDetails);
        btnSummary = findViewById(R.id.btnSummary);
        btnEdu = findViewById(R.id.btnEducation);
        btnExp = findViewById(R.id.btnExperience);
        btnCert = findViewById(R.id.btnCertifications);
        btnRef = findViewById(R.id.btnReferences);
    }
}