package com.example.studyshare.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyshare.R;
import com.example.studyshare.data.AppDatabase;
import com.example.studyshare.data.entity.User;
import com.example.studyshare.util.SessionManager;

public class LoginActivity extends AppCompatActivity {

    EditText loginEt, passEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEt = findViewById(R.id.loginEt);
        passEt = findViewById(R.id.passEt);

        findViewById(R.id.loginBtn).setOnClickListener(v -> {
            User user = AppDatabase.getInstance(this)
                    .userDao()
                    .login(loginEt.getText().toString(),
                            passEt.getText().toString());

            if (user != null) {
                SessionManager.setUser(this, user.id, user.role);
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.registerBtn).setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class)));
    }
}
