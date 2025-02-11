package com.orn.gic_task;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orn.gic_task_java.R;

public class AddToCartActivity extends AppCompatActivity {

    EditText etQuantity;
    Button btnAddToCart;
    DatabaseReference databaseCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.orn.gic_task_java.R.layout.activity_add_to_cart);

        etQuantity = findViewById(R.id.etQuantity);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        String productId = getIntent().getStringExtra("productId");
        String productName = getIntent().getStringExtra("productName");
        double price = getIntent().getDoubleExtra("price", 0);

        databaseCart = FirebaseDatabase.getInstance().getReference("cart");

        btnAddToCart.setOnClickListener(v -> {
            int quantity = Integer.parseInt(etQuantity.getText().toString());
            CartItem cartItem = new CartItem(productId, productName, quantity, price);

            databaseCart.child(productId).setValue(cartItem)
                    .addOnSuccessListener(aVoid -> Toast.makeText(this, "Added to Cart!", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e -> Toast.makeText(this, "Failed to add to cart.", Toast.LENGTH_SHORT).show());
        });
    }
}
