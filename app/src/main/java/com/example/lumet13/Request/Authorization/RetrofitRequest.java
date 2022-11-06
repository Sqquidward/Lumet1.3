package com.example.lumet13.Request.Authorization;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.lumet13.Activity.Authorization.Registration;
import com.example.lumet13.Activity.Authorization.validatePswrd;
import com.example.lumet13.Request.Authorization.AnswerParametrs;
import com.example.lumet13.Request.Authorization.Models.Login;
import com.example.lumet13.Request.Authorization.Models.Token;
import com.example.lumet13.Request.Authorization.Models.User;
import com.example.lumet13.Request.Authorization.ServInterface_reg;

import java.io.EOFException;
import java.io.IOException;

import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitRequest{
    String login;
    String password;
    String email;
    String password_token;

    Context Context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://89.108.81.81:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            //.addConverterFactory(ScalarsConverterFactory.create())
            .build();
    ServInterface_reg service = retrofit.create(ServInterface_reg.class);

    public RetrofitRequest(String _login, String _password, String _email){
        login = _login;
        password = _password;
        email = _email;
    }

    public RetrofitRequest(String _email, String _password){
        email = _email;
        password = _password;
    }



    public void RequestRegister() throws EOFException {

        //      create an instance of the BookResource interface
        ServInterface_reg service = retrofit.create(ServInterface_reg.class);
        Call<ResponseBody> callnewUser = service.newUser(new User(login, password, email));
        callnewUser.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                System.out.println("Код   "+response.code()+"\nЗаголовок "+response.headers());
                boolean flag = new AnswerParametrs(response.code()).Check();
                //Intent i = new Intent(Context, validatePswrd.class);
                //i.putExtra("email", email);
                //Context.startActivity(i);
                    if(flag){
                        System.out.println("Все заебись братан");
                    }
                    else{
                        System.out.println("Где то ошибка братан");
                    }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("Ошибка "+t);
            }
        });





    }

    public void RequestValidatePassword(){



        Call<ResponseBody> callValToken = service.ValidatePassword(new Token(email, password));
        callValToken.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("Все заебись братан   "+response.body()+"Тута");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void Test(){
        Call<ResponseBody> callValToken = service.test();
        callValToken.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("Все заебись братан   "+response.body()+"Тута"+response.raw());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void RequestAuthorization(){
        //HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        Call<ResponseBody> callAuthorization = service.Authorization(new Login(email, password));
        callAuthorization.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("Все заебись братан");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("Oшибка  "+ t);
            }
        });
    }
}
