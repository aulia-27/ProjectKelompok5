package com.example.projectmobileapplaundry.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.projectmobileapplaundry.Laundry.LaundryActivity;
import com.example.projectmobileapplaundry.MainActivity.Adapter.MenuAdapter;
import com.example.projectmobileapplaundry.MainActivity.Model.MenuModel;
import com.example.projectmobileapplaundry.Profil.ProfilActivity;
import com.example.projectmobileapplaundry.ProsesLaundry.ProsesLaundryActivity;
import com.example.projectmobileapplaundry.R;
import com.example.projectmobileapplaundry.MainActivity.Model.ProsesLaundryModel;
import com.example.projectmobileapplaundry.MainActivity.Model.RiwayatLaundryModel;
import com.example.projectmobileapplaundry.Riwayat.RiwayatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CardView cdLaundry, cdRiwayat, cdProses;
    TextView txtNama, txtSemuaRiwayat, txtSemuaProsesLaundry;
    ImageView imgProfile;
    RecyclerView rvProsesLaundry, rvRiwayatLaundry, rvMenuUtama;
    GridLayoutManager glmRiwayatLaundry, glmProsesLaundry;
    private FirebaseUser firebaseUser;
    private List<ProsesLaundryModel> modelProsesLaundries = new ArrayList<>();
    private List<RiwayatLaundryModel> modelRiwayatLaundries = new ArrayList<>();
    private List<MenuModel> modelMenuList = new ArrayList<>();
    MenuModel modelMenu;
    MenuAdapter menuAdapter;
//    MainAdapterProsesLaundry mainAdapterPL;
//    MainAdapterRiwayatLaundry mainAdapterRL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cdLaundry = findViewById(R.id.cdLaundy);
        cdRiwayat = findViewById(R.id.cdRiwayat);
        cdProses = findViewById(R.id.cdProses);
        imgProfile = findViewById(R.id.imgProfile);
        rvProsesLaundry = findViewById(R.id.rvProsesLaundry);
        rvRiwayatLaundry = findViewById(R.id.rvRiwayatLaundry);
        txtNama = findViewById(R.id.txtUser);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        setLayout();
        setMenu();
    }

    private void setMenu() {
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfilActivity.class));
            }
        });

        cdLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLlMenuLaundry = new Intent(new Intent(MainActivity.this, LaundryActivity.class));
                startActivity(intentLlMenuLaundry);
            }
        });

        cdRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLlMenuRiwayat = new Intent(new Intent(MainActivity.this, RiwayatActivity.class));
                startActivity(intentLlMenuRiwayat);
            }
        });

        cdProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLlMenuProses = new Intent(new Intent(MainActivity.this, ProsesLaundryActivity.class));
                startActivity(intentLlMenuProses);
            }
        });

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentImgUser = new Intent(new Intent(MainActivity.this, ProfilActivity.class));
                startActivity(intentImgUser);
            }
        });
    }


    private void setLayout() {
        if (firebaseUser != null) {
            txtNama.setText(firebaseUser.getDisplayName());
        } else {
            txtNama.setText("Anonymous");
        }
    }
}
