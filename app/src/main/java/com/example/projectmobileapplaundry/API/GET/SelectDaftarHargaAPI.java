package com.example.projectmobileapplaundry.API.GET;

import com.example.projectmobileapplaundry.DaftarHarga.Model.DaftarHargaModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SelectDaftarHargaAPI {
    @GET("selectdaftarharga.php")
    Call<DaftarHargaModel> HARGA_MODEL_CALL();
}
