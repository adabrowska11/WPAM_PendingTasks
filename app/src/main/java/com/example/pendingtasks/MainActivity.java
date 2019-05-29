package com.example.pendingtasks;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button buttonLogIn;
    TextView textViewSignUp;
    EditText editTextPasswordLogin;
    EditText editTextEmailLogin;
    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogIn = findViewById(R.id.buttonLogin);
        textViewSignUp = findViewById(R.id.textViewSignIn);
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin);
        editTextEmailLogin = findViewById(R.id.editTextEmailLogin);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            finish();
            Intent intent = new Intent(getApplicationContext(), Tasks.class);
            startActivity(intent);
        }
    }

    public void logowanie(View view) {
        logIn();
    }

    public void rejestracja(View view) {
        Intent intent = new Intent(getApplicationContext(), Rejestracja.class);
        startActivity(intent);
    }

    public void logIn() {
        String email = editTextEmailLogin.getText().toString().trim();
        String password = editTextPasswordLogin.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {

            Toast.makeText(this, "Wpisz e-mail", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {

            Toast.makeText(this, "Wpisz hasło", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {

            Toast.makeText(this, "Hasło musi zawierać przynajmniej 6 znaków", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Log in...");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), Tasks.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Niepoprawne dane logowania", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
