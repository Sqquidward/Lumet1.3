package com.example.lumet13.Request.Authorization;

import com.example.lumet13.Request.Authorization.Models.Login;
import com.example.lumet13.Request.Authorization.Models.Token;
import com.example.lumet13.Request.Authorization.Models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServInterface_reg {



    @Headers("Content-Type: application/json")
    @POST("registration")
    Call<ResponseBody> newUser(@Body User user);

    @Headers("Content-Type: application/json")
    @POST("registration/email_confirmation")
    Call<ResponseBody> ValidatePassword(@Body Token token);

    //@Headers("Content-Type: application/json")
    @POST("authorization")
    Call<ResponseBody> Authorization(@Body Login login);

    //@Headers("Content-Type: application/json")
    @GET("users/getUser")
    Call<ResponseBody> GetUser();

    @GET("test")
    Call<ResponseBody> test();
}
