package com.example.projectmobileapplaundry.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.projectmobileapplaundry.DaftarHarga.ListPriceActivity;
import com.example.projectmobileapplaundry.Laundry.LaundryActivity;
import com.example.projectmobileapplaundry.R;
import com.example.projectmobileapplaundry.MainActivity.Model.ProsesLaundryModel;
import com.example.projectmobileapplaundry.MainActivity.Model.RiwayatLaundryModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rlLaundry, rlDaftarHarga, rlRiwayat, rlLainnya;
    RecyclerView rvProsesLaundry, rvRiwayatLaundry;
    GridLayoutManager glmRiwayatLaundry, glmProsesLaundry;
    private List<ProsesLaundryModel> modelProsesLaundries = new ArrayList<>();
    private List<RiwayatLaundryModel> modelRiwayatLaundries = new ArrayList<>();
//    MainAdapterProsesLaundry mainAdapterPL;
//    MainAdapterRiwayatLaundry mainAdapterRL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setLayout();
        setMenu();
    }

//    private void setLayout() {
//        rvProsesLaundry = findViewById(R.id.rvProsesLaundry);
//        rvRiwayatLaundry = findViewById(R.id.rvRiwayatLaundry);
//
//        mainAdapterPL = new MainAdapterProsesLaundry(this, modelProsesLaundries);
//        rvProsesLaundry.setAdapter(mainAdapterRL);
//        glmProsesLaundry = new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false);
//        rvProsesLaundry.setLayoutManager(glmProsesLaundry);
//
//        mainAdapterRL = new MainAdapterRiwayatLaundry(this, modelRiwayatLaundries);
//        rvRiwayatLaundry.setAdapter(mainAdapterPL);
//        glmRiwayatLaundry = new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false);
//
//    }

    private void setMenu() {
        rlLaundry = findViewById(R.id.rlLaundry);
        rlDaftarHarga = findViewById(R.id.rlDaftarHarga);
        rlRiwayat = findViewById(R.id.rlHistory);
        rlLainnya = findViewById(R.id.rlMore);

        rlLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRlLaundry = new Intent(new Intent(MainActivity.this, LaundryActivity.class));
                startActivity(intentRlLaundry);
            }
        });

        rlDaftarHarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRlDaftarHarga = new Intent(new Intent(MainActivity.this, ListPriceActivity.class));
                startActivity(intentRlDaftarHarga);
            }
        });

        rlRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRlRiwayat = new Intent(new Intent(MainActivity.this, LaundryActivity.class));
                startActivity(intentRlRiwayat);
            }
        });

        rlLainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRlLainnya = new Intent(new Intent(MainActivity.this, LaundryActivity.class));
                startActivity(intentRlLainnya);
            }
        });
    }
}