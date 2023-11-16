package com.example.pawsome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends AppCompatActivity {
    Button back;
    Button login;
    EditText username;
    String user_name1,device_id1;
    EditText deviceid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
            back = findViewById(R.id.back);
            login = findViewById(R.id.login);
            username = findViewById(R.id.username);
            deviceid = findViewById(R.id.device_id);

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent1);
                }
            });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user_name1 = username.getText().toString().trim();
                    device_id1 = deviceid.getText().toString().trim();
                    if (user_name1.isEmpty() && device_id1.isEmpty()) {
                        Toast.makeText(signin.this, "All fields required", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Intent intent1 = new Intent(signin.this, welcome.class);
                    startActivity(intent1);
                }
            });
        }
    }
}