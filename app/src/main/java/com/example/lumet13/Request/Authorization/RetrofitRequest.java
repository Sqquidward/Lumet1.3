package com.example.lumet13.Request.Authorization;





import android.content.Context;
import android.content.Intent;

import com.example.lumet13.Activity.Authorization.Listener;
import com.example.lumet13.Activity.Maps.MapsAct;
import com.example.lumet13.Request.Authorization.Models.Login;
import com.example.lumet13.Request.Authorization.Models.Token;
import com.example.lumet13.Request.Authorization.Models.User;

import java.io.EOFException;
import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest{
    String login;
    String password;
    String email;
    String password_token;
    //
    String token;

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

    public void RequestAuthorization(Listener listener){
        //HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        Call<ResponseBody> callAuthorization = service.Authorization(new Login(email, password));
        callAuthorization.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response.code());
                if(response.code() == 200){
                    try {
                        token = "Bearer "+ response.body().string();
                        RequestGetDataUser(token);
                        listener.onFetchData("");
                    } catch (IOException e) {
                       e.printStackTrace();
                    }}
                else{
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("Oшибка  "+ t);
            }
        });
    }
    public void RequestGetDataUser(String value){;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Authorization", value).build();
                return chain.proceed(request);
            }
        });

        Retrofit retrofitCustom = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://89.108.81.81:8080/").client(httpClient.build()).build();
        ServInterface_reg serviceC = retrofitCustom.create(ServInterface_reg.class);

        Call<ResponseBody> callGetUser = serviceC.GetUser();
        callGetUser.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println("Body " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Body " + response.raw());
                System.out.println("Headers " + response.headers());
                System.out.println("Code " + response.code());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("Oшибка  "+ t);
            }
        });
    }

}


