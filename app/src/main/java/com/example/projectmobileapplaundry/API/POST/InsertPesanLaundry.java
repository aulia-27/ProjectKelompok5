package com.example.projectmobileapplaundry.API.POST;

import com.example.projectmobileapplaundry.ProsesLaundry.Model.ProsesLaundryModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InsertPesanLaundry {
    @FormUrlEncoded
    @POST("insertProsesLaundry.php")
    Call<ProsesLaundryModel> LAUNDRY_MODEL_CALL(
            @Field("id_user") String id_user,
            @Field("jenis_paket") String jenis_paket,
            @Field("jml_kg") int jml_kg,
            @Field("jml_item") int jml_item,
            @Field("harga_total") double harga_total

    );


}
