package com.threel.animeshqip;

public class episodesList {
    private String Link;
    private String name;
    private boolean permission;

    public episodesList() {
    }
    public episodesList(String name, boolean permission, String Link){
        this.Link=Link;
        this.permission=permission;
        this.name = name;
    }


    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public boolean isPermission() {
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
