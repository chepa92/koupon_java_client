package com.model;

import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.net.URL;

public class Product {
    String id;
    String title;
    String discount;
    String couponName;
        String link;

    public Product(String id, String title, String discount, String couponName, String link) throws MalformedURLException {
        this.setId(id);
        this.setTitle(title);
        this.setDiscount(discount);
        this.setCouponName(couponName);
        this.setLink(link);
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
    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



//    public URL getLink() {
//        return link;
//    }

//    public void setLink(String link) throws MalformedURLException {
//        System.out.println(link);
//        this.link = new URL(link);
//    }



    @Override
    public String toString() {
        return title;
    }

}
