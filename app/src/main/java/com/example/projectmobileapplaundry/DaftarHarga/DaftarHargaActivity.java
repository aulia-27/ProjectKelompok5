package com.example.projectmobileapplaundry.DaftarHarga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.projectmobileapplaundry.API.SERVER.SERVERAPI;
import com.example.projectmobileapplaundry.DaftarHarga.Adapter.DaftarHargaAdapter;
import com.example.projectmobileapplaundry.DaftarHarga.Model.DaftarHargaModel;
import com.example.projectmobileapplaundry.Laundry.LaundryActivity;
import com.example.projectmobileapplaundry.MainActivity.MainActivity;
import com.example.projectmobileapplaundry.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarHargaActivity extends AppCompatActivity {
    RecyclerView rvlistMenuOrder, rvListLaundry;
    Button btnLaundry;
    RecyclerView.LayoutManager lmDaftarHarga;
    private List<DaftarHargaModel> daftarHargaModels =  new ArrayList<>();
    DaftarHargaAdapter daftarHargaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_price);
        setLayoutRecyclerView();
        setPesanLaundry();
    }

    private void setLayoutRecyclerView() {
        rvListLaundry = findViewById(R.id.rvListLaundry);
        daftarHargaAdapter = new DaftarHargaAdapter(this, daftarHargaModels);
        rvListLaundry.setAdapter(daftarHargaAdapter);
        lmDaftarHarga = new LinearLayoutManager(this);
        rvListLaundry.setLayoutManager(lmDaftarHarga);
        showData();
    }

    private void showData() {
        SERVERAPI.getSelectDaftarHargaAPI().callProduk().enqueue(new Callback<List<DaftarHargaModel>>() {
            @Override
            public void onResponse(Call<List<DaftarHargaModel>> call, Response<List<DaftarHargaModel>> response) {
                if (response.isSuccessful() && response.body() != null){
                    daftarHargaModels.addAll(response.body());
                    daftarHargaAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DaftarHargaModel>> call, Throwable t) {
                Toast.makeText(DaftarHargaActivity.this,t.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setPesanLaundry() {
        btnLaundry = findViewById(R.id.btnPesanLaundry);
        btnLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DaftarHargaActivity.this, LaundryActivity.class);
                startActivity(intent);
            }
        });
    }


}