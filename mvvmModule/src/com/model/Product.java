package com.model;

public class Product {
    private static final int  initId = 1;
    int id;
    String name;
    int price;
    String desc;
    //TODO add more info to coupons


    public Product(String name, int price, String desc){
        this.setId(initId);
        this.setName(name);
        this.setPrice(price);
        this.setDesc(desc);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name;
    }

}
