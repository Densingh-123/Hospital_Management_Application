package com.example.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText edUsername, edEmail, edPassword, edConfirmPassword;
    private Button btnRegister;
    private TextView tvLogin;

    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Database
        db = new Database(this);

        // Initialize UI elements
        edUsername = findViewById(R.id.registerUsername);
        edEmail = findViewById(R.id.registerEmail);
        edPassword = findViewById(R.id.registerPassword);
        edConfirmPassword = findViewById(R.id.registerConfirmPassword);
        btnRegister = findViewById(R.id.registerButton);
        tvLogin = findViewById(R.id.loginTextView);

        // Login Text Click Listener
        tvLogin.setOnClickListener(view -> navigateToLogin());

        // Register Button Click Listener
        btnRegister.setOnClickListener(view -> validateAndRegister());
    }

    private void validateAndRegister() {
        String username = edUsername.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        String password = edPassword.getText().toString().trim();
        String confirmPassword = edConfirmPassword.getText().toString().trim();

        // Perform input validations
        if (!isValidUsername(username)) return;
        if (!isValidEmail(email)) return;
        if (!isValidPassword(password, confirmPassword)) return;

        // Check for existing user
        if (db.isUserExists(username, email)) {
            showToast("Username or email already registered");
            return;
        }

        // Register user in the database
        db.register(username, email, password);
        showToast("Registration Successful");

        // Navigate to Login Activity
        navigateToLogin();
    }

    private boolean isValidUsername(String username) {
        if (username.isEmpty()) {
            showToast("Username is required");
            return false;
        }
        if (username.length() < 3) {
            showToast("Username must be at least 3 characters long");
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        if (email.isEmpty()) {
            showToast("Email is required");
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Enter a valid email address");
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password, String confirmPassword) {
        if (password.isEmpty()) {
            showToast("Password is required");
            return false;
        }
        if (password.length() < 6) {
            showToast("Password must be at least 6 characters long");
            return false;
        }
        if (confirmPassword.isEmpty()) {
            showToast("Please confirm your password");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            showToast("Passwords do not match");
            return false;
        }
        return true;
    }

    private void navigateToLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
