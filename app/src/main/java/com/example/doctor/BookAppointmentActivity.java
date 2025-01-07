package com.example.doctor;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    Button back, dateButton, timeButton, bookButton;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_appointment);

        // Adjust layout for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        tv = findViewById(R.id.appointmentTitle);
        ed1 = findViewById(R.id.fullName);
        ed2 = findViewById(R.id.address);
        ed3 = findViewById(R.id.number);
        ed4 = findViewById(R.id.fees);
        back = findViewById(R.id.btnback);
        dateButton = findViewById(R.id.bookAppointmentDate);
        timeButton = findViewById(R.id.bookAppointmentTime);
        bookButton = findViewById(R.id.bookAppointment);

        // Disable editing for the fields
        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        // Back button functionality
        back.setOnClickListener(view -> {
            startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class));
        });

        // Initialize date and time pickers
        initDatePicker();
        initTimePicker();

        // Date picker button functionality
        dateButton.setOnClickListener(view -> datePickerDialog.show());

        // Time picker button functionality
        timeButton.setOnClickListener(view -> timePickerDialog.show());

        // Book appointment button functionality
        bookButton.setOnClickListener(view -> {




            Toast.makeText(this, "Appointment booked successfully!", Toast.LENGTH_SHORT).show();
        });

        // Get the selected doctor's details from the Intent
        Intent intent = getIntent();
        String doctorName = intent.getStringExtra("doctor_name");
        String doctorSpecialization = intent.getStringExtra("doctor_specialization");
        String doctorAddress = intent.getStringExtra("doctor_address");
        String doctorFees = intent.getStringExtra("doctor_fees");
        String doctorTimings = intent.getStringExtra("doctor_timings");

        // Set the retrieved data to the UI elements
        tv.setText(doctorSpecialization);
        ed1.setText(doctorName);
        ed2.setText(doctorAddress);
        ed3.setText(doctorTimings);
        ed4.setText(doctorFees);
    }

    // Initialize the date picker
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, month, day) -> {
            month = month + 1; // Months are indexed from 0
            String date = day + "/" + month + "/" + year;
            dateButton.setText(date);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(
                this,
                AlertDialog.THEME_HOLO_DARK,
                dateSetListener,
                year,
                month,
                day
        );

        // Set the minimum date to today
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis());
    }

    // Initialize the time picker
    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = (timePicker, hourOfDay, minute) -> {
            String time = String.format("%02d:%02d", hourOfDay, minute);
            timeButton.setText(time);
        };

        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);

        timePickerDialog = new TimePickerDialog(
                this,
                AlertDialog.THEME_HOLO_DARK,
                timeSetListener,
                hour,
                minute,
                true // Use 24-hour format
        );
    }
}
