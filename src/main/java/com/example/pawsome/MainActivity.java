package com.example.pawsome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signup;
    InternetPresence obj;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        obj = new InternetPresence();
        signup = findViewById(R.id.signup);

        if (InternetPresence.isInternetAvailable(this)){
            Toast.makeText(getApplicationContext(),"Internet available",Toast.LENGTH_SHORT).show();
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),signin.class);
                    startActivity(intent);
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),"Internet not available",Toast.LENGTH_SHORT).show();
        }
    }
}