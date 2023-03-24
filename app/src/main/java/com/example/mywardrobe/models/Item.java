package com.example.mywardrobe.models;

public class Item {
    private int id;
    private String name;
    private int type;
    private long image;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Item(int id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
