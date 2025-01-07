package com.example.doctor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LabTestBookActivity extends AppCompatActivity {
    private EditText edName, edAddress, edContact, edPinCode;
    private Button btnBooking, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        // Initialize UI components
        edName = findViewById(R.id.tbfullname);
        edAddress = findViewById(R.id.tbAddress);
        edContact = findViewById(R.id.tbContactNumber);
        edPinCode = findViewById(R.id.tbPinCode);
        btnBooking = findViewById(R.id.tbBook);
        btnBack = findViewById(R.id.btn_back);  // Now it's a Button instead of ImageButton

        // Handle the back button click to navigate back
        btnBack.setOnClickListener(view -> onBackPressed());

        // Retrieve intent extras safely
        Intent intent = getIntent();
        String priceString = intent.getStringExtra("price");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        float amount = 0;
        if (priceString != null && priceString.contains(":")) {
            try {
                String[] priceParts = priceString.split(":");
                amount = Float.parseFloat(priceParts[1]); // Extract and parse amount
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid price format", Toast.LENGTH_SHORT).show();
            }
        }

        // Handle booking button click
        float finalAmount = amount; // To use within the lambda
        btnBooking.setOnClickListener(view -> {
            // Get shared preferences
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");

            // Validate input fields
            if (edName.getText().toString().trim().isEmpty() ||
                    edAddress.getText().toString().trim().isEmpty() ||
                    edContact.getText().toString().trim().isEmpty() ||
                    edPinCode.getText().toString().trim().isEmpty()) {

                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Ensure contact number and pin code are valid
            String contact = edContact.getText().toString().trim();
            String pinCode = edPinCode.getText().toString().trim();
            if (!contact.matches("\\d{10}")) {
                Toast.makeText(this, "Please enter a valid 10-digit contact number", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!pinCode.matches("\\d{6}")) {
                Toast.makeText(this, "Please enter a valid 6-digit pin code", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save booking details
            Database db = new Database(getApplicationContext());
            db.addOrder(
                    username,
                    edName.getText().toString(),
                    "Lab Test",
                    finalAmount,
                    edAddress.getText().toString(),
                    contact,
                    Integer.parseInt(pinCode),
                    date,
                    time,
                    finalAmount,
                    "lab"
            );
            db.removeCart(username, "lab");

            // Notify success and navigate back to home
            Toast.makeText(getApplicationContext(), "Your booking is done successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LabTestBookActivity.this, HomeActivity.class));
        });
    }
}
