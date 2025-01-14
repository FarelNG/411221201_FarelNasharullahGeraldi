package com.example.a411221201_farelnasharullahgeraldi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private TextView tvName, tvEmail, tvPhone, tvAddress;
    private Button btnLogout, btnEditProfile;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvAddress = findViewById(R.id.tvAddress);
        btnLogout = findViewById(R.id.btnLogout);
        btnEditProfile = findViewById(R.id.btnEditProfile);


        sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);


        loadProfile();


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });


        btnEditProfile.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
            startActivity(intent);
        });
    }


    private void loadProfile() {

        String name = sharedPreferences.getString("name", "Nama belum diatur");
        String email = sharedPreferences.getString("email", "Email belum diatur");
        String phone = sharedPreferences.getString("phone", "Telepon belum diatur");
        String address = sharedPreferences.getString("address", "Alamat belum diatur");


        tvName.setText(name);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvAddress.setText(address);
    }
}
