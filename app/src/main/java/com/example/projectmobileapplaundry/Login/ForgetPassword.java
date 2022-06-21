package com.example.projectmobileapplaundry.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.projectmobileapplaundry.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    EditText editEmail;
    Button btnForgetPassword;
    ProgressBar progressBar;

    String email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        editEmail = findViewById(R.id.editEmailAddress);
        btnForgetPassword = findViewById(R.id.btnResetPassword);
        btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetPassword();
            }
        });
    }

    private void forgetPassword() {
        email = editEmail.getText().toString().trim();
//        if (email.isEmpty()){
//            editEmail.setText("Silakan Isi Email");
//            editEmail.requestFocus();
//            return;
//        }
//
//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            editEmail.setError("Silakan Isi Email yang valid");
//            editEmail.requestFocus();
//            return;
//        }

        if (email.isEmpty()){
            Toast.makeText(ForgetPassword.this, "Silakan Isi email  Anda", Toast.LENGTH_LONG).show();
        } else {
            prosesForgetPassword();
        }

//        progressBar.setVisibility(View.VISIBLE);
//        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(ForgetPassword.this, "Silakan Cek Email Anda Untuk Reset Password", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(ForgetPassword.this, "Terjadi Kelasahan, Silakan Coba Lagi", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }

    private void prosesForgetPassword() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgetPassword.this, "Silakan Cek Email Anda", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ForgetPassword.this, LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(ForgetPassword.this, "Error : " +task.getException() , Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}