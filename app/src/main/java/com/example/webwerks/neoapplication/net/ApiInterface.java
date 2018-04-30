package com.example.webwerks.neoapplication.net;

import com.example.webwerks.neoapplication.views.model.LoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by webwerks on 27/4/18.
 */

public interface ApiInterface {

    @POST("api/users")
    @FormUrlEncoded
    Call<LoginModel> doLogin(@Field("username") String username,
                             @Field("password") String password
    );

}
