package com.example.webwerks.neoapplication.net;

/**
 * Created by webwerks on 30/4/18.
 */

public class ApiUtils {

    public static String BASE_URL = "https://reqres.in/";

    public static ApiInterface getApiService() {
        return ApiClient.getClient(BASE_URL).create(ApiInterface.class);

    }

}
