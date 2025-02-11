package com.orn.gic_task;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.orn.gic_task_java.R;

public class DashboardActivity extends AppCompatActivity {

    TextView tvWelcome;
    Button btnViewProducts, btnProfile, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvWelcome = findViewById(R.id.tvWelcome);
        btnViewProducts = findViewById(R.id.btnViewProducts);
        btnProfile = findViewById(R.id.btnProfile);
        btnLogout = findViewById(R.id.btnLogout);

        // Get user's contact passed from LoginActivity
        String userContact = getIntent().getStringExtra("contact");
        tvWelcome.setText("Welcome, " + userContact);

        // View Products button click
        btnViewProducts.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ProductListActivity.class);
            startActivity(intent);
        });

        // Profile button click
        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // Logout button click
        btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut(); // Sign out from Firebase
            startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
            finish();
        });
    }
}
