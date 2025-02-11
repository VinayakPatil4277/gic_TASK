package com.orn.gic_task;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orn.gic_task_java.R;

import java.util.UUID;

public class AddProductActivity extends AppCompatActivity {

    EditText etProductName, etDescription, etPrice;
    Button btnAddProduct;
    DatabaseReference databaseProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.orn.gic_task_java.R.layout.activity_add_product);

        etProductName = findViewById(R.id.etProductName);
        etDescription = findViewById(R.id.etDescription);
        etPrice = findViewById(R.id.etPrice);
        btnAddProduct = findViewById(R.id.btnAddProduct);

        databaseProducts = FirebaseDatabase.getInstance().getReference("products");

        btnAddProduct.setOnClickListener(view -> addProduct());
    }

    private void addProduct() {
        String productName = etProductName.getText().toString().trim();
        String description = etDescription.getText().toString().trim();
        String priceText = etPrice.getText().toString().trim();

        if (TextUtils.isEmpty(productName) || TextUtils.isEmpty(description) || TextUtils.isEmpty(priceText)) {
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return;
        }

        double price = Double.parseDouble(priceText);
        String productId = UUID.randomUUID().toString();

        Product product = new Product(productId, productName, description, price, "");

        databaseProducts.child(productId).setValue(product)
                .addOnSuccessListener(aVoid -> Toast.makeText(this, "Product added successfully!", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(this, "Failed to add product.", Toast.LENGTH_SHORT).show());
    }
}
