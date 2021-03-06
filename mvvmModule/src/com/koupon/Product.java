package com.koupon;

/**
 * Definition of Product class that holds information on each Coupon
 */

public class Product {
    String id;
    String title;
    String discount;
    String link;
    String img;

    public Product(String id, String title, String discount, String link, String img) {
        this.setId(id);
        this.setTitle(title);
        this.setDiscount(discount);
        this.setLink(link);
        this.setImg(img);
    }

    public Product(String title, String discount, String link, String img) {
        this.setTitle(title);
        this.setDiscount(discount);
        this.setLink(link);
        this.setImg(img);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return title;
    }


}
