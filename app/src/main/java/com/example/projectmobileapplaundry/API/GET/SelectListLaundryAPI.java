package com.example.projectmobileapplaundry.API.GET;

import com.example.projectmobileapplaundry.DaftarHarga.Model.DaftarHargaModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SelectListLaundryAPI {
    @GET("daftarhargalaundry.php")
    Call<DaftarHargaModel> HARGA_MODEL_CALL();
}
