package com.example.doctor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsActivity extends AppCompatActivity {
    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    ListView lst;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        btn = findViewById(R.id.odbtnback);
        lst = findViewById(R.id.odlistview);

        btn.setOnClickListener(view -> startActivity(new Intent(OrderDetailsActivity.this, HomeActivity.class)));

        Database db = new Database(getApplicationContext());
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        // Fetching order data
        ArrayList<String> dbData = db.getOrderData(username);
        Log.d("OrderDetailsActivity", "Fetched Data: " + dbData); // Debugging log

        list = new ArrayList<>();

        if (dbData != null && !dbData.isEmpty()) {
            for (String record : dbData) {
                Log.d("OrderDetailsActivity", "Processing Record: " + record); // Debugging log
                String[] strData = record.split("\\$");

                // Ensure the record contains enough data
                if (strData.length >= 8) { // Adjust based on expected data length
                    item = new HashMap<>();
                    item.put("line1", "Name: " + strData[0]); // Full name
                    item.put("line2", "Address: " + strData[1]); // Address
                    item.put("line3", "Contact: " + strData[2]); // Contact number
                    item.put("line4", "Pincode: " + strData[3]); // Pincode
                    item.put("line5", "Price: $" + strData[7]); // Price
                    list.add(item);
                } else {
                    Log.e("OrderDetailsActivity", "Malformed Record: " + record); // Error log
                }
            }
        } else {
            Log.e("OrderDetailsActivity", "No data found for user: " + username);
        }

        sa = new SimpleAdapter(
                this,
                list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        lst.setAdapter(sa);
    }
}
