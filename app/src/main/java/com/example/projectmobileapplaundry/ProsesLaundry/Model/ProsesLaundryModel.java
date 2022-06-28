package com.example.projectmobileapplaundry.ProsesLaundry.Model;

import com.google.gson.annotations.SerializedName;

public class ProsesLaundryModel {
    @SerializedName("id")
    private int id;
    @SerializedName("id_user")
    private String id_user;
    @SerializedName("kode_antrian")
    private String kode_antrian;
    @SerializedName("jumlah_item_riwayat")
    private int jumlah_item_proses;
    @SerializedName("harga_item_riwayat")
    private double harga_item_riwayat;

    public ProsesLaundryModel(int id, String id_user, String kode_antrian, int jumlah_item_proses, double harga_item_riwayat) {
        this.id = id;
        this.id_user = id_user;
        this.kode_antrian = kode_antrian;
        this.jumlah_item_proses = jumlah_item_proses;
        this.harga_item_riwayat = harga_item_riwayat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getKode_antrian() {
        return kode_antrian;
    }

    public void setKode_antrian(String kode_antrian) {
        this.kode_antrian = kode_antrian;
    }

    public int getJumlah_item_proses() {
        return jumlah_item_proses;
    }

    public void setJumlah_item_proses(int jumlah_item_proses) {
        this.jumlah_item_proses = jumlah_item_proses;
    }

    public double getHarga_item_riwayat() {
        return harga_item_riwayat;
    }

    public void setHarga_item_riwayat(double harga_item_riwayat) {
        this.harga_item_riwayat = harga_item_riwayat;
    }
}
