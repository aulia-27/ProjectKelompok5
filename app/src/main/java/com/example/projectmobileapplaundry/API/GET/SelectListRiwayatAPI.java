package com.example.projectmobileapplaundry.API.GET;

import com.example.projectmobileapplaundry.Riwayat.Model.RiwayatModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SelectListRiwayatAPI {
    @GET("listriwayatlaundry.php")
    Call<RiwayatModel> RIWAYAT_MODEL_CALL();
}
