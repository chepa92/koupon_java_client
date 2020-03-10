package com.koupon.tests;

import com.koupon.API;
import com.koupon.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class APITest {

    API api;

    @BeforeEach
    void setUp() {
        api = new API();
    }

    @AfterEach
    void tearDown() {
        api = null;
    }

    @Test
    void sendGET() {

    }

    @Test
    void login() throws Exception {
        String name = "admin";
        String pass = "admin";
        boolean expected = true;
        boolean actual = api.login(name, pass);
        assertEquals(expected, actual);
    }

    //Test dependes on coupon id
    @Test
    void deleteItem() throws Exception {
        String id ="5e6640f31aeebd00ce8a0a80";
        boolean expected = true;
        boolean actual = api.deleteItem(id);
        assertEquals(expected, actual);

    }

    @Test
    void postItem() {
        String title = "test title";
        String discount = "10%";
        String link = "https://www.bestbuy.com/site/canon-vixia-hf-w10-waterproof-hd-camcorder-black/6331911.p?skuId=6331911";
        String img = "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6331/6331911_rd.jpg";
        Product product = new Product(title, discount, link, img );
        boolean expected = true;
        boolean actual = api.postItem("http://koupon.chepa.net/api/coupon/addCoupon", product);
        assertEquals(expected, actual);
    }

    @Test
    void sendPost() {
    }
}