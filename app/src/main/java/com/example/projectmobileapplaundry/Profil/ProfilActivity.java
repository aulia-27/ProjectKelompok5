package com.example.projectmobileapplaundry.Profil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectmobileapplaundry.Login.LoginActivity;
import com.example.projectmobileapplaundry.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfilActivity extends AppCompatActivity {
    EditText editNamaProfil, editNoHP, editAlamat;
    Button btnLogOut, btnEdit;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        logout();
    }

    private void logout() {
        btnLogOut = findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });
    }
}