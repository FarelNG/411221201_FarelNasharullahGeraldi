package com.example.a411221201_farelnasharullahgeraldi;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView listViewCart;
    private ArrayAdapter<String> adapter;
    private List<String> cartList;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        listViewCart = findViewById(R.id.listViewCart);

        // Ambil item keranjang dari SharedPreferences
        sharedPreferences = getSharedPreferences("CartPrefs", MODE_PRIVATE);
        String cartItems = sharedPreferences.getString("cartItems", "");

        // Pisahkan item berdasarkan ";"
        cartList = new ArrayList<>();
        if (!cartItems.isEmpty()) {
            cartList = new ArrayList<>(Arrays.asList(cartItems.split(";")));
        }

        // Tampilkan item di ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartList);
        listViewCart.setAdapter(adapter);

        // Set item click listener untuk menghapus item
        listViewCart.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = cartList.get(position);
            confirmRemoveItem(selectedItem, position);
        });
    }

    // Konfirmasi penghapusan item
    private void confirmRemoveItem(String item, int position) {
        new AlertDialog.Builder(this)
                .setTitle("Hapus Produk")
                .setMessage("Apakah Anda yakin ingin menghapus \"" + item + "\" dari keranjang?")
                .setPositiveButton("Ya", (dialog, which) -> removeItem(item, position))
                .setNegativeButton("Tidak", null)
                .show();
    }

    // Hapus item dari keranjang
    private void removeItem(String item, int position) {
        // Hapus dari list dan SharedPreferences
        cartList.remove(position);
        saveCartToPreferences();

        // Perbarui adapter
        adapter.notifyDataSetChanged();

        // Tampilkan pesan
        Toast.makeText(this, "\"" + item + "\" berhasil dihapus", Toast.LENGTH_SHORT).show();
    }

    // Simpan keranjang ke SharedPreferences
    private void saveCartToPreferences() {
        StringBuilder updatedCart = new StringBuilder();
        for (String product : cartList) {
            updatedCart.append(product).append(";");
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("cartItems", updatedCart.toString());
        editor.apply();
    }
}
