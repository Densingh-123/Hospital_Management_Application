package com.example.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        // Initialize views
        listView = findViewById(R.id.listView);
        btnBack = findViewById(R.id.listViewButtonDDBack);

        // Retrieve the doctor details passed from FindDoctorActivity
        Intent intent = getIntent();
        String[][] doctorDetails = (String[][]) intent.getSerializableExtra("doctor_details");

        // Prepare the data for the ListView
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        for (String[] doctorDetail : doctorDetails) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", doctorDetail[0]); // Doctor's Name
            item.put("line2", doctorDetail[1]); // Specialization
            item.put("line3", doctorDetail[2]); // Address
            item.put("line4", doctorDetail[3]); // Fees
            item.put("line5", doctorDetail[4]); // Timings
            list.add(item);
        }

        // Create a SimpleAdapter to display the data in the ListView
        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.doctor_detail_item,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line1, R.id.line2, R.id.line3, R.id.line4, R.id.line5});
        listView.setAdapter(adapter);

        // Set click listener for ListView items
        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected doctor details
            String[] selectedDoctor = doctorDetails[position];

            // Create an intent to navigate to BookAppointmentActivity
            Intent bookAppointmentIntent = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);

            // Pass the selected doctor details to the BookAppointmentActivity
            bookAppointmentIntent.putExtra("doctor_name", selectedDoctor[0]);
            bookAppointmentIntent.putExtra("doctor_specialization", selectedDoctor[1]);
            bookAppointmentIntent.putExtra("doctor_address", selectedDoctor[2]);
            bookAppointmentIntent.putExtra("doctor_fees", selectedDoctor[3]);
            bookAppointmentIntent.putExtra("doctor_timings", selectedDoctor[4]);

            // Start the activity
            startActivity(bookAppointmentIntent);
        });

        // Set click listener for the back button
        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
        });
    }
}
