package com.example.projectmobileapplaundry.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projectmobileapplaundry.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {

    private EditText editNama, editEmailRegister, editHpRegister, editPasswordRegister, editRePasswordRegister;
    private Button btnRegisterAkun, btnBackLogin;
    private ProgressDialog progresDialog;
    private FirebaseAuth mAuth;
    private ImageView imgBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setLayoutRegister();
    }

    private void setLayoutRegister() {
        editNama = findViewById(R.id.editNama);
//        editUsernameRegister = findViewById(R.id.editUsernameRegister);
        editEmailRegister = findViewById(R.id.editEmailRegister);
//        editHpRegister = findViewById(R.id.editHpRegister);
        editPasswordRegister = findViewById(R.id.editPasswordRegister);
        editRePasswordRegister = findViewById(R.id.editRePasswordRegister);
        btnRegisterAkun = findViewById(R.id.btnRegisterAkun);
//        btnBackLogin = findViewById(R.id.btnBackLogin);
        imgBackLogin = findViewById(R.id.imgBackToLogin);

        imgBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentImgBackLogin = new Intent(new Intent(RegisterActivity.this, LoginActivity.class));
                startActivity(intentImgBackLogin);
            }
        });

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        progresDialog = new ProgressDialog(RegisterActivity.this);
        progresDialog.setTitle("LOADING");
        progresDialog.setMessage("Silakan  Tunggu");
        progresDialog.setCancelable(false);

        btnRegisterAkun.setOnClickListener(view -> {
            if (editNama.getText().toString().length()>0
//                    && editUsernameRegister.getText().toString().length() > 0
                    && editEmailRegister.getText().toString().length() >  0
                    && editPasswordRegister.getText().toString().length() > 0
                    && editRePasswordRegister.getText().toString().length() > 0) {
                if (editPasswordRegister.getText().toString().equals(editRePasswordRegister.getText().toString())){
                    if (editPasswordRegister.getText().toString().length() > 5 && editRePasswordRegister.getText().toString().length() > 5) {
                        register(
                                editNama.getText().toString(),
                                editEmailRegister.getText().toString(),
                                editPasswordRegister.getText().toString()
                        );
                    } else {
                        Toast.makeText(getApplicationContext(), "Silakan Masukan Password Minimal  6 Kata!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Silakan Masukan Password Yang Sama!", Toast.LENGTH_LONG).show();
                }

            }
            else {
                Toast.makeText(getApplicationContext(), "Silakan Isi Semua Data !", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void register(String editNama, String editEmailRegister, String editPasswordRegister) {
        progresDialog.show();
        mAuth.createUserWithEmailAndPassword(editEmailRegister, editPasswordRegister).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser != null) {
                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(editNama)
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                reload();
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "Maaf, Register Anda Gagal !", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}