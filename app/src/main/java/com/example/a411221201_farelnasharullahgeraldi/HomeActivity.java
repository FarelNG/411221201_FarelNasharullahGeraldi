package com.example.a411221201_farelnasharullahgeraldi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {



    private ListView listViewProducts;
    private Button btnProfile; // Tambahkan tombol profil

    Button btnProduct;
    Button btnCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Pastikan layout ini ada

        listViewProducts = findViewById(R.id.listViewProducts);
        btnProfile = findViewById(R.id.btnProfile); // Inisialisasi tombol profil

        // Daftar produk sederhana
        String[] products = {
                "Produk 1 - Rp 100.000",
                "Produk 2 - Rp 200.000",
                "Produk 3 - Rp 300.000",
                "Produk 4 - Rp 400.000",
                "Produk 5 - Rp 500.000"
        };

        // Mengatur adapter untuk ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        listViewProducts.setAdapter(adapter);

        // Aksi tombol profil
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigasi ke halaman ProfileActivity
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        btnProduct = findViewById(R.id.btnProduct);
        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProductActivity.class);
                startActivity(intent);

            btnCart = findViewById(R.id.btnCart);
            btnCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, CartActivity.class);
                    startActivity(intent);
                    }
                });

    }

})



;}}