package com.example.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Buttons
        Button btnPrivacyPolicy = findViewById(R.id.btn_privacy_policy);
        Button btnBack = findViewById(R.id.btn_back);

        // Privacy Policy Button Click Listener
        btnPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "Privacy Policy Applied", Toast.LENGTH_SHORT).show();
            }
        });

        // Back Button Click Listener
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutActivity.this, HomeActivity.class));
                finish(); // Finish the current activity to avoid stacking
            }
        });
    }
}
