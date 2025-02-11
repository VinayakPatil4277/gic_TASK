package com.orn.gic_task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orn.gic_task_java.R;

import java.util.HashMap;
import java.util.Map;

public class CheckoutActivity extends AppCompatActivity {

    EditText edtAddress, edtContact, edtDeliveryDate;
    RadioGroup paymentGroup;
    Button btnPlaceOrder;
    DatabaseReference ordersRef;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.orn.gic_task_java.R.layout.activity_checkout);

        edtAddress = findViewById(R.id.edtAddress);
        edtContact = findViewById(R.id.edtContact);
        edtDeliveryDate = findViewById(R.id.edtDeliveryDate);
        paymentGroup = findViewById(R.id.paymentGroup);
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);

        mAuth = FirebaseAuth.getInstance();
        ordersRef = FirebaseDatabase.getInstance().getReference("Orders");

        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
    }

    private void placeOrder() {
        String address = edtAddress.getText().toString();
        String contact = edtContact.getText().toString();
        String deliveryDate = edtDeliveryDate.getText().toString();

        int selectedPaymentId = paymentGroup.getCheckedRadioButtonId();
        RadioButton selectedPayment = findViewById(selectedPaymentId);
        String paymentMethod = selectedPayment.getText().toString();

        if (address.isEmpty() || contact.isEmpty() || deliveryDate.isEmpty() || paymentMethod.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        String userId = mAuth.getCurrentUser().getUid();
        String orderId = ordersRef.push().getKey();

        Map<String, Object> orderData = new HashMap<>();
        orderData.put("userId", userId);
        orderData.put("address", address);
        orderData.put("contact", contact);
        orderData.put("deliveryDate", deliveryDate);
        orderData.put("paymentMethod", paymentMethod);
        orderData.put("status", "Pending");

        ordersRef.child(orderId).setValue(orderData)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(CheckoutActivity.this, "Order placed successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CheckoutActivity.this, DashboardActivity.class));
                        finish();
                    } else {
                        Toast.makeText(CheckoutActivity.this, "Failed to place order!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
