package com.orn.gic_task;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.orn.gic_task_java.R;

import java.util.Random;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etContact, etEmail, etAddress, etCity, etPincode, etPassword, etOTP;
    Button btnRegister, btnVerifyOTP;
    TextView tvLogin;

    private String generatedOTP; // Store OTP for verification

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.orn.gic_task_java.R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etContact = findViewById(R.id.etContact);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        etPincode = findViewById(R.id.etPincode);
        etPassword = findViewById(R.id.etPassword);
        etOTP = findViewById(R.id.etOTP); // OTP Field
        btnRegister = findViewById(R.id.btnRegister);
        btnVerifyOTP = findViewById(R.id.btnVerifyOTP); // Verify OTP Button
        tvLogin = findViewById(R.id.tvLogin);

        btnRegister.setOnClickListener(v -> registerUser());
        btnVerifyOTP.setOnClickListener(v -> verifyOTP());

        tvLogin.setOnClickListener(v ->
                Toast.makeText(RegisterActivity.this, "Redirecting to Login...", Toast.LENGTH_SHORT).show()
        );
    }

    private void registerUser() {
        String name = etName.getText().toString().trim();
        String contact = etContact.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        String pincode = etPincode.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Input Validation
        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required!");
            etName.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(contact) || contact.length() != 10) {
            etContact.setError("Valid Contact Number required!");
            etContact.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email) || !email.contains("@")) {
            etEmail.setError("Valid Email required!");
            etEmail.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            etAddress.setError("Address is required!");
            etAddress.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(city)) {
            etCity.setError("City is required!");
            etCity.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(pincode) || pincode.length() != 6) {
            etPincode.setError("Valid Pincode required!");
            etPincode.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password) || password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters!");
            etPassword.requestFocus();
            return;
        }

        // ✅ Generate OTP after validation
        generatedOTP = generateOTP();
        Toast.makeText(this, "Your OTP: " + generatedOTP, Toast.LENGTH_LONG).show(); // Display OTP for demo

        // Show OTP input & verification button
        etOTP.setVisibility(View.VISIBLE);
        btnVerifyOTP.setVisibility(View.VISIBLE);
    }

    // ✅ Generate a 6-digit OTP
    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generates a 6-digit number
        return String.valueOf(otp);
    }

    // ✅ Verify the entered OTP
    private void verifyOTP() {
        String enteredOTP = etOTP.getText().toString().trim();
        if (TextUtils.isEmpty(enteredOTP)) {
            etOTP.setError("Please enter the OTP!");
            etOTP.requestFocus();
            return;
        }

        if (enteredOTP.equals(generatedOTP)) {
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_LONG).show();
            clearFields();
        } else {
            Toast.makeText(this, "Invalid OTP. Please try again!", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        etName.setText("");
        etContact.setText("");
        etEmail.setText("");
        etAddress.setText("");
        etCity.setText("");
        etPincode.setText("");
        etPassword.setText("");
        etOTP.setText("");
        etOTP.setVisibility(View.GONE);
        btnVerifyOTP.setVisibility(View.GONE);
    }
}
