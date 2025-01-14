package com.example.a411221201_farelnasharullahgeraldi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {

    private ListView listViewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        listViewProducts = findViewById(R.id.listViewProducts);


        String[] products = {
                "Produk 1 - Rp 100.000",
                "Produk 2 - Rp 200.000",
                "Produk 3 - Rp 300.000",
                "Produk 4 - Rp 400.000",
                "Produk 5 - Rp 500.000",
                "Produk 6 - Rp 600.000",
                "Produk 7 - Rp 700.000",
                "Produk 8 - Rp 800.000"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        listViewProducts.setAdapter(adapter);

        listViewProducts.setOnItemClickListener((parent, view, position, id) -> {
            String selectedProduct = products[position];
            addToCart(selectedProduct);
        });
    }
    private void addToCart(String product) {

        SharedPreferences sharedPreferences = getSharedPreferences("CartPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        String cartItems = sharedPreferences.getString("cartItems", "");
        cartItems += product + ";";
        editor.putString("cartItems", cartItems);
        editor.apply();


        Toast.makeText(this, product + " ditambahkan ke keranjang", Toast.LENGTH_SHORT).show();
    }
}
