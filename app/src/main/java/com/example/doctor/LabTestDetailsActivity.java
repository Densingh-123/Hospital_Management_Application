package com.example.doctor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvDescription, tvTotalCost;
    Button btnClose, btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        // Initialize UI elements
        tvPackageName = findViewById(R.id.textViewTDSubTitle);
        tvDescription = findViewById(R.id.textViewDescription);
        tvTotalCost = findViewById(R.id.textViewLTDTitle);
        btnClose = findViewById(R.id.listViewTDButtonBack);
        btnAddToCart = findViewById(R.id.listViewTDButtonCart);

        // Retrieve data from intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String cost = intent.getStringExtra("cost");

        // Set data to views
        tvPackageName.setText(title);
        tvDescription.setText(description);
        tvTotalCost.setText("Total Cost: ₹" + cost + "/-");

        // Close button listener
        btnClose.setOnClickListener(view -> {
            startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
        });

        // Add to Cart button listener
        btnAddToCart.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");

            try {
                float price = Float.parseFloat(cost);
                Database db = new Database(getApplicationContext());
                if (db.isItemInCart(username, title)) {  // Use the updated method name
                    Toast.makeText(getApplicationContext(), "Product Already Exists in the Cart", Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username, title, price, "lab");
                    Toast.makeText(getApplicationContext(), "Product Added to the Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Invalid price format.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
