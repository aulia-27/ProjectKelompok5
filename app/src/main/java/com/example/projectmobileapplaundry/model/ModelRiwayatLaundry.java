package com.example.projectmobileapplaundry.model;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class ModelRiwayatLaundry{
    @SerializedName("id")
    private int id;
    @SerializedName("tanggal")
    private Date tanggal;
    @SerializedName("item")
    private int item;
    @SerializedName("harga")
    private double harga;

    public ModelRiwayatLaundry(int id, Date tanggal, int item, double harga) {
        this.id = id;
        this.tanggal = tanggal;
        this.item = item;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
