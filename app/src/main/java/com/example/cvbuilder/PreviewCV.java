package com.example.cvbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import java.io.File;
import java.io.FileOutputStream;

public class PreviewCV extends AppCompatActivity {

    ImageView ivPreviewProfilePic;
    Button btnShareCV;
    TextView tvPreviewName, tvPreviewEmail, tvPreviewPhone, tvPreviewUrl, tvPreviewSummary;

    TextView tvEducation, tvProgram;
    TextView tvExperience, tvTime;
    TextView tvCertifications;
    TextView tvReferences;

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
        btnShareCV.setOnClickListener(v -> shareCV());
    }

    private void init() {

        ivPreviewProfilePic = findViewById(R.id.ivPreviewProfilePic);
        tvPreviewName = findViewById(R.id.tvPreviewName);
        tvPreviewEmail = findViewById(R.id.tvPreviewEmail);
        tvPreviewPhone = findViewById(R.id.tvPreviewPhone);
        tvPreviewUrl = findViewById(R.id.tvPreviewUrl);
        tvPreviewSummary = findViewById(R.id.tvPreviewSummary);
        tvEducation = findViewById(R.id.tvPreviewEdu);
        tvProgram = findViewById(R.id.tvPreviewEduProgram);
        tvExperience = findViewById(R.id.tvPreviewExp);
        tvTime = findViewById(R.id.tvPreviewExpTime);
        tvCertifications = findViewById(R.id.tvPreviewCert);
        tvReferences = findViewById(R.id.tvPreviewRef);
        btnShareCV = findViewById(R.id.btnShareCV);

        Intent intent = getIntent();
        if (intent.hasExtra("name")){
            tvPreviewName.setText(intent.getStringExtra("name"));
        }
        if (intent.hasExtra("email")){
            tvPreviewEmail.setText(intent.getStringExtra("email"));
        }
        if (intent.hasExtra("phone")){
            tvPreviewPhone.setText(intent.getStringExtra("phone"));
        }
        if (intent.hasExtra("url")){
            tvPreviewUrl.setText(intent.getStringExtra("url"));
        }
        if (intent.hasExtra("summary")){
            tvPreviewSummary.setText(intent.getStringExtra("summary"));
        }
        if (intent.hasExtra("education")) {
            tvEducation.setText(intent.getStringExtra("education"));
        }
        if (intent.hasExtra("program")) {
            tvProgram.setText(intent.getStringExtra("program"));
        }
        if (intent.hasExtra("experience")) {
            tvExperience.setText(intent.getStringExtra("experience"));
        }
        if (intent.hasExtra("time")) {
            tvTime.setText(intent.getStringExtra("time"));
        }
        if (intent.hasExtra("certifications")) {
            tvCertifications.setText(intent.getStringExtra("certifications"));
        }
        if (intent.hasExtra("references")) {
            tvReferences.setText(intent.getStringExtra("references"));
        }
        if (intent.hasExtra("profilePicUri")) {
            Uri imageUri = Uri.parse(intent.getStringExtra("profilePicUri"));
            ivPreviewProfilePic.setImageURI(imageUri);
        }
    }
    private void shareCV() {
        View cvLayout = findViewById(R.id.previewCVLayout);
        Bitmap cvBitmap = getScreenshotFromView(cvLayout);

        try {
            File file = new File(getCacheDir(), "cv_preview.png");
            FileOutputStream fOut = new FileOutputStream(file);
            cvBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri photoURI = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
            intent.putExtra(Intent.EXTRA_STREAM, photoURI);
            intent.setType("image/png");
            startActivity(Intent.createChooser(intent, "Share CV via"));

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Error sharing CV: " + e.getMessage());
        }
    }
    private Bitmap getScreenshotFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }
}