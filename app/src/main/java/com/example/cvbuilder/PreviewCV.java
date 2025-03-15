package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
public class PreviewCV extends AppCompatActivity {

    ImageView ivPreviewProfilePic;
    Button btnShareCV;
    TextView tvPreviewName, tvPreviewEmail, tvPreviewPhone, tvPreviewUrl, tvPreviewSummary;

    private static final String TAG = "PreviewCV";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_cv);

        init();

//        if (imageUriString != null) {
//            Uri imageUri = Uri.parse(imageUriString);
//            cvProfileImageView.setImageURI(imageUri);
//        }
//
//        btnShareCV.setOnClickListener(v -> shareCV(name, summary));
    }

    private void init() {

        ivPreviewProfilePic = findViewById(R.id.ivPreviewProfilePic);
        tvPreviewName = findViewById(R.id.tvPreviewName);
        tvPreviewEmail = findViewById(R.id.tvPreviewEmail);
        tvPreviewPhone = findViewById(R.id.tvPreviewPhone);
        tvPreviewUrl = findViewById(R.id.tvPreviewUrl);
        tvPreviewSummary = findViewById(R.id.tvPreviewSummary);
        btnShareCV = findViewById(R.id.btnShareCV);

        Intent intent = getIntent();
        tvPreviewName.setText(intent.getStringExtra("name"));
        tvPreviewEmail.setText(intent.getStringExtra("email"));
        tvPreviewPhone.setText(intent.getStringExtra("phone"));
        tvPreviewUrl.setText(intent.getStringExtra("url"));
        tvPreviewSummary.setText(intent.getStringExtra("summary"));
    }
    private void shareCV(String name, String summary) {
        String cvData = "Name: " + name + "\n" +
                "Summary: " + summary + "\n";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My CV");
        shareIntent.putExtra(Intent.EXTRA_TEXT, cvData);

        startActivity(Intent.createChooser(shareIntent, "Share CV via"));
    }
}