package com.example.lumet13.Request.Retrofit

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.example.lumet13.Request.Retrofit.Models.Login
import com.example.lumet13.Request.Retrofit.Models.Token
import com.example.lumet13.Request.Retrofit.Models.User
import com.example.lumet13.Request.Retrofit.Models.UserDTO
import com.example.lumet13.db.DBHandler
import lumetbackend.entities.EventDTO
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.EOFException
import java.io.IOException

class RetrofitRequest {
//    var login: String? = null
//    var password: String
//    var email: String
//    var password_token: String? = null
//
//    //
//    var token: String? = null
//    var Context: Context? = null
    var retrofit = Retrofit.Builder()
        .baseUrl("http://89.108.81.81:8080/")
        .addConverterFactory(GsonConverterFactory.create()) //.addConverterFactory(ScalarsConverterFactory.create())
        .build()
    var service = retrofit.create(ServInterface_reg::class.java)
//
//    constructor(_login: String?, _password: String, _email: String) {
//        login = _login
//        password = _password
//        email = _email
//    }
//
//    constructor(_email: String, _password: String) {
//        email = _email
//        password = _password
//    }



//    хули надо?
    @Throws(EOFException::class)
    fun RequestRegister(login: String?, password: String, email: String) {

        //      create an instance of the BookResource interface
        val service = retrofit.create(ServInterface_reg::class.java)
        val callnewUser = service.newUser(User(login, password, email))
        callnewUser.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                println(
                    """
                        Код   ${response.code()}
                        Заголовок ${response.headers()}
                        """.trimIndent()
                )
                val flag = AnswerParametrs(response.code()).Check()
                //Intent i = new Intent(Context, validatePswrd.class);
                //i.putExtra("email", email);
                //Context.startActivity(i);
                if (flag) {
                    println("Все заебись братан")
                } else {
                    println("Где то ошибка братан")
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                println("Ошибка $t")
            }
        })
    }

    fun RequestValidatePassword(email: String, password: String) {
        val callValToken = service.ValidatePassword(Token(email, password))
        callValToken.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("Все заебись братан   " + response.body() + "Тута")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {}
        })
    }



     //kjsdfhgkjhsvkjh
    fun RequestAuthorization(context: Context, listener: RequestListener<UserDTO>, email: String, password: String) {
        //HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        val callAuthorization = service.Authorization(Login(email, password))


        callAuthorization.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println(response.code())
                if (response.code() == 200) {
                    try {
                        val token = response.body()!!.string()
                        println("Token   " +token )
                        val dbHandler: DBHandler = DBHandler(context);
                        dbHandler.addNewUser(token)

                        println(dbHandler.readUsers().toString())
                   //     RequestGetDataUser(token, listener)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                } else {
                }
            }


            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                println("Oшибка  $t")
            }
        })
    }


//    Users
    fun RequestGetDataUser(token: String?, listener: RequestListener<UserDTO>) {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + token).build()
            chain.proceed(request)
        }
        val retrofitCustom = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://89.108.81.81:8080/").client(httpClient.build()).build()
        val serviceC = retrofitCustom.create(
            ServInterface_reg::class.java
        )
        val callGetUser = serviceC.GetUser()
        callGetUser.enqueue(object : Callback<UserDTO> {
            override fun onResponse(call: Call<UserDTO>, response: Response<UserDTO>) {
                try {
                    listener.onFetchData(response.body()!!)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<UserDTO>, t: Throwable) {
                println("Oшибка  $t")
            }
        })
    }




    fun RequestGetDataAllUsers(token: String?, listener: RequestListener<List<UserDTO>>) {

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder().addHeader("Authorization", token).build()
            chain.proceed(request)
        }
        val retrofitCustom = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://89.108.81.81:8080/").client(httpClient.build()).build()
        val serviceC = retrofitCustom.create(
            ServInterface_reg::class.java
        )

        val callGetUser = serviceC.GetALLUsers()
        callGetUser.enqueue(object : Callback<List<UserDTO>> {
            override fun onResponse(call: Call<List<UserDTO>>, response: Response<List<UserDTO>>) {
                try {
                    listener.onFetchData(response.body()!!)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<List<UserDTO>>, t: Throwable) {
                println("Oшибка  $t")
            }
        })
    }


    fun RequestGetDataUserListById(token: String?, listener: RequestListener<List<UserDTO>>, userIdList: List<Int>) {

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder().addHeader("Authorization", token).build()
            chain.proceed(request)
        }
        val retrofitCustom = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://89.108.81.81:8080/").client(httpClient.build()).build()
        val serviceC = retrofitCustom.create(
            ServInterface_reg::class.java
        )

        val callGetUser = serviceC.GetUserListById(userIdList)
        callGetUser.enqueue(object : Callback<List<UserDTO>> {
            override fun onResponse(call: Call<List<UserDTO>>, response: Response<List<UserDTO>>) {
                try {
                    listener.onFetchData(response.body()!!)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<List<UserDTO>>, t: Throwable) {
                println("Oшибка  $t")
            }
        })
    }



//    Events

    fun RequestGetDataEvents(token: String?, listener: RequestListener<List<EventDTO>?>) {

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder().addHeader("Authorization", token).build()
            chain.proceed(request)
        }
        val retrofitCustom = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://89.108.81.81:8080/").client(httpClient.build()).build()
        val serviceC = retrofitCustom.create(
            ServInterface_reg::class.java
        )

        val callGetUser = serviceC.GetEvents()
        callGetUser.enqueue(object : Callback<List<EventDTO>?> {
            override fun onResponse(call: Call<List<EventDTO>?>, response: Response<List<EventDTO>?>) {
                try {
                    println()
                    listener.onFetchData(response.body()!!)
                } catch (e: IOException) {
                    e.printStackTrace()
                    println(response.body())
                }
            }

            override fun onFailure(call: Call<List<EventDTO>?>, t: Throwable) {
                println("Oшибка  $t")
            }
        })
    }



//    fun Test() {
//        val callValToken = service.test()
//        callValToken.enqueue(object : Callback<ResponseBody> {
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                println("Все заебись братан   " + response.body() + "Тута" + response.raw())
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {}
//        })
//    }
}



