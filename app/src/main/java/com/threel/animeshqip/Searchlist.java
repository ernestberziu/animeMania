package com.threel.animeshqip;

public class Searchlist {
    private String image;
    private String name;
    private boolean permission;

    public Searchlist() {
    }

    public Searchlist(String image, String name, boolean permission) {
        this.image = image;
        this.name = name;
        this.permission = permission;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String link) {
        image = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
