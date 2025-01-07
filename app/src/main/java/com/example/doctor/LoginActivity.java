package com.example.doctor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText edUserName, edPassword;
    private Button btnLogin;
    private TextView tvRegister;

    private Database db;

    private static final String SHARED_PREFS_NAME = "shared_prefs";
    private static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Database
        db = new Database(this);

        // Initialize UI elements
        edUserName = findViewById(R.id.LoginUserName);
        edPassword = findViewById(R.id.Loginpassword);
        btnLogin = findViewById(R.id.loginButton);
        tvRegister = findViewById(R.id.textViewNewUser);

        // Login Button Click Listener
        btnLogin.setOnClickListener(view -> validateAndLogin());

        // Navigate to Register Activity
        tvRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void validateAndLogin() {
        String username = edUserName.getText().toString().trim();
        String password = edPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showToast("Both fields are required");
            return;
        }

        if (db.login(username, password)) {
            saveUserSession(username);
            showToast("Login Successful");

            // Navigate to Home Activity
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            showToast("Invalid username or password");
        }
    }

    private void saveUserSession(String username) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
