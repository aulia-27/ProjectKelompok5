package com.example.projectmobileapplaundry.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.projectmobileapplaundry.DaftarHarga.ListPriceActivity;
import com.example.projectmobileapplaundry.Laundry.LaundryActivity;
import com.example.projectmobileapplaundry.R;
import com.example.projectmobileapplaundry.model.ModelMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RelativeLayout rlLaundry, rlDaftarHarga, rlRiwayat, rlLainnya;
    RecyclerView rvListMenu, rvProsesLaundry, rvRiwayatLaundry;
    MainAdapterProsesLaundry mainAdapterPL;
    MainAdapterRiwayatLaundry mainAdapterRL;
    List<ModelMenu> modelMenuList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayout();
        setMenu();
    }

    private void setLayout() {
        rvProsesLaundry = findViewById(R.id.rvProsesLaundry);
        rvRiwayatLaundry = findViewById(R.id.rvRiwayatLaundry);

        rvListMenu.setLayoutManager(new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false));
        rvListMenu.setHasFixedSize(true);

        mainAdapterPL = new MainAdapterProsesLaundry(this);
        rvProsesLaundry.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvProsesLaundry.setAdapter(mainAdapterPL);
        rvProsesLaundry.setHasFixedSize(true);

        mainAdapterRL = new MainAdapterRiwayatLaundry(this);
        rvRiwayatLaundry.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvRiwayatLaundry.setAdapter(mainAdapterRL);
        rvRiwayatLaundry.setHasFixedSize(true);

    }

    private void setMenu() {
        rlLaundry = findViewById(R.id.rlLaundry);
        rlDaftarHarga = findViewById(R.id.rlDaftarHarga);
        rlRiwayat = findViewById(R.id.rvRiwayatLaundry);
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