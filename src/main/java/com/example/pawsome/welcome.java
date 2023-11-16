package com.example.pawsome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity {
    Button welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        welcome = findViewById(R.id.welcome_btn);
        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ongoing_timers.class);
                startActivity(intent);
            }
        });
    }
}