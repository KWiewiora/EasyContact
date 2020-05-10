package com.example.easycontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText loginGet, passwordGet;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //wyciagniecie z view loginu i hasła użytkownika, które wpisuję
        loginGet = findViewById(R.id.login);
        passwordGet = findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
        //inicjalizacja funkcji przycisku zaloguj
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = loginGet.getText().toString();
                String password = passwordGet.getText().toString();
                String type = "login";
                BackgroundWorker backgroundWorker = new BackgroundWorker(v.getContext());
                backgroundWorker.execute(type, username, password);
            }
        });
    }
}
