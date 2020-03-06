package com.model;

import okhttp3.*;

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
//         print response headers
        HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v)); //TODO get cookie form here

//         print status code
        System.out.println(response.statusCode());

//         print response body
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

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();


        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"admin\",\"password\":\"admin\"}");
        Request request = new Request.Builder()
                .url("https://koupon.chepa.net/api/login?access_token=s%3AV2Zf-rFyRyjXAzCcnVU5HUckwO_WBGlY.tDExjzKFiEMVSUNpXt60R1tBm3bSETTFNF8UDK7y9Iw")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String some = response.body().string();



        Request request1 = new Request.Builder()
                .url("https://koupon.chepa.net/api/secret")
                .method("GET", null)
                .addHeader("Cookie", "connect.sid=s%3AvjjjMd1gu9z6jtfzSpaWV69E-tbsceay.0Qx%2Bb9sfqXTpl4%2Bv7V2%2BeXa3w%2BVMOsDlpwdMV9aGNHo")
                .build();
        Response response1 = client.newCall(request1).execute();
        String some1 = response1.body().string();

        System.out.println("hey");
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
