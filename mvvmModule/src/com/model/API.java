package com.model;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

import java.util.HashMap;
import java.util.Map;

public class API { //https://mkyong.com/java/java-11-httpclient-examples/

    static OkHttpClient client = new OkHttpClient().newBuilder().build();
    public static String cookie;


    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    public String sendGET(String url) throws Exception {

        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        String some = response.body().string();
        return some;
    }

    public boolean login(String name, String pass) throws Exception {

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"admin\",\"password\":\"admin\"}"); //TODO - add real name/pass

        Request request = new Request.Builder()
                .url("https://koupon.chepa.net/api/login?access_token=s%3AV2Zf-rFyRyjXAzCcnVU5HUckwO_WBGlY.tDExjzKFiEMVSUNpXt60R1tBm3bSETTFNF8UDK7y9Ic")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        cookie = response.header("set-cookie");

        if (cookie != null) {
            return true;
        }
        return false;

    }

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

        if (response != null) {
            return true;
        }
        return false;

    }

    public boolean postItem(String url, Product product) throws Exception {


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("title", product.getTitle());
            jsonObject.put("discount", product.getDiscount());
            jsonObject.put("link", product.getLink());
            jsonObject.put("imgUrl", product.getImg());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        OkHttpClient client = new OkHttpClient();
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
            e.printStackTrace();
        }


        if (response != null) {
            return true;
        }
        return false;
    }

    public boolean sendPost(String url, String other) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .method("POST", null)
                .addHeader("Cookie", cookie)
                .build();
        Response response = client.newCall(request).execute();
        String some = response.body().string();

        if (response != null) {
            return true;
        }
        return false;
    }


    private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        System.out.println(builder.toString());
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

}
