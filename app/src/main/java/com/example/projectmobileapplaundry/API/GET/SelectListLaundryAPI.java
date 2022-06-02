package com.example.projectmobileapplaundry.API.GET;

import com.example.projectmobileapplaundry.DaftarHarga.Model.DaftarHargaModel;
import com.example.projectmobileapplaundry.Laundry.Model.LaundryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SelectListLaundryAPI {
    @GET("selectlistlaundry.php")
    Call<List<LaundryModel>> callLaundry();
}

