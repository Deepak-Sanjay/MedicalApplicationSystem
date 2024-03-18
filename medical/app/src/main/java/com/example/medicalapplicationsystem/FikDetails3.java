package com.example.medicalapplicationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;

public class FikDetails3 extends AppCompatActivity {
    AppCompatImageView imgViewBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fik_details3);
        imgViewBack = findViewById(R.id.imgViewBack);

        imgViewBack.setOnClickListener(v -> {
                    onBackPressed();
                }
        );
    }
}