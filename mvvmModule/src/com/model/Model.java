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
            String img = obj.getJSONObject(i).getString("imgUrl");
            Product coupon = new Product(id, title, discount, link, img); //TODO price fix
            coupons[i] = coupon;
            //System.out.println(obj.getJSONObject(i).getString("couponName"));
        }

        return coupons;

    }

    @Override
    public Boolean login(String name, String pass) throws MVVMdemoException, Exception {
        boolean result = api.login(name, pass);

        return result;
    }

    public String postCoupon(Product product) throws Exception {
        boolean result = api.postItem("https://koupon.chepa.net/api/secret", product);

        if (result){
            return "POST-Success";
        }
        return "Failed";

    }
    @Override
    public boolean updateItem(String id , Product product) throws Exception {
        boolean result = api.updateItem(id, product);
        if (result)
         {
             System.out.println("Item: " +id +" was update successfully");
            return result;
         }
         System.out.println("Failed updating");
        return result;



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
    public void deleteItem(String item) throws Exception {
        boolean res = api.deleteItem(item);

    }
}
