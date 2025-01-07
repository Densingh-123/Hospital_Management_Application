package com.example.doctor;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CartLabActivity extends AppCompatActivity {

    private static final String TAG = "CartLabActivity";
    private HashMap<String, String> item;
    private ArrayList<HashMap<String, String>> list;
    private TextView tvTotal;
    private Button dateButton, timeButton, btnCheckout, btnBack;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private SimpleAdapter sa;
    private ListView lvData;
    private double totalAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        // Edge-to-edge display support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        dateButton = findViewById(R.id.bookAppointmentDate);
        timeButton = findViewById(R.id.bookAppointmentTime);
        tvTotal = findViewById(R.id.totalCost);
        btnCheckout = findViewById(R.id.checkout);
        btnBack = findViewById(R.id.btnback);
        lvData = findViewById(R.id.lvdata);

        // Fetch user data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        // Create a Database instance
        Database db = new Database(getApplicationContext());

        // Fetch cart data
        ArrayList<String> dbData = db.getCartData(username, "lab");
        if (dbData.isEmpty()) {
            Toast.makeText(this, "No items in the cart", Toast.LENGTH_SHORT).show();
        } else {
            populateCartList(dbData);
        }

        // Set up date and time picker buttons
        initDatePicker();
        initTimePicker();

        // Checkout button functionality
        btnCheckout.setOnClickListener(view -> {
            String selectedDate = dateButton.getText().toString();
            String selectedTime = timeButton.getText().toString();

            if (selectedDate.equals("00/00/0000") || selectedTime.equals("00:00")) {
                Toast.makeText(this, "Please select a valid date and time", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(CartLabActivity.this, LabTestBookActivity.class);
                intent.putExtra("price", tvTotal.getText().toString());
                intent.putExtra("date", selectedDate);
                intent.putExtra("time", selectedTime);
                Log.d(TAG, "Navigating to LabTestBookActivity with data: " + intent.getExtras());
                startActivity(intent);
            }
        });

        // Date picker button
        dateButton.setOnClickListener(view -> datePickerDialog.show());

        // Time picker button
        timeButton.setOnClickListener(view -> timePickerDialog.show());

        // Back button functionality
        btnBack.setOnClickListener(view -> startActivity(new Intent(CartLabActivity.this, LabTestActivity.class)));
    }

    private void populateCartList(ArrayList<String> dbData) {
        list = new ArrayList<>();
        for (String data : dbData) {
            String[] splitData = data.split("\\$");
            String product = splitData[0];
            String price = splitData[1];

            totalAmount += Double.parseDouble(price);

            item = new HashMap<>();
            item.put("line1", product);
            item.put("line5", "Cost: ₹" + price);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"line1", "line5"},
                new int[]{R.id.line_a, R.id.line_e});
        lvData.setAdapter(sa);

        // Update total cost
        tvTotal.setText("Total Cost: ₹" + String.format("%.2f", totalAmount));
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, month, day) -> {
            String date = day + "/" + (month + 1) + "/" + year;
            dateButton.setText(date);
        };

        Calendar cal = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(
                this,
                AlertDialog.THEME_HOLO_DARK,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis());
    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = (timePicker, hourOfDay, minute) -> {
            String time = String.format("%02d:%02d", hourOfDay, minute);
            timeButton.setText(time);
        };

        Calendar cal = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(
                this,
                AlertDialog.THEME_HOLO_DARK,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
        );
    }
}
