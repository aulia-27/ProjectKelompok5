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
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectmobileapplaundry.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {

    EditText editNama, editEmailRegister, editPasswordRegister, editRePasswordRegister;
    Button btnRegisterAkun;
    TextView txtLogin;
    ProgressDialog progresDialog;
    FirebaseAuth mAuth;
    ImageView imgBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editNama = findViewById(R.id.editNamaRegister);
        editEmailRegister = findViewById(R.id.editEmailRegister);
        editPasswordRegister = findViewById(R.id.editPasswordRegister);
        editRePasswordRegister = findViewById(R.id.editConfPassword);
        btnRegisterAkun = findViewById(R.id.btnSingUp);
        txtLogin = findViewById(R.id.txtLogin);
        setLayoutRegister();
    }

    private void setLayoutRegister() {

        //extract the data from the propeties

        String nama = editNama.getText().toString();
        String email = editEmailRegister.getText().toString();
        String password = editPasswordRegister.getText().toString();
        String rePassword = editRePasswordRegister.getText().toString();

        txtLogin.setOnClickListener(new View.OnClickListener() {
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
                if (nama.isEmpty()){
                    editNama.setError("Silakan Isi Nama");
                    return;
                } if (email.isEmpty()){
                    editEmailRegister.setError("Silakan Isi Email");
                    return;
                } if (password.isEmpty()){
                    editPasswordRegister.setError("Silakan Isi Password");
                    return;
                } if (rePassword.isEmpty()){
                    editRePasswordRegister.setError("Silakan isi Re Password");
                    return;
                } if (nama.isEmpty() && email.isEmpty() && email.isEmpty() && password.isEmpty() && rePassword.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Silakan Isi Semua Data !", Toast.LENGTH_LONG).show();
                }
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