package com.example.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] Packages = {
            {"Package 1: Full Body Checkup", "999"},
            {"Package 2: Blood Glucose Fasting", "879"},
            {"Package 3: Covid-19 Antibody - IgC", "239"},
            {"Package 4: Thyroid Checkup", "699"},
            {"Package 5: Immunity Checkup", "979"},
            {"Package 6: Diabetes Screening", "649"},
            {"Package 7: Heart Function Test", "1299"},
            {"Package 8: Liver Function Test", "799"},
            {"Package 9: Vitamin Deficiency Panel", "999"},
            {"Package 10: Cancer Marker Screening", "1999"}
    };

    private String[] Packages_detail = {
            "This package includes a comprehensive analysis of your overall health. It evaluates major body functions including CBC, kidney function, liver function, lipid profile, and glucose levels.",
            "This test measures blood glucose levels after fasting for 8-12 hours. It helps identify early signs of diabetes or monitor glucose management in diabetics.",
            "This test determines if your body has developed immunity against Covid-19, either post-infection or vaccination. It measures the IgC antibodies.",
            "The thyroid checkup analyzes the functioning of your thyroid gland by measuring T3, T4, and TSH levels, which are critical for metabolism and energy balance.",
            "An immunity checkup assesses the strength of your immune system. It includes white blood cell counts, key protein markers, and inflammation indicators.",
            "Diabetes screening detects early signs of diabetes or pre-diabetic conditions. It includes fasting glucose and HbA1c tests to evaluate sugar control over months.",
            "This package evaluates heart function, including lipid profile, ECG, and cardiac enzyme tests. It's essential for detecting heart disease risks.",
            "Liver function tests assess enzyme levels, bilirubin, and protein levels to determine the health of your liver and detect liver diseases.",
            "Vitamin deficiency panel tests for deficiencies in key vitamins such as Vitamin D and B12, which are crucial for bone health, energy, and immunity.",
            "Cancer marker screening checks for the presence of specific proteins or markers in the blood that are associated with certain types of cancers."
    };

    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        // Initialize Buttons and ListView
        btnGoToCart = findViewById(R.id.listViewButtonCart);
        btnBack = findViewById(R.id.listViewButtonBack);
        listView = findViewById(R.id.listView);

        btnBack.setOnClickListener(view -> {
            // Navigate back to home activity
            startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
        });

        // Populate the list with package data
        list = new ArrayList<>();
        for (int i = 0; i < Packages.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", Packages[i][0]); // Package name
            item.put("line2", "Cost: ₹" + Packages[i][1] + "/-"); // Package cost
            list.add(item);
        }

        // Set up the SimpleAdapter
        sa = new SimpleAdapter(
                this,
                list,
                R.layout.multi_lines,    // Use the multi_lines layout to display package and cost
                new String[]{"line1", "line2"},    // Mapping keys to layout fields
                new int[]{R.id.line_a, R.id.line_b}    // Map fields in layout to TextViews
        );
        listView.setAdapter(sa);

        // Handle list item click
        listView.setOnItemClickListener((AdapterView<?> adapterView, android.view.View view, int position, long id) -> {
            Intent intent = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
            intent.putExtra("title", Packages[position][0]);
            intent.putExtra("description", Packages_detail[position]);
            intent.putExtra("cost", Packages[position][1]);
            startActivity(intent);
        });

        // Go to Cart button click listener
        btnGoToCart.setOnClickListener(view -> {
            startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
        });
    }
}
