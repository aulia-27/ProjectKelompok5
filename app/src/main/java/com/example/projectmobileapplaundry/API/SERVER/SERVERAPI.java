package com.example.projectmobileapplaundry.API.SERVER;

import com.example.projectmobileapplaundry.API.GET.SelectListProsesLaundryAPI;
import com.example.projectmobileapplaundry.API.GET.SelectListRiwayatAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SERVERAPI {
    private static final String baseURL = "https://kelompoktrpl519.000webhostapp.com/";
    private static Retrofit retrofit = null;

    public static SelectListRiwayatAPI getSelectListRiwayatAPI(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            ;
        }
        return retrofit.create(SelectListRiwayatAPI.class);
    }

    public static SelectListProsesLaundryAPI getSelectListProsesLaundryAPI(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            ;
        }
        return retrofit.create(SelectListProsesLaundryAPI.class);
    }
}
