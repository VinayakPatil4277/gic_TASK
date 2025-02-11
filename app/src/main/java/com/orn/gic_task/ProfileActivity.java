package com.orn.gic_task;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.orn.gic_task_java.R;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvContact, tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvContact = findViewById(R.id.tvContact);
        tvAddress = findViewById(R.id.tvAddress);

        // Dummy data (replace this with Firebase data later)
        tvName.setText("Name: Vinayak Patil");
        tvEmail.setText("Email: patildvinayak@gmail.com");
        tvContact.setText("Contact: +91-9172814004");
        tvAddress.setText("Address: Pune, Maharashtra");
    }
}
