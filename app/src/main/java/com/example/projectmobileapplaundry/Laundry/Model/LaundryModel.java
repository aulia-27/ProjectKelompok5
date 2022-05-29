package com.example.projectmobileapplaundry.Laundry.Model;

import com.google.gson.annotations.SerializedName;

public class LaundryModel {
    @SerializedName("id")
    private int id;
    @SerializedName("namaItem")
    private String namaItem;
    @SerializedName("hargaItem")
    private double hargaItem;
    @SerializedName("gambarItem")
    private String gambarItem;

    public LaundryModel(int id, String namaItem, double hargaItem, String gambarItem) {
        this.id = id;
        this.namaItem = namaItem;
        this.hargaItem = hargaItem;
        this.gambarItem = gambarItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public double getHargaItem() {
        return hargaItem;
    }

    public void setHargaItem(double hargaItem) {
        this.hargaItem = hargaItem;
    }

    public String getGambarItem() {
        return gambarItem;
    }

    public void setGambarItem(String gambarItem) {
        this.gambarItem = gambarItem;
    }
}
