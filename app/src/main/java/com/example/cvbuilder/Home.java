package com.example.cvbuilder;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button btnProfile, btnPersonalDetails, btnSummary, btnEdu, btnExp, btnCert, btnRef, btnPreviewCV;
    ActivityResultLauncher<Intent> getImageLauncher;
    ActivityResultLauncher<Intent> getPersonalDetailLauncher;
    ActivityResultLauncher<Intent> getSummaryLauncher;
    ActivityResultLauncher<Intent> getEduLauncher;
    ActivityResultLauncher<Intent> getExpLauncher;
    ActivityResultLauncher<Intent> getCertLauncher;
    ActivityResultLauncher<Intent> getRefLauncher;

    Uri profilePic;
    String name, phone, email, url;
    String summary;
    String education, program;
    String experience, time;
    String certifications;
    String references;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                getImageLauncher.launch(i);
            }
        });
        btnPersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, PersonalDetails.class);
                getPersonalDetailLauncher.launch(i);
            }
        });
        btnSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Summary.class);
                startActivity(i);
            }
        });
        btnEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Education.class);
                startActivity(i);
            }
        });
        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Experience.class);
                startActivity(i);
            }
        });
        btnCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Certifications.class);
                startActivity(i);
            }
        });
        btnRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, References.class);
                startActivity(i);
            }
        });
        btnPreviewCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, PreviewCV.class);
                i.putExtra("name", name);
                i.putExtra("email", email);
                i.putExtra("phone", phone);
                i.putExtra("url", url);
//                i.putExtra("summary", summary);
//                i.putExtra("education", education);
//                i.putExtra("experience", experience);
//                i.putExtra("certifications", certifications);
//                i.putExtra("references", references);
                if (profilePic != null) {
                    i.putExtra("profilePicUri", profilePic.toString());
                }

                startActivity(i);
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
        btnPreviewCV = findViewById(R.id.btnPreviewCV);

        getImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            (result)->{
                if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                {
                    profilePic = result.getData().getData();
                }
                else
                {
                    Toast.makeText(this, "Select the image", Toast.LENGTH_SHORT).show();
                }
            });

        getPersonalDetailLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            (result)->{
                if(result.getResultCode() == RESULT_OK && result.getData() != null)
                {
                    Intent dataIntent = result.getData();
                    name = dataIntent.getStringExtra("name");
                    phone = dataIntent.getStringExtra("phone");
                    email = dataIntent.getStringExtra("email");
                    url = dataIntent.getStringExtra("url");
                }
            });
        getSummaryLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        summary = dataIntent.getStringExtra("summary");
                    }
                });
        getEduLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        education = dataIntent.getStringExtra("education");
                        program = dataIntent.getStringExtra("program");
                    }
                });
        getExpLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        experience = dataIntent.getStringExtra("experience");
                        time = dataIntent.getStringExtra("time");
                    }
                });
        getCertLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        certifications = dataIntent.getStringExtra("certifications");
                    }
                });
        getRefLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        references = dataIntent.getStringExtra("references");
                    }
                });
    }
}