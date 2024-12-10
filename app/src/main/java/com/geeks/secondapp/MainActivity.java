package com.geeks.secondapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setContentView(R.layout.activity_main);

        EditText emailField = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordField = findViewById(R.id.editTextTextPassword);
        Button loginButton = findViewById(R.id.button);
        TextView welcomeText = findViewById(R.id.textView2);
        TextView subtitleText = findViewById(R.id.textView3);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!emailField.getText().toString().isEmpty() && !passwordField.getText().toString().isEmpty()) {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        emailField.addTextChangedListener(textWatcher);
        passwordField.addTextChangedListener(textWatcher);


        loginButton.setOnClickListener(v -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();

            if (email.equals("admin") && password.equals("admin")) {

                Snackbar.make(v, "Вы успешно зарегистрировались", Snackbar.LENGTH_LONG).show();
                emailField.setVisibility(View.GONE);
                passwordField.setVisibility(View.GONE);
                loginButton.setVisibility(View.GONE);
                subtitleText.setVisibility(View.GONE);

                welcomeText.setText("Добро пожаловать!");
            } else {
                Snackbar.make(v, "Неправильный логин и пароль", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}