package com.example.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctorActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main St, City, State", "Experience : 10 years", "Mobile No : 123-456-7890", "Fees : $150"},
            {"Doctor Name : Dr. Emily Clark", "Hospital Address : 456 Oak Ave, City, State", "Experience : 8 years", "Mobile No : 234-567-8901", "Fees : $200"},
            {"Doctor Name : Dr. Sarah Johnson", "Hospital Address : 789 Pine Rd, City, State", "Experience : 12 years", "Mobile No : 345-678-9012", "Fees : $120"},
            {"Doctor Name : Dr. David Lee", "Hospital Address : 101 Maple Blvd, City, State", "Experience : 15 years", "Mobile No : 456-789-0123", "Fees : $180"},
            {"Doctor Name : Dr. Mia Rodriguez", "Hospital Address : 202 Birch Ln, City, State", "Experience : 7 years", "Mobile No : 567-890-1234", "Fees : $130"},
            {"Doctor Name : Dr. Mark Thompson", "Hospital Address : 303 Cedar Dr, City, State", "Experience : 9 years", "Mobile No : 678-901-2345", "Fees : $160"},
            {"Doctor Name : Dr. Linda Davis", "Hospital Address : 404 Spruce Ct, City, State", "Experience : 11 years", "Mobile No : 789-012-3456", "Fees : $140"},
            {"Doctor Name : Dr. James Williams", "Hospital Address : 505 Elm St, City, State", "Experience : 13 years", "Mobile No : 890-123-4567", "Fees : $175"},
            {"Doctor Name : Dr. Olivia Martinez", "Hospital Address : 606 Ash Ave, City, State", "Experience : 6 years", "Mobile No : 901-234-5678", "Fees : $110"},
            {"Doctor Name : Dr. Robert Brown", "Hospital Address : 707 Pinehill Rd, City, State", "Experience : 14 years", "Mobile No : 012-345-6789", "Fees : $190"},
            {"Doctor Name : Dr. Isabella Wilson", "Hospital Address : 808 Oakwood Blvd, City, State", "Experience : 5 years", "Mobile No : 123-456-7891", "Fees : $100"},
            {"Doctor Name : Dr. Daniel Taylor", "Hospital Address : 909 Maple St, City, State", "Experience : 16 years", "Mobile No : 234-567-8902", "Fees : $220"},
            {"Doctor Name : Dr. Charlotte Anderson", "Hospital Address : 1010 Cedar Rd, City, State", "Experience : 10 years", "Mobile No : 345-678-9013", "Fees : $155"},
            {"Doctor Name : Dr. Henry Scott", "Hospital Address : 1111 Birchwood Dr, City, State", "Experience : 4 years", "Mobile No : 456-789-0124", "Fees : $90"},
            {"Doctor Name : Dr. Ava Walker", "Hospital Address : 1212 Spruce Ave, City, State", "Experience : 18 years", "Mobile No : 567-890-1235", "Fees : $210"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main St, City, State", "Experience : 10 years", "Mobile No : 123-456-7890", "Fees : $150"},
            {"Doctor Name : Dr. Emily Clark", "Hospital Address : 456 Oak Ave, City, State", "Experience : 8 years", "Mobile No : 234-567-8901", "Fees : $200"},
            {"Doctor Name : Dr. Sarah Johnson", "Hospital Address : 789 Pine Rd, City, State", "Experience : 12 years", "Mobile No : 345-678-9012", "Fees : $120"},
            {"Doctor Name : Dr. David Lee", "Hospital Address : 101 Maple Blvd, City, State", "Experience : 15 years", "Mobile No : 456-789-0123", "Fees : $180"},
            {"Doctor Name : Dr. Mia Rodriguez", "Hospital Address : 202 Birch Ln, City, State", "Experience : 7 years", "Mobile No : 567-890-1234", "Fees : $130"},
            {"Doctor Name : Dr. Mark Thompson", "Hospital Address : 303 Cedar Dr, City, State", "Experience : 9 years", "Mobile No : 678-901-2345", "Fees : $160"},
            {"Doctor Name : Dr. Linda Davis", "Hospital Address : 404 Spruce Ct, City, State", "Experience : 11 years", "Mobile No : 789-012-3456", "Fees : $140"},
            {"Doctor Name : Dr. James Williams", "Hospital Address : 505 Elm St, City, State", "Experience : 13 years", "Mobile No : 890-123-4567", "Fees : $175"},
            {"Doctor Name : Dr. Olivia Martinez", "Hospital Address : 606 Ash Ave, City, State", "Experience : 6 years", "Mobile No : 901-234-5678", "Fees : $110"},
            {"Doctor Name : Dr. Robert Brown", "Hospital Address : 707 Pinehill Rd, City, State", "Experience : 14 years", "Mobile No : 012-345-6789", "Fees : $190"},
            {"Doctor Name : Dr. Isabella Wilson", "Hospital Address : 808 Oakwood Blvd, City, State", "Experience : 5 years", "Mobile No : 123-456-7891", "Fees : $100"},
            {"Doctor Name : Dr. Daniel Taylor", "Hospital Address : 909 Maple St, City, State", "Experience : 16 years", "Mobile No : 234-567-8902", "Fees : $220"},
            {"Doctor Name : Dr. Charlotte Anderson", "Hospital Address : 1010 Cedar Rd, City, State", "Experience : 10 years", "Mobile No : 345-678-9013", "Fees : $155"},
            {"Doctor Name : Dr. Henry Scott", "Hospital Address : 1111 Birchwood Dr, City, State", "Experience : 4 years", "Mobile No : 456-789-0124", "Fees : $90"},
            {"Doctor Name : Dr. Ava Walker", "Hospital Address : 1212 Spruce Ave, City, State", "Experience : 18 years", "Mobile No : 567-890-1235", "Fees : $210"}
    };
    private String[][] doctor_details3 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main St, City, State", "Experience : 10 years", "Mobile No : 123-456-7890", "Fees : $150"},
            {"Doctor Name : Dr. Emily Clark", "Hospital Address : 456 Oak Ave, City, State", "Experience : 8 years", "Mobile No : 234-567-8901", "Fees : $200"},
            {"Doctor Name : Dr. Sarah Johnson", "Hospital Address : 789 Pine Rd, City, State", "Experience : 12 years", "Mobile No : 345-678-9012", "Fees : $120"},
            {"Doctor Name : Dr. David Lee", "Hospital Address : 101 Maple Blvd, City, State", "Experience : 15 years", "Mobile No : 456-789-0123", "Fees : $180"},
            {"Doctor Name : Dr. Mia Rodriguez", "Hospital Address : 202 Birch Ln, City, State", "Experience : 7 years", "Mobile No : 567-890-1234", "Fees : $130"},
            {"Doctor Name : Dr. Mark Thompson", "Hospital Address : 303 Cedar Dr, City, State", "Experience : 9 years", "Mobile No : 678-901-2345", "Fees : $160"},
            {"Doctor Name : Dr. Linda Davis", "Hospital Address : 404 Spruce Ct, City, State", "Experience : 11 years", "Mobile No : 789-012-3456", "Fees : $140"},
            {"Doctor Name : Dr. James Williams", "Hospital Address : 505 Elm St, City, State", "Experience : 13 years", "Mobile No : 890-123-4567", "Fees : $175"},
            {"Doctor Name : Dr. Olivia Martinez", "Hospital Address : 606 Ash Ave, City, State", "Experience : 6 years", "Mobile No : 901-234-5678", "Fees : $110"},
            {"Doctor Name : Dr. Robert Brown", "Hospital Address : 707 Pinehill Rd, City, State", "Experience : 14 years", "Mobile No : 012-345-6789", "Fees : $190"},
            {"Doctor Name : Dr. Isabella Wilson", "Hospital Address : 808 Oakwood Blvd, City, State", "Experience : 5 years", "Mobile No : 123-456-7891", "Fees : $100"},
            {"Doctor Name : Dr. Daniel Taylor", "Hospital Address : 909 Maple St, City, State", "Experience : 16 years", "Mobile No : 234-567-8902", "Fees : $220"},
            {"Doctor Name : Dr. Charlotte Anderson", "Hospital Address : 1010 Cedar Rd, City, State", "Experience : 10 years", "Mobile No : 345-678-9013", "Fees : $155"},
            {"Doctor Name : Dr. Henry Scott", "Hospital Address : 1111 Birchwood Dr, City, State", "Experience : 4 years", "Mobile No : 456-789-0124", "Fees : $90"},
            {"Doctor Name : Dr. Ava Walker", "Hospital Address : 1212 Spruce Ave, City, State", "Experience : 18 years", "Mobile No : 567-890-1235", "Fees : $210"}
    };
    private String[][] doctor_details4 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main St, City, State", "Experience : 10 years", "Mobile No : 123-456-7890", "Fees : $150"},
            {"Doctor Name : Dr. Emily Clark", "Hospital Address : 456 Oak Ave, City, State", "Experience : 8 years", "Mobile No : 234-567-8901", "Fees : $200"},
            {"Doctor Name : Dr. Sarah Johnson", "Hospital Address : 789 Pine Rd, City, State", "Experience : 12 years", "Mobile No : 345-678-9012", "Fees : $120"},
            {"Doctor Name : Dr. David Lee", "Hospital Address : 101 Maple Blvd, City, State", "Experience : 15 years", "Mobile No : 456-789-0123", "Fees : $180"},
            {"Doctor Name : Dr. Mia Rodriguez", "Hospital Address : 202 Birch Ln, City, State", "Experience : 7 years", "Mobile No : 567-890-1234", "Fees : $130"},
            {"Doctor Name : Dr. Mark Thompson", "Hospital Address : 303 Cedar Dr, City, State", "Experience : 9 years", "Mobile No : 678-901-2345", "Fees : $160"},
            {"Doctor Name : Dr. Linda Davis", "Hospital Address : 404 Spruce Ct, City, State", "Experience : 11 years", "Mobile No : 789-012-3456", "Fees : $140"},
            {"Doctor Name : Dr. James Williams", "Hospital Address : 505 Elm St, City, State", "Experience : 13 years", "Mobile No : 890-123-4567", "Fees : $175"},
            {"Doctor Name : Dr. Olivia Martinez", "Hospital Address : 606 Ash Ave, City, State", "Experience : 6 years", "Mobile No : 901-234-5678", "Fees : $110"},
            {"Doctor Name : Dr. Robert Brown", "Hospital Address : 707 Pinehill Rd, City, State", "Experience : 14 years", "Mobile No : 012-345-6789", "Fees : $190"},
            {"Doctor Name : Dr. Isabella Wilson", "Hospital Address : 808 Oakwood Blvd, City, State", "Experience : 5 years", "Mobile No : 123-456-7891", "Fees : $100"},
            {"Doctor Name : Dr. Daniel Taylor", "Hospital Address : 909 Maple St, City, State", "Experience : 16 years", "Mobile No : 234-567-8902", "Fees : $220"},
            {"Doctor Name : Dr. Charlotte Anderson", "Hospital Address : 1010 Cedar Rd, City, State", "Experience : 10 years", "Mobile No : 345-678-9013", "Fees : $155"},
            {"Doctor Name : Dr. Henry Scott", "Hospital Address : 1111 Birchwood Dr, City, State", "Experience : 4 years", "Mobile No : 456-789-0124", "Fees : $90"},
            {"Doctor Name : Dr. Ava Walker", "Hospital Address : 1212 Spruce Ave, City, State", "Experience : 18 years", "Mobile No : 567-890-1235", "Fees : $210"}
    };
    private String[][] doctor_details5 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main St, City, State", "Experience : 10 years", "Mobile No : 123-456-7890", "Fees : $150"},
            {"Doctor Name : Dr. Emily Clark", "Hospital Address : 456 Oak Ave, City, State", "Experience : 8 years", "Mobile No : 234-567-8901", "Fees : $200"},
            {"Doctor Name : Dr. Sarah Johnson", "Hospital Address : 789 Pine Rd, City, State", "Experience : 12 years", "Mobile No : 345-678-9012", "Fees : $120"},
            {"Doctor Name : Dr. David Lee", "Hospital Address : 101 Maple Blvd, City, State", "Experience : 15 years", "Mobile No : 456-789-0123", "Fees : $180"},
            {"Doctor Name : Dr. Mia Rodriguez", "Hospital Address : 202 Birch Ln, City, State", "Experience : 7 years", "Mobile No : 567-890-1234", "Fees : $130"},
            {"Doctor Name : Dr. Mark Thompson", "Hospital Address : 303 Cedar Dr, City, State", "Experience : 9 years", "Mobile No : 678-901-2345", "Fees : $160"},
            {"Doctor Name : Dr. Linda Davis", "Hospital Address : 404 Spruce Ct, City, State", "Experience : 11 years", "Mobile No : 789-012-3456", "Fees : $140"},
            {"Doctor Name : Dr. James Williams", "Hospital Address : 505 Elm St, City, State", "Experience : 13 years", "Mobile No : 890-123-4567", "Fees : $175"},
            {"Doctor Name : Dr. Olivia Martinez", "Hospital Address : 606 Ash Ave, City, State", "Experience : 6 years", "Mobile No : 901-234-5678", "Fees : $110"},
            {"Doctor Name : Dr. Robert Brown", "Hospital Address : 707 Pinehill Rd, City, State", "Experience : 14 years", "Mobile No : 012-345-6789", "Fees : $190"},
            {"Doctor Name : Dr. Isabella Wilson", "Hospital Address : 808 Oakwood Blvd, City, State", "Experience : 5 years", "Mobile No : 123-456-7891", "Fees : $100"},
            {"Doctor Name : Dr. Daniel Taylor", "Hospital Address : 909 Maple St, City, State", "Experience : 16 years", "Mobile No : 234-567-8902", "Fees : $220"},
            {"Doctor Name : Dr. Charlotte Anderson", "Hospital Address : 1010 Cedar Rd, City, State", "Experience : 10 years", "Mobile No : 345-678-9013", "Fees : $155"},
            {"Doctor Name : Dr. Henry Scott", "Hospital Address : 1111 Birchwood Dr, City, State", "Experience : 4 years", "Mobile No : 456-789-0124", "Fees : $90"},
            {"Doctor Name : Dr. Ava Walker", "Hospital Address : 1212 Spruce Ave, City, State", "Experience : 18 years", "Mobile No : 567-890-1235", "Fees : $210"}
    };
    private String[][] doctor_details6 = {
            {"Doctor Name : Dr. John Smith", "Hospital Address : 123 Main St, City, State", "Experience : 10 years", "Mobile No : 123-456-7890", "Fees : $150"},
            {"Doctor Name : Dr. Emily Clark", "Hospital Address : 456 Oak Ave, City, State", "Experience : 8 years", "Mobile No : 234-567-8901", "Fees : $200"},
            {"Doctor Name : Dr. Sarah Johnson", "Hospital Address : 789 Pine Rd, City, State", "Experience : 12 years", "Mobile No : 345-678-9012", "Fees : $120"},
            {"Doctor Name : Dr. David Lee", "Hospital Address : 101 Maple Blvd, City, State", "Experience : 15 years", "Mobile No : 456-789-0123", "Fees : $180"},
            {"Doctor Name : Dr. Mia Rodriguez", "Hospital Address : 202 Birch Ln, City, State", "Experience : 7 years", "Mobile No : 567-890-1234", "Fees : $130"},
            {"Doctor Name : Dr. Mark Thompson", "Hospital Address : 303 Cedar Dr, City, State", "Experience : 9 years", "Mobile No : 678-901-2345", "Fees : $160"},
            {"Doctor Name : Dr. Linda Davis", "Hospital Address : 404 Spruce Ct, City, State", "Experience : 11 years", "Mobile No : 789-012-3456", "Fees : $140"},
            {"Doctor Name : Dr. James Williams", "Hospital Address : 505 Elm St, City, State", "Experience : 13 years", "Mobile No : 890-123-4567", "Fees : $175"},
            {"Doctor Name : Dr. Olivia Martinez", "Hospital Address : 606 Ash Ave, City, State", "Experience : 6 years", "Mobile No : 901-234-5678", "Fees : $110"},
            {"Doctor Name : Dr. Robert Brown", "Hospital Address : 707 Pinehill Rd, City, State", "Experience : 14 years", "Mobile No : 012-345-6789", "Fees : $190"},
            {"Doctor Name : Dr. Isabella Wilson", "Hospital Address : 808 Oakwood Blvd, City, State", "Experience : 5 years", "Mobile No : 123-456-7891", "Fees : $100"},
            {"Doctor Name : Dr. Daniel Taylor", "Hospital Address : 909 Maple St, City, State", "Experience : 16 years", "Mobile No : 234-567-8902", "Fees : $220"},
            {"Doctor Name : Dr. Charlotte Anderson", "Hospital Address : 1010 Cedar Rd, City, State", "Experience : 10 years", "Mobile No : 345-678-9013", "Fees : $155"},
            {"Doctor Name : Dr. Henry Scott", "Hospital Address : 1111 Birchwood Dr, City, State", "Experience : 4 years", "Mobile No : 456-789-0124", "Fees : $90"},
            {"Doctor Name : Dr. Ava Walker", "Hospital Address : 1212 Spruce Ave, City, State", "Experience : 18 years", "Mobile No : 567-890-1235", "Fees : $210"}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        // Handle system window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up exit button
        Button exit = findViewById(R.id.btnBack);
        exit.setOnClickListener(view -> startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class)));
Button book = findViewById(R.id.btnBook);
book.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(FindDoctorActivity.this,BookAppointmentActivity.class));

    }
});
        // Set up each department's card view click listener
        setCardClickListener(R.id.cardCardiologist, doctor_details1);
        setCardClickListener(R.id.cardNeurologist, doctor_details2);
        setCardClickListener(R.id.cardDentist, doctor_details3);
        setCardClickListener(R.id.cardOrthopedic, doctor_details4);
        setCardClickListener(R.id.cardPediatrician, doctor_details5);
        setCardClickListener(R.id.cardDermatologist, doctor_details6);
        // Add other departments similarly...
    }

    private void setCardClickListener(int cardId, String[][] doctorDetails) {
        CardView card = findViewById(cardId);
        card.setOnClickListener(view -> {
            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
            it.putExtra("doctor_details", doctorDetails); // Pass the doctor details
            startActivity(it);
        });
    }
}
