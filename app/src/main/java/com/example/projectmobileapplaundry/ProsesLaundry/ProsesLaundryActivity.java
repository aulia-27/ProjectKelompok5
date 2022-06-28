package com.example.projectmobileapplaundry.ProsesLaundry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectmobileapplaundry.Laundry.LaundryActivity;
import com.example.projectmobileapplaundry.R;

public class ProsesLaundryActivity extends AppCompatActivity {

    CardView cdPaketCucian, cdPaketReguler, cdPaketExpress, cdPaketLain;
    ConstraintLayout clPaketRegulerLoad, clPaketReguler, clPaketExpress;
    TextView txtKategoriLaundry, txtHargaKategoriLaundry;
    ImageView imageView8, imageView10, imageView13;

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses_laundry);
        cdPaketCucian = findViewById(R.id.cdPaketCucian);
        cdPaketReguler = findViewById(R.id.cdPaketReguler);
        cdPaketExpress = findViewById(R.id.cdPaketExpress);
        cdPaketLain = findViewById(R.id.cdPaketLain);
        clPaketRegulerLoad = findViewById(R.id.clPaketRegulerLoad);
        clPaketReguler = findViewById(R.id.clPaketReguler);
        clPaketExpress = findViewById(R.id.clPaketExpress);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProsesLaundryActivity.this, ProsesPesanLaundryActivity.class);
                startActivity(intent);
                txtKategoriLaundry.setText("Paket Reguler-Load");
                txtHargaKategoriLaundry.setText("Rp.3000/Kg");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProsesLaundryActivity.this, ProsesPesanLaundryActivity.class);
                startActivity(intent);
                txtKategoriLaundry.setText("Paket Reguler-Load");
                txtHargaKategoriLaundry.setText("Rp.3000/Kg");
            }
        });


        imageView8 = findViewById(R.id.imageView8);
        imageView10 = findViewById(R.id.imageView10);
        imageView13 = findViewById(R.id.imageView13);
        txtKategoriLaundry = findViewById(R.id.txtKategoriLaundry);
        txtHargaKategoriLaundry = findViewById(R.id.txtHargaKategoriLaundry);

        cdPaketCucian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProsesPesanLaundryActivity.class));
//                txtKategoriLaundry.setText("Paket Reguler-Load");
//                txtHargaKategoriLaundry.setText("Rp.3000/Kg");
            }
        });

        cdPaketReguler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProsesPesanLaundryActivity.class));
//                txtKategoriLaundry.setText("Paket Reguler");
//                txtHargaKategoriLaundry.setText("Rp.5000/Kg");
            }
        });

        cdPaketExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProsesPesanLaundryActivity.class));
                txtKategoriLaundry.setText("Paket Express");
                txtHargaKategoriLaundry.setText("Rp.10000/Kg");
            }
        });

        clPaketRegulerLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProsesPesanLaundryActivity.class));
                txtKategoriLaundry.setText("Paket Reguler-Load");
                txtHargaKategoriLaundry.setText("Rp.3000/Kg");
            }
        });

        clPaketReguler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProsesPesanLaundryActivity.class));
                txtKategoriLaundry.setText("Paket Reguler");
                txtHargaKategoriLaundry.setText("Rp.5000/Kg");
            }
        });

        clPaketExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProsesPesanLaundryActivity.class));
                txtKategoriLaundry.setText("Paket Reguler-Load");
                txtHargaKategoriLaundry.setText("Rp.3000/Kg");
            }
        });

        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProsesPesanLaundryActivity.class));
                txtKategoriLaundry.setText("Paket Reguler-Load");
                txtHargaKategoriLaundry.setText("Rp.3000/Kg");
            }
        });

        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProsesPesanLaundryActivity.class));
                txtKategoriLaundry.setText("Paket Reguler");
                txtHargaKategoriLaundry.setText("Rp.5000/Kg");
            }
        });

        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProsesPesanLaundryActivity.class));
                txtKategoriLaundry.setText("Paket Reguler-Load");
                txtHargaKategoriLaundry.setText("Rp.3000/Kg");
            }
        });
    }


}