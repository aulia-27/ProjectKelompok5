package com.example.projectmobileapplaundry.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectmobileapplaundry.R;
import com.example.projectmobileapplaundry.model.ModelMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvListMenu, rvProsesLaundry, rvRiwayatLaundry;
    MenuAdapter menuAdapter;
    MainAdapterProsesLaundry mainAdapterPL;
    MainAdapterRiwayatLaundry mainAdapterRL;
    ModelMenu modelMenu;
    List<ModelMenu> modelMenuList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayout();
        setMenuIcon();
    }

    private void setLayout() {
        rvListMenu = findViewById(R.id.rvListMenu);
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

    private void setMenuIcon() {
        modelMenu = new ModelMenu("Laundry", R.drawable.laundry);
        modelMenuList.add(modelMenu);
        modelMenu = new ModelMenu("Daftar Harga", R.drawable.clipboard);
        modelMenuList.add(modelMenu);
        modelMenu = new ModelMenu("Riwayat", R.drawable.refresh);
        modelMenuList.add(modelMenu);
        modelMenu = new ModelMenu("Lainnya", R.drawable.ellipsis);
        modelMenuList.add(modelMenu);

    }
}