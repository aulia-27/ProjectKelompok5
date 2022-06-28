package com.example.projectmobileapplaundry.ProsesLaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectmobileapplaundry.API.POST.InsertPesanLaundry;
import com.example.projectmobileapplaundry.ProsesLaundry.Model.ProsesLaundryModel;
import com.example.projectmobileapplaundry.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProsesPesanLaundryActivity extends AppCompatActivity {
    EditText editJml1, editJml2, editJml3, editJml4, editJml5;
    TextView txtKategoriLaundry, txtHargaKategoriLaundry, id_userPesanLaundry;
    Button btnPesanLaundry;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    private static Retrofit retrofit = null;
    private String baseURL = "https://kelompoktrpl519.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses_pesan_laundry);
        editJml1 = findViewById(R.id.editJml1);
        editJml2 = findViewById(R.id.editJml2);
        editJml3 = findViewById(R.id.editJml3);
        editJml4 = findViewById(R.id.editJml4);
        editJml5 = findViewById(R.id.editJml5);
        txtKategoriLaundry = findViewById(R.id.txtKategoriLaundry);
        txtHargaKategoriLaundry = findViewById(R.id.txtHargaKategoriLaundry);
        id_userPesanLaundry = findViewById(R.id.id_userPesanLaundry);
        btnPesanLaundry = findViewById(R.id.btnPesanLaundry);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();

        if (firebaseUser !=  null){
            id_userPesanLaundry.setText(currentuser);
        } else {
            id_userPesanLaundry.setText("1");
        }

        btnPesanLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pesan();
            }
        });

    }

    private void Pesan() {
        int jumlah = Integer.parseInt(editJml1.getText().toString()) + Integer.parseInt(editJml2.getText().toString())  + Integer.parseInt(editJml3.getText().toString()) + Integer.parseInt(editJml4.getText().toString()) + Integer.parseInt(editJml5.getText().toString());
        int jml_kg = 0;
        int hrg_total = 0;
        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InsertPesanLaundry insertPesanLaundry = retrofit.create(InsertPesanLaundry.class);

        Call<ProsesLaundryModel> call = insertPesanLaundry.LAUNDRY_MODEL_CALL(
                id_userPesanLaundry.getText().toString(),
                txtKategoriLaundry.getText().toString(),
                jml_kg,
                jumlah,
                hrg_total);
        call.enqueue(new Callback<ProsesLaundryModel>() {
            @Override
            public void onResponse(Call<ProsesLaundryModel> call, Response<ProsesLaundryModel> response) {
                editJml1.setText("");
                editJml2.setText("");
                editJml3.setText("");
                editJml4.setText("");
                editJml5.setText("");
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ProsesLaundryModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}