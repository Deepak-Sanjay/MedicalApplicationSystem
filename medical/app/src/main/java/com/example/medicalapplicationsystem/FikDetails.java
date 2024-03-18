package com.example.medicalapplicationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FikDetails extends AppCompatActivity {
    AppCompatImageView imgViewBack;
    TextView tvTitle;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fik_details);
        imgViewBack = findViewById(R.id.imgViewBack);
        tvTitle = findViewById(R.id.tvTitle);
        imgViewBack.setOnClickListener(v -> {
                    onBackPressed();
                }
        );

    }
}