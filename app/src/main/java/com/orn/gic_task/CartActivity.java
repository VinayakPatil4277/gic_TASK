package com.orn.gic_task;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.orn.gic_task_java.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    ListView listViewCart;
    DatabaseReference databaseCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.orn.gic_task_java.R.layout.activity_cart);

        listViewCart = findViewById(R.id.listViewCart);
        databaseCart = FirebaseDatabase.getInstance().getReference("cart");

        databaseCart.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<String> cartItems = new ArrayList<>();
                for (DataSnapshot cartSnapshot : snapshot.getChildren()) {
                    CartItem item = cartSnapshot.getValue(CartItem.class);
                    cartItems.add(item.getProductName() + " - Qty: " + item.getQuantity() + " - ₹" + item.getTotalPrice());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(CartActivity.this, android.R.layout.simple_list_item_1, cartItems);
                listViewCart.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle database error
            }
        });
    }
}
