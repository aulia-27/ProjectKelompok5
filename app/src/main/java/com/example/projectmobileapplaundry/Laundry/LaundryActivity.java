package com.example.projectmobileapplaundry.Laundry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectmobileapplaundry.API.SERVER.SERVERAPI;
import com.example.projectmobileapplaundry.DaftarHarga.Model.DaftarHargaModel;
import com.example.projectmobileapplaundry.Laundry.Adapter.LaundryAdapter;
import com.example.projectmobileapplaundry.Laundry.Model.LaundryModel;
import com.example.projectmobileapplaundry.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaundryActivity extends AppCompatActivity {

    RecyclerView rvListLaundry;
    Button btnPesanLaundry;
    ImageView imgPlus, imgMinus;
    TextView txtJumlahItem_L;
    RecyclerView.LayoutManager lmLaundry;
    private List<LaundryModel> laundryModels;
    LaundryAdapter laundryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);
        setLayoutRecylceView();
        setPesanLaundry();
    }

    private void setLayoutRecylceView() {
        rvListLaundry = findViewById(R.id.rvListLaundry);
        laundryAdapter = new LaundryAdapter(this, laundryModels);
        rvListLaundry.setAdapter(laundryAdapter);
        lmLaundry = new LinearLayoutManager(this);
        rvListLaundry.setLayoutManager(lmLaundry);
        showData();
    }

    private void showData() {
        SERVERAPI.getSelectDaftarHargaAPI().callDaftarHarga().enqueue(new Callback<List<DaftarHargaModel>>() {
            @Override
            public void onResponse(Call<List<DaftarHargaModel>> call, Response<List<DaftarHargaModel>> response) {
                if (response.isSuccessful() && response.body() != null) {

                }
            }

            @Override
            public void onFailure(Call<List<DaftarHargaModel>> call, Throwable t) {

            }
        });
    }

    private void setPesanLaundry() {
    }
}