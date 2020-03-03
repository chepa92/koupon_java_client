package com.model;

import com.MVVMdemoException;
import java.util.NoSuchElementException;
import org.json.*;

public class Model implements IModel {

    API api = new API();

    Product[] computerProducts = {
            new Product("Lenovo", 2000, "L1222 Lenovo i7 Pc"),
            new Product("Samsung", 1850, "Samsung new Computer"),
            new Product("HP", 1200, "HP Computer")
    };

    @Override
    public Product[] getItems() throws Exception {
        String result = api.sendGET("https://koupon.chepa.net/api/coupon/getAllCoupons");

        JSONArray obj = new JSONArray(result);
        Product[] coupons = new Product[obj.length()];

        for (int i = 0; i < obj.length(); i++) {
            String id = obj.getJSONObject(i).getString("_id");
            String title = obj.getJSONObject(i).getString("title");
            String discount = obj.getJSONObject(i).getString("discount");
            String couponName = obj.getJSONObject(i).getString("couponName");
            Product coupon = new Product(title, 666, couponName); //TODO price fix
            coupons[i] = coupon;
            //System.out.println(obj.getJSONObject(i).getString("couponName"));
        }

        return coupons;

    }

    @Override
    public String login() throws Exception {
        String result = api.sendPost();

//        JSONArray obj = new JSONArray(result);
//        Product[] coupons = new Product[obj.length()];
//
//        for (int i = 0; i < obj.length(); i++) {
//            String id = obj.getJSONObject(i).getString("_id");
//            String title = obj.getJSONObject(i).getString("title");
//            String discount = obj.getJSONObject(i).getString("discount");
//            String couponName = obj.getJSONObject(i).getString("couponName");
//            Product coupon = new Product(title, 666, couponName); //TODO price fix
//            coupons[i] = coupon;
//            //System.out.println(obj.getJSONObject(i).getString("couponName"));
//        }

        return "Hello";

    }

    public String getSecret() throws Exception {
        String result = api.sendGET("https://koupon.chepa.net/api/secret");

        JSONArray obj = new JSONArray(result);
//        Product[] coupons = new Product[obj.length()];
//
//        for (int i = 0; i < obj.length(); i++) {
//            String id = obj.getJSONObject(i).getString("_id");
//            String title = obj.getJSONObject(i).getString("title");
//            String discount = obj.getJSONObject(i).getString("discount");
//            String couponName = obj.getJSONObject(i).getString("couponName");
//            Product coupon = new Product(title, 666, couponName); //TODO price fix
//            coupons[i] = coupon;
//            //System.out.println(obj.getJSONObject(i).getString("couponName"));
//        }

        return "Hello";

    }

    @Override
    public Product getItem(int id) throws NoSuchElementException {
        for (Product product : computerProducts) {
            if (product.getId() == id)
                return product;
            else
                throw new NoSuchElementException();
        }
        return null;
    }

    @Override
    public String[] getItemsNames() {
        String[] productsNames = new String[computerProducts.length];
        for (int i = 0; i < computerProducts.length; i++) {
            productsNames[i] = computerProducts[i].toString();
        }
        return productsNames;
    }

    @Override
    public String[] getItemsPrice() throws MVVMdemoException {
        return new String[0];
    }

    @Override
    public String[] getItemsDesc() throws MVVMdemoException {
        return new String[0];
    }

    @Override
    public void addItem(String text) throws MVVMdemoException {

    }

    @Override
    public void deleteItem() throws MVVMdemoException {

    }
}
