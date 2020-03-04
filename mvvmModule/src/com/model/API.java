package com.model;

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

//    cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
//    CookieHandler.setDefault(cm);
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    public String sendGET(String myRequest) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(myRequest))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();


        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // print response headers
        HttpHeaders headers = response.headers();
        //headers.map().forEach((k, v) -> System.out.println(k + ":" + v)); //TODO get cookie form here

        // print status code
        //System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
        return(response.body());
    }

   public void sendPOST(String myRequest, Product product) throws IOException, InterruptedException {
       String json = new StringBuilder()//TODO create from product
               .append("{")
               .append("\"name\":\"mkyong\",")
               .append("\"notes\":\"hello\"")
               .append("}").toString();

       HttpRequest request = HttpRequest.newBuilder()
               .POST(HttpRequest.BodyPublishers.ofString(json))
               .uri(URI.create(myRequest))
               .setHeader("User-Agent", "Java 11 HttpClient Bot")// add request header
                .build();
   }
    public String sendPost( String name, String pass) throws Exception {
        HttpClient.newBuilder()
                .cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_NONE))
                .build();



        // form parameters
        Map<Object, Object> data = new HashMap<>();
        data.put("username", name);
        data.put("password", pass);
        data.put("ts", System.currentTimeMillis());


//        HttpRequest.Builder	header​(String name, String value)
        HttpRequest request = HttpRequest.newBuilder()
                .POST(buildFormDataFromMap(data))
                .uri(URI.create("https://koupon.chepa.net/api/login-with-passport-local-strategy"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


       //*var client = HttpClient.newBuilder()
            //    .cookieHandler(CookieHandler.getDefault())
         //       .build();
//        CookieManager cm = new CookieManager();
//
//        String uri = "https://koupon.chepa.net/api/coupon/getAllCoupons";
//        URL url = new URL(uri);
//        URLConnection connection = url.openConnection();
//        connection.getContent();
//        CookieStore cookieStore = cm.getCookieStore();
//        List<HttpCookie> cookieList = cookieStore.getCookies();
//
//        for (HttpCookie cookie : cookieList) {
//            System.out.println("Domain: " + cookie.getDomain());
//            //To retrieve current cookie store.
//            System.out.println(cm.getCookieStore());
//        }

        // print status code
        System.out.println(response.statusCode());
        if (response.statusCode() == 200){
            return ("Success");
        }

        // print response body
        System.out.println(response.body());
        return ("Failed");

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
