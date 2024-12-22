package com.example.inventoryapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText editTextForgotUsername, editTextForgotPassword;
    private Button buttonResetPassword;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Initialize UI components
        editTextForgotUsername = findViewById(R.id.editTextForgotUsername);
        editTextForgotPassword = findViewById(R.id.editTextForgotPassword);
        buttonResetPassword = findViewById(R.id.buttonResetPassword);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Handle Reset Password button click
        buttonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextForgotUsername.getText().toString().trim();
                String newPassword = editTextForgotPassword.getText().toString().trim();

                if (username.isEmpty() || newPassword.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (databaseHelper.validateUser(username, newPassword)) {
                    // Reset password
                    boolean success = databaseHelper.updatePassword(username, newPassword);
                    if (success) {
                        Toast.makeText(ForgotPasswordActivity.this, "Password Reset Successful", Toast.LENGTH_SHORT).show();
                        finish(); // Go back to LoginActivity
                    } else {
                        Toast.makeText(ForgotPasswordActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
