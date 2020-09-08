package com.threel.animeshqip;

public class Series {
    private String image;
    private String name;
    private boolean permission;

    public Series() {
    }
    public Series(String image, boolean permission, String name){
        this.image=image;
        this.permission=permission;
        this.name = name;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}