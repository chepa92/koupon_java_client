package com.model;

import com.MVVMdemoException;
import java.util.NoSuchElementException;
import org.json.*;

public class Model implements IModel {

    API api = new API();
    Product[] coupons ;

    @Override
    public Product[] getItems() throws Exception {
        String result = api.sendGET("https://koupon.chepa.net/api/coupon/getAllCoupons");

        JSONArray obj = new JSONArray(result);
        coupons = new Product[obj.length()];

        for (int i = 0; i < obj.length(); i++) {
            String id = obj.getJSONObject(i).getString("_id");
            String title = obj.getJSONObject(i).getString("title");
            String discount = obj.getJSONObject(i).getString("discount");
            String link = obj.getJSONObject(i).getString("link");
            Product coupon = new Product(id, title, discount, link); //TODO price fix
            coupons[i] = coupon;
            //System.out.println(obj.getJSONObject(i).getString("couponName"));
        }

        return coupons;

    }

    @Override
    public String login(String name, String pass) throws MVVMdemoException, Exception {
        boolean result = api.login(name, pass);
        return "Nice";

    }

    public String postCoupon(Product product) throws Exception {
        boolean result = api.postItem("https://koupon.chepa.net/api/secret", product);

        return "Hello";

    }

    @Override
    public Product getItem(String id) throws NoSuchElementException {
        for (Product product : coupons) {
            if (product.getId() == id)
                return product;
            else
                throw new NoSuchElementException();
        }
        return null;
    }
    @Override
    public void postItem(Product product) throws Exception {
        boolean res = api.postItem("http://koupon.chepa.net/api/coupon/addCoupon", product);
    }


    @Override
    public String[] getItemsNames() {
        String[] productsNames = new String[coupons.length];
        for (int i = 0; i < coupons.length; i++) {
            productsNames[i] = coupons[i].toString();
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
