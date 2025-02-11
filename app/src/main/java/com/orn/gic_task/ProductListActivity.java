package com.orn.gic_task;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.orn.gic_task_java.R;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    ListView listViewProducts;
    List<Product> productList;
    DatabaseReference databaseProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.orn.gic_task_java.R.layout.activity_product_list);

        listViewProducts = findViewById(R.id.listViewProducts);
        productList = new ArrayList<>();
        databaseProducts = FirebaseDatabase.getInstance().getReference("products");

        databaseProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                productList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Product product = postSnapshot.getValue(Product.class);
                    productList.add(product);
                }
                List<String> productNames = new ArrayList<>();
                for (Product p : productList) {
                    productNames.add(p.getProductName() + " - ₹" + p.getPrice());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductListActivity.this, android.R.layout.simple_list_item_1, productNames);
                listViewProducts.setAdapter(adapter);

                listViewProducts.setOnItemClickListener((parent, view, position, id) -> {
                    Product selectedProduct = productList.get(position);
                    Intent intent = new Intent(ProductListActivity.this, AddToCartActivity.class);
                    intent.putExtra("productId", selectedProduct.getProductId());
                    intent.putExtra("productName", selectedProduct.getProductName());
                    intent.putExtra("price", selectedProduct.getPrice());
                    startActivity(intent);
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(ProductListActivity.this, "Failed to load products.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
