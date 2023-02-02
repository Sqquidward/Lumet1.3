package com.example.lumet13.Request.Retrofit

import android.media.Rating
import com.example.lumet13.Request.Retrofit.Models.Login
import com.example.lumet13.Request.Retrofit.Models.Token
import com.example.lumet13.Request.Retrofit.Models.User
import com.example.lumet13.Request.Retrofit.Models.UserDTO
import lumetbackend.entities.EventDTO
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ServInterface_reg {
    @Headers("Content-Type: application/json")
    @POST("registration")
    fun newUser(@Body user: User?): Call<ResponseBody>

    @Headers("Content-Type: application/json")
    @POST("registration/email_confirmation")
    fun ValidatePassword(@Body token: Token?): Call<ResponseBody>

    //@Headers("Content-Type: application/json")
    @POST("authorization")
    fun Authorization(@Body login: Login?): Call<String>

    //@Headers("Content-Type: application/json")
    @GET("users/getUser")
    fun GetUser(): Call<UserDTO>

    @GET("events/get_All_events")
    fun GetEvents(): Call<List<EventDTO>>

    @GET("users/getALLUsers")
    fun GetALLUsers(): Call<List<UserDTO>>

    @GET("users/getUserListById")
    fun GetUserListById(@Body userIdList: List<Int>): Call<List<UserDTO>>

    @GET("users/getALLUsers/sort_and_search/{search}/{min_age}/{rating}/{hobby}")
    fun GetALLUsersSort(
        @Path("search") search:String,
        @Path("min_age") min_age:Int,
        @Path("rating") rating: Int,
        @Path("hobby") hobby: String
    ): Call<List<UserDTO>>

    @GET("test")
    fun test(): Call<ResponseBody?>?
}