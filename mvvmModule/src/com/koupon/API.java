package com.koupon;

import okhttp3.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * API class handel all requests and responses from RESTful web service
 */

public class API {

    static OkHttpClient client = new OkHttpClient().newBuilder().build();
    public static String cookie;

    static Logger log = Logger.getLogger("API");

    public API() {
        BasicConfigurator.configure();
        try{
            log.addAppender(new FileAppender(new SimpleLayout(), "output.log"));
        }
        catch (IOException e){
            e.printStackTrace();
            log.error(e);
        }
//        log.debug("This is debug message");
//        log.info("This is info message");
//        log.warn("This is warn message");
//        log.fatal("This is fatal message");
    }

    /** Our login connection to backend
     * @param url to get any 1 string request
     * @return is true if function have code 200
     */
    public String sendGET(String url) throws Exception {

        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        String some = response.body().string();
        log.info(some);
        return some;
    }

    /** Our login connection to backend also its saves global cookie
     * @param name is login name
     * @param pass is login password
     * @return is true if function have code 200
     */
    public boolean login(String name, String pass) throws Exception {

        System.out.println("Logic executed successfully....");
        System.out.println(name);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", name);
            jsonObject.put("password", pass);

        } catch (JSONException e) {
            e.printStackTrace();
            log.error(e);
        }
        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonObject.toString());

//        System.out.println(body);
        Request request = new Request.Builder()
                .url("https://koupon.chepa.net/api/login")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        cookie = response.header("set-cookie");
        System.out.println(response.code());

        log.info(response);
        log.info("Cookie is:" + cookie);

        if (response.code() == 200) {
            return true;
        }
        return false;

    }

    /** DELETE method of coupon from site
     * @param item is array with item details
     * @return is true if function have code 200
     */
    public boolean deleteItem(String item) throws Exception {

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://koupon.chepa.net/api/coupon/deleteCoupon?id="+ item)
                .method("DELETE", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        log.info(response);
        if (response.code() ==200) {
            return true;
        }
        return false;

    }

    /** our POST request of new item
     * @param url is POST link
     * @param product is array with item details
     * @return is true if function have code 200
     */
    public boolean postItem(String url, Product product) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("title", product.getTitle());
            jsonObject.put("discount", product.getDiscount());
            jsonObject.put("link", product.getLink());
            jsonObject.put("imgUrl", product.getImg());

        } catch (JSONException e) {
            log.error(e);
            e.printStackTrace();
        }

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        // put your json here
        RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        Request request = new Request.Builder()
                .url("https://koupon.chepa.net/api/coupon/addCoupon")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", cookie)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            String resStr = response.body().string();
        } catch (IOException e) {
            log.error(e);
            e.printStackTrace();
        }


        if (response != null) {
            return true;
        }
        return false;
    }

    /** Our UPDATE of item function
     * @param id is product id
     * @param product is array with product details
     * @return is true if function have code 200
     */
    public boolean updateItem(String id, Product product) throws IOException {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("title", product.getTitle());
            jsonObject.put("discount", product.getDiscount());
            jsonObject.put("link", product.getLink());
            jsonObject.put("imgUrl", product.getImg());

        } catch (JSONException e) {
            log.error(e);
            e.printStackTrace();
        }

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonObject.toString());
        Request request = new Request.Builder()
                .url("https://koupon.chepa.net/api/coupon/updateCoupon?id="+ id)
                .method("PUT", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        log.info(response);
        if (response.code() ==200) {
            return true;
        }
        return false;

    }

    /**
     * Our POST function with or attached
     *
     * @param url   post string
     * @param other other parameters with want to pass to function
     * @return is true if function have code 200
     */
    public boolean sendPost(String url, String other) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .method("POST", null)
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        String some = response.body().string();
        log.info(some);
        if (response != null) {
            return true;
        }
        return false;
    }
}
