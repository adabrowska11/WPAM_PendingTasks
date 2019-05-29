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
import com.google.firebase.auth.FirebaseUser;

public class Rejestracja extends AppCompatActivity {

    public FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    EditText editTextEmailRegister;
    EditText editTextPasswordRegister;
    TextView textViewRegisterUser;
    TextView textViewSignIn;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        editTextEmailRegister = findViewById(R.id.editTextEmailRegister);
        editTextPasswordRegister = findViewById(R.id.editTextPasswordRegister);
        textViewRegisterUser = findViewById(R.id.textViewUserRegister);
        textViewSignIn = findViewById(R.id.textViewSignIn);
        buttonRegister = findViewById(R.id.buttonRegister);

        if(mAuth.getCurrentUser() != null) {
            finish();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

    public void LogIn(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


    public void registerUser(View view) {
        String email = editTextEmailRegister.getText().toString().trim();
        String password = editTextPasswordRegister.getText().toString().trim();
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
        progressDialog.setMessage("Register..");
        progressDialog.show();


        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            progressDialog.dismiss();
            String LOG_TAG = null;
            if (task.isSuccessful()) {
                finish();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                FirebaseUser user = mAuth.getCurrentUser();
            } else {
                Toast.makeText(getApplicationContext(), "Rejestracja nie powiodła sie. Spróbuj ponownie",
                        Toast.LENGTH_SHORT).show();
            }
        }
    });
}
}

