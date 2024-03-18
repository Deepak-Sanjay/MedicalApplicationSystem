package com.example.medicalapplicationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Firstaid extends AppCompatActivity {
    AppCompatImageView imgViewBack;
    Button cpr,sei,sas,sci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid);
        imgViewBack = findViewById(R.id.imgViewBack);
        cpr = findViewById(R.id.cri);
        sei = findViewById(R.id.sei);
        sas = findViewById(R.id.sas);
        sci = findViewById(R.id.sci);
        imgViewBack.setOnClickListener(v -> {
                    onBackPressed();
                }
        );
        sci.setOnClickListener(v -> {
            Intent intent = new Intent(this, FikDetails.class);
            intent.putExtra("title","SPINAL CORD INJURY");
            startActivity(intent);
                }
        );
        sei.setOnClickListener(v -> {
            Intent intent = new Intent(this, FikDetails2.class);
            intent.putExtra("title","SEIZURES");
            startActivity(intent);
                }
        ); cpr.setOnClickListener(v -> {
            Intent intent = new Intent(this, FikDetails3.class);
            intent.putExtra("title","CPR");
            startActivity(intent);
                }
        );

    }


}