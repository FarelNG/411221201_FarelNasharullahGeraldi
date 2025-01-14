package com.example.a411221201_farelnasharullahgeraldi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();


                if (username.equals("admin") && password.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, com.example.a411221201_farelnasharullahgeraldi.HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}