package com.example.android.patternlocktesting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // loading is given
                SharedPreferences sharedPreferences = getSharedPreferences("PREFS", 0);
                String password = sharedPreferences.getString("password", "0");
                Intent intent;
                if (password.equals("0")) {
                    // Intent to navigate to Create Password Screen
                    intent = new Intent(getApplicationContext(), CreatePasswordActivity.class);
                } else {
                    // Intent to navigate to Input Password Screen
                    intent = new Intent(getApplicationContext(), InputPasswordActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 200);
    }
}