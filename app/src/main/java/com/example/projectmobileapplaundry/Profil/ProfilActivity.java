package com.example.projectmobileapplaundry.Profil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectmobileapplaundry.Login.LoginActivity;
import com.example.projectmobileapplaundry.MainActivity.MainActivity;
import com.example.projectmobileapplaundry.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class ProfilActivity extends AppCompatActivity {
//    EditText editNamaProfil, editNoHP, editAlamat,  editEmailRegiter;
//    TextView txtVerify, txtGantiPassword;
//    ImageView imgLogOut;
//    Button btnLogOut, btnEdit;
//    FirebaseUser firebaseUser;
//    DatabaseReference databaseReference;
//    String userID;
//    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
//        txtGantiPassword = findViewById(R.id.txtGantiPassword);
//        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//
//        txtGantiPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        layoutProfil();
////        verivyEmail();
//        logout();
    }

//    private void verivyEmail() {
//        txtVerify = findViewById(R.id.txtVerify);
//        if (firebaseAuth.getCurrentUser().isEmailVerified()){
//            txtVerify.setVisibility(View.VISIBLE);
//        }
//        txtVerify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                firebaseAuth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        Toast.makeText(ProfilActivity.this, "Verivication Email Send", Toast.LENGTH_LONG).show();
//                        txtVerify.setVisibility(View.GONE);
//                    }
//                });
//            }
//        });
//    }
//
//    private void layoutProfil() {
//        editNamaProfil = findViewById(R.id.editNamaProfil);
//        editNoHP = findViewById(R.id.editNoHpProfil);
//        editAlamat = findViewById(R.id.editAlamatProfil);
//        editEmailRegiter = findViewById(R.id.editEmailProfil);
//
//
//        if (firebaseUser !=  null){
//            editNamaProfil.setText(firebaseUser.getDisplayName());
//            editEmailRegiter.setText(firebaseUser.getEmail());
//        } else {
//            editNamaProfil.setText("");
//            editEmailRegiter.setText("");
//            editNoHP.setText("");
//        }
//
//    }
//
//    private void logout() {
//        btnLogOut = findViewById(R.id.imgLogOut);
//        btnLogOut.setOnClickListener(view -> {
//            FirebaseAuth.getInstance().signOut();
//            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//            finish();
//        });
//    }
}