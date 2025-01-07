package com.example.doctor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        if (!username.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Welcome " + username, Toast.LENGTH_SHORT).show();
        }

        Button exit = findViewById(R.id.btnLogout);
        exit.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        });

        CardView findDoctor = findViewById(R.id.onlineConsult);
        findDoctor.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class)));

        CardView labTest = findViewById(R.id.labTest);
        labTest.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, LabTestActivity.class)));

        CardView orderDetails = findViewById(R.id.orderDetails);
        orderDetails.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, CartLabActivity.class)));  // Changed from CartLabActivity to OrderDetailsActivity

        CardView book = findViewById(R.id.BookDoctor);
        book.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, LabTestBookActivity.class)));

        CardView About = findViewById(R.id.about);
        About.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, AboutActivity.class)));

        CardView article = findViewById(R.id.article);
        article.setOnClickListener(view -> startActivity(new Intent(HomeActivity.this, ArticleActivity.class)));

    }
}
