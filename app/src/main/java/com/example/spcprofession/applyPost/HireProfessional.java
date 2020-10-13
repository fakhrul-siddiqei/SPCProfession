package com.example.spcprofession.applyPost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.spcprofession.R;

public class HireProfessional extends AppCompatActivity {
    TextView  names, profs, areas, dess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_professional);
        Log.d("GG","AA");

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        String prof = intent.getStringExtra("PROF");
        String area = intent.getStringExtra("AREA");
        String des = intent.getStringExtra("DES");

        profs=findViewById(R.id.PROF_AP);
        names=findViewById(R.id.NAME_APP);
        areas=findViewById(R.id.AREA_AP);
        dess=findViewById(R.id.DES_AP);
        profs.setText(prof);
        names.setText(name);
        areas.setText(area);
        dess.setText(des);
    }
}


