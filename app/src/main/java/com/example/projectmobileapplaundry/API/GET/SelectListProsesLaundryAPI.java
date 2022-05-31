package com.example.projectmobileapplaundry.API.GET;

import com.example.projectmobileapplaundry.MainActivity.Model.ProsesLaundryModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SelectListProsesLaundryAPI {
    @GET("listproseslaundry.php")
    Call<ProsesLaundryModel> PROSES_LAUNDRY_MODEL_CALL();
}
