package com.example.cvbuilder;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button btnProfile, btnPersonalDetails, btnSummary, btnEdu, btnExp, btnCert, btnRef, btnPreviewCV;
    ActivityResultLauncher<Intent> getImageLauncher, getPersonalDetailLauncher, getSummaryLauncher, getEduLauncher, getExpLauncher, getCertLauncher, getRefLauncher;

    Uri profilePic;
    String name, phone, email, url;
    String summary;
    String education, program;
    String experience, time;
    String certifications;
    String references;
    private static final String TAG = "Home";

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
                getSummaryLauncher.launch(i);
            }
        });
        btnEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Education.class);
                getEduLauncher.launch(i);
            }
        });
        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Experience.class);
                getExpLauncher.launch(i);
            }
        });
        btnCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, Certifications.class);
                getCertLauncher.launch(i);
            }
        });
        btnRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, References.class);
                getRefLauncher.launch(i);
            }
        });
        btnPreviewCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, PreviewCV.class);
                if(name != null){
                    i.putExtra("name", name);
                }
                if(email != null){
                    i.putExtra("email", email);
                }
                if(phone != null){
                    i.putExtra("phone", phone);
                }
                if(url != null){
                    i.putExtra("url", url);
                }
                if(summary != null){
                    i.putExtra("summary", summary);
                }
                if(program != null){
                    i.putExtra("program", program);
                }
                if(education != null){
                    i.putExtra("education", education);
                }
                if(experience != null){
                    i.putExtra("experience", experience);
                }
                if(time != null){
                    i.putExtra("time", time);
                }
                if(certifications != null){
                    i.putExtra("certifications", certifications);
                }
                if(references != null){
                    i.putExtra("references", references);
                }
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

//        btnPreviewCV.setEnabled(false);

        getImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            (result)->{
                if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                {
                    profilePic = result.getData().getData();
                    checkIfReadyToPreview();
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
                    Log.d(TAG, "DATA WAS RECEIVED");
                    Log.d(TAG, "Received Name: " + name);
                    Log.d(TAG, "Received Email: " + email);
                    Log.d(TAG, "Received Phone: " + phone);
                    Log.d(TAG, "Received Url: " + url);
                    checkIfReadyToPreview();
                }
                else
                {
                    Log.d(TAG, "NO DATA RECEIVED");
                }
            });
        getSummaryLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        summary = dataIntent.getStringExtra("summary");
                        checkIfReadyToPreview();
                    }
                });
        getEduLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        education = dataIntent.getStringExtra("education");
                        program = dataIntent.getStringExtra("program");
                        checkIfReadyToPreview();
                    }
                });
        getExpLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        experience = dataIntent.getStringExtra("experience");
                        time = dataIntent.getStringExtra("time");
                        checkIfReadyToPreview();
                    }
                });
        getCertLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        certifications = dataIntent.getStringExtra("certifications");
                        checkIfReadyToPreview();
                    }
                });
        getRefLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null)
                    {
                        Intent dataIntent = result.getData();
                        references = dataIntent.getStringExtra("references");
                        checkIfReadyToPreview();
                    }
                });
    }
    private void checkIfReadyToPreview() {
        // for an option to disable previewing CV till all info is filled
//        if (profilePic != null &&
//                name != null && !name.isEmpty() &&
//                phone != null && !phone.isEmpty() &&
//                email != null && !email.isEmpty() &&
//                url != null && !url.isEmpty() &&
//                summary != null && !summary.isEmpty() &&
//                education != null && !education.isEmpty() &&
//                program != null && !program.isEmpty() &&
//                experience != null && !experience.isEmpty() &&
//                time != null && !time.isEmpty() &&
//                certifications != null && !certifications.isEmpty() &&
//                references != null && !references.isEmpty()) {
//
//            btnPreviewCV.setEnabled(true);
//            Toast.makeText(this, "CV is ready to preview!", Toast.LENGTH_SHORT).show();
//        } else {
//            btnPreviewCV.setEnabled(false);
//        }
    }
}