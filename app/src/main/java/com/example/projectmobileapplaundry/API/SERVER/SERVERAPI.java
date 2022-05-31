package com.example.projectmobileapplaundry.API.SERVER;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SERVERAPI {
    private static final String baseURL = "https://auliarahman27.000webhostapp.com/";
    //    private static final String baseLocal = "https://10.0.2.2/BackEnd";
    private static Retrofit retrofit = null;

    public static Retrofit serverConn(){
        if (serverConn()==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            ;
        }
        return retrofit;
    }
}
