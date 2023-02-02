package com.example.lumet13.Request.Retrofit

import android.media.Rating
import com.example.lumet13.Request.Retrofit.Models.*
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

//    Users
    @GET("users/getUser")
    fun GetUser(): Call<UserDTO>


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



//change_user
    @POST("users/change_user/change_login/{login}")
    fun changeLogin(
        @Path("login") login:String
    ): Call<ResponseBody>

    @POST("users/change_user/change_email/{email}")
    fun changeEmail(
        @Path("email") email:String
    ): Call<ResponseBody>

    @POST("users/change_user/change_email/confirmation/{email}/{token}")
    fun changeEmailConfirmation(
        @Path("email") email:String,
        @Path("token") token:Int
    ): Call<ResponseBody>

    @POST("users/change_user/change_password/{password}")
    fun changePassword(
        @Path("password") password:String
    ): Call<ResponseBody>

    @POST("users/change_user/change_age/{age}}")
    fun changeAge(
        @Path("age") age:String
    ): Call<ResponseBody>

    @POST("users/change_user/change_privacystatus/profile/{status}")
    fun changeProfilePrivacyStatus(
        @Path("status") status:String
    ): Call<ResponseBody>

    @POST("users/change_user/change_privacystatus/map/{status}")
    fun changeMapPrivacyStatus(
        @Path("status") status:String
    ): Call<ResponseBody>

    @POST("users/change_user/change_privacystatus/chat/{status}")
    fun changeChatPrivacyStatus(
        @Path("status") status:String
    ): Call<ResponseBody>


    @POST("users/change_user/change_hobbytype/{hobbytypeName}")
    fun changeHobbyType(
        @Path("hobbytypeName") hobbytypeName:String
    ): Call<ResponseBody>

//Events
    @GET("events/get_All_events")
    fun GetEvents(): Call<List<EventDTO>>


    @POST("events/create_event")
    fun changeHobbyType(@Body createEventRequest: CreateEventRequest): Call<ResponseBody>

    @POST("events/remove_event/{eventId}")
    fun removeEvent(
        @Path("eventId") eventId:Int
    ): Call<ResponseBody>

    @POST("events/change_evemt/{eventId}")
    fun changeEvent(
        @Body createEventRequest: CreateEventRequest,
        @Path("eventId") eventId:Int
    ): Call<ResponseBody>

    @GET("events/get_All_events/sort_and_search/{search}/{min_age}/{rating}/{hobby}/{users_limit}")
    fun getAllEventsSort(
        @Path("search") search:String,
        @Path("min_age") min_age:Int,
        @Path("rating") rating: Int,
        @Path("hobby") hobby: String,
        @Path("users_limit") users_limit: String

    ): Call<List<EventDTO>>



//Interaction
//    Events

    @POST("users/users_interaction/apply_for_event/{eventId}")
    fun changeEvent(
        @Path("eventId") eventId:Int
    ): Call<ResponseBody>

    @POST("users/users_interaction/remove_apply_for_event/{eventId}")
    fun removeApplyForEvent(
        @Path("eventId") eventId:Int
    ): Call<ResponseBody>

    @POST("users/users_interaction/confirm_apply_for_event/{eventId}/{userId}")
    fun confirmApplyForEvent(
        @Path("eventId") eventId:Int,
        @Path("userId") userId:Int
    ): Call<ResponseBody>


//      Friends

    @POST("users/users_interaction/friend_request/{userId}")
    fun friendRequest(
        @Path("userId") userId:Int
    ): Call<ResponseBody>

    @POST("users/users_interaction/cancel_friend_request/{userId}")
    fun cancelFriendRequest(
        @Path("userId") userId:Int
    ): Call<ResponseBody>

    @POST("users/users_interaction/accept_request/{userId}")
    fun acceptRequest(
        @Path("userId") userId:Int
    ): Call<ResponseBody>

    @POST("users/users_interaction/reject_request/{userId}")
    fun rejectRequest(
        @Path("userId") userId:Int
    ): Call<ResponseBody>

    @POST("users/users_interaction/remove_from_friends/{userId}")
    fun removeFromFriends(
        @Path("userId") userId:Int
    ): Call<ResponseBody>






    @GET("test")
    fun test(): Call<ResponseBody?>?
}