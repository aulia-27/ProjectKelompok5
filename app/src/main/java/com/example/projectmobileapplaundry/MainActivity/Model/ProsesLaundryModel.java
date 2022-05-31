package com.example.projectmobileapplaundry.MainActivity.Model;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class ProsesLaundryModel {
    @SerializedName("id")
    private int id;
    @SerializedName("id_user")
    private int id_user;
    @SerializedName("kode_antrian")
    private int kode_antrian;
    @SerializedName("tanggal")
    private Date tanggal;
    @SerializedName("item")
    private int item;
    @SerializedName("harga")
    private double harga;
    @SerializedName("status")
    private String status;

    public ProsesLaundryModel(int id, int id_user, int kode_antrian, Date tanggal, int item, double harga, String status) {
        this.id = id;
        this.id_user = id_user;
        this.kode_antrian = kode_antrian;
        this.tanggal = tanggal;
        this.item = item;
        this.harga = harga;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getKode_antrian() {
        return kode_antrian;
    }

    public void setKode_antrian(int kode_antrian) {
        this.kode_antrian = kode_antrian;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
