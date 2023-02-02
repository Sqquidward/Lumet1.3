package com.example.lumet13.Request.Retrofit.Models

class CreateEventRequest(
    val name : String,
    val description : String,
    val hobbytype : String,
    val time : String,
    val desiredage : Int?,
    val participantLimit : Int?,
    val participantsAnonymity : String,
    val privacyStatus : String,
    val registrationSettings : String,
    val latitude : String,
    val longitude : String
): java.io.Serializable