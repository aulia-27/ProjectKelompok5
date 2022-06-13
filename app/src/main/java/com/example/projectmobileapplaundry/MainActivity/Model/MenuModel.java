package com.example.projectmobileapplaundry.MainActivity.Model;

public class MenuModel {
    String txtNamaMenu;
    int imageDrawable;

    public MenuModel(String txtNamaMenu, int imageDrawable) {
        this.txtNamaMenu = txtNamaMenu;
        this.imageDrawable = imageDrawable;
    }

    public String getTvTitle() {
        return txtNamaMenu;
    }

    public void setTvTitle(String tvTitle) {
        this.txtNamaMenu = tvTitle;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

}
