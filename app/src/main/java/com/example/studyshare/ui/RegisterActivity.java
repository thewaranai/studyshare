package com.example.studyshare.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyshare.R;
import com.example.studyshare.data.AppDatabase;
import com.example.studyshare.data.entity.User;

public class RegisterActivity extends AppCompatActivity {

    EditText loginEt, emailEt, passEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginEt = findViewById(R.id.loginEt);
        emailEt = findViewById(R.id.emailEt);
        passEt = findViewById(R.id.passEt);
        TextView adminSecretTitle = findViewById(R.id.adminSecretTitle);

        adminSecretTitle.setOnLongClickListener(v -> {
            String email = emailEt.getText().toString().trim();

            if (email.isEmpty()) {
                Toast.makeText(this, "Введите email пользователя", Toast.LENGTH_SHORT).show();
                return true;
            }

            AppDatabase db = AppDatabase.getInstance(this);
            db.userDao().updateUserRole(email, "MODERATOR");

            Toast.makeText(this, "Пользователь назначен MODERATOR", Toast.LENGTH_LONG).show();
            return true;
        });

        findViewById(R.id.registerBtn).setOnClickListener(v -> {
            String login = loginEt.getText().toString();
            String email = emailEt.getText().toString();
            String pass = passEt.getText().toString();

            if (login.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                return;
            }

            User user = new User(login, pass, email, "USER");
            AppDatabase.getInstance(this).userDao().insert(user);

            Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
