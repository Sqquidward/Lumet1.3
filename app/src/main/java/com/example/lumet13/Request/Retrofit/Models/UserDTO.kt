package com.example.lumet13.Request.Retrofit.Models

import lumetbackend.entities.Friends
import lumetbackend.entities.UserEvent
import java.io.Serializable


open class UserDTO: Serializable{
    var id: Int? = null
    var login: String? = null
    var email: String?= null
    var age: Int?= null
    var avatarimage: String?= null
    var images: Array<String>?= null
    var blacklist: Array<Int>?= null
    var rating: Int?= null
    var numberOfVotes: Int?= null
    var privacystatusProfile: String?= null
    var privacystatusMap: String?= null
    var privacystatusChat: String?= null
    var userEvents: UserEvent?= null
    var hobbytype: String?= null
    var friends: Friends?= null
    var userColor: String?= null
    var userLanguage: String?= null

}