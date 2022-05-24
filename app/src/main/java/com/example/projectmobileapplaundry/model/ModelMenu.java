package com.example.projectmobileapplaundry.model;

public class ModelMenu {

    String titleMenu;
    int imageDrawable;

    public ModelMenu(String titleMenu, int imageDrawable) {
        this.titleMenu = titleMenu;
        this.imageDrawable = imageDrawable;
    }

    public String getTitleMenu() {
        return titleMenu;
    }

    public void setTitleMenu(String tvTitle) {
        this.titleMenu = titleMenu;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }
}
