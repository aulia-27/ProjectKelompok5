package com.example.projectmobileapplaundry.Laundry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectmobileapplaundry.Laundry.Model.LaundryModel;
import com.example.projectmobileapplaundry.Login.LoginActivity;
import com.example.projectmobileapplaundry.Login.RegisterActivity;
import com.example.projectmobileapplaundry.MainActivity.MainActivity;
import com.example.projectmobileapplaundry.R;

import java.util.List;

public class LaundryActivity extends AppCompatActivity {

    RecyclerView rvListLaundry;
    Button btnPesanLaundry;
    ImageView imgPlus, imgMinus;
    TextView txtJumlahItem_L;
    ImageView imgBackMenu;
    RecyclerView.LayoutManager lmLaundry;
    private List<LaundryModel> laundryModels;
//    LaundryAdapter laundryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);
        setLayoutRecylceView();
        setPesanLaundry();
    }

    private void setLayoutRecylceView() {
        imgBackMenu = findViewById(R.id.imgBackMenu);
        imgBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentImgBackMenu = new Intent(new Intent(LaundryActivity.this, MainActivity.class));
                startActivity(intentImgBackMenu);
            }
        });
////        rvListLaundry = findViewById(R.id.rvListLaundry);
////        laundryAdapter = new LaundryAdapter(this, laundryModels);
//        rvListLaundry.setAdapter(laundryAdapter);
//        lmLaundry = new LinearLayoutManager(this);
//        rvListLaundry.setLayoutManager(lmLaundry);
//        showData();
    }

    private void showData() {

    }

    private void setPesanLaundry() {
    }
}