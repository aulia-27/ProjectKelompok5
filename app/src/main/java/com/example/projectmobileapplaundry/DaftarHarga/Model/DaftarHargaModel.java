package com.example.projectmobileapplaundry.DaftarHarga.Model;

import com.google.gson.annotations.SerializedName;

public class DaftarHargaModel {
    @SerializedName("id")
    private int id;
    @SerializedName("nama_item")
    private String nama_time;
    @SerializedName("jenis_item")
    private String jenis_item;
    @SerializedName("harga_item")
    private double harga_item;
    @SerializedName("gambar_item")
    private String gambar_item;

    public DaftarHargaModel(int id, String nama_time, String jenis_item, double harga_item, String gambar_item) {
        this.id = id;
        this.nama_time = nama_time;
        this.jenis_item = jenis_item;
        this.harga_item = harga_item;
        this.gambar_item = gambar_item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_time() {
        return nama_time;
    }

    public void setNama_time(String nama_time) {
        this.nama_time = nama_time;
    }

    public String getJenis_item() {
        return jenis_item;
    }

    public void setJenis_item(String jenis_item) {
        this.jenis_item = jenis_item;
    }

    public double getHarga_item() {
        return harga_item;
    }

    public void setHarga_item(double harga_item) {
        this.harga_item = harga_item;
    }

    public String getGambar_item() {
        return gambar_item;
    }

    public void setGambar_item(String gambar_item) {
        this.gambar_item = gambar_item;
    }
}
