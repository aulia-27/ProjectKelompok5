package com.example.projectmobileapplaundry.ProsesLaundry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectmobileapplaundry.R;

public class ProsesLaundryActivity extends AppCompatActivity {
    CardView cd1, cd2, cd3, cd4;
    Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses_laundry);
        cd1 = findViewById(R.id.cd1);
        cd2 = findViewById(R.id.cd2);
        cd3 = findViewById(R.id.cd3);
        cd4 = findViewById(R.id.cd4);
        btnProses = findViewById(R.id.btnPesanLaundry);
        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses();
            }
        });

    }

    private void proses() {

    }
}