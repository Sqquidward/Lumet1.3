package com.example.lumet13.Request.Retrofit

class AnswerParametrs(var code:Int){
    fun Check(): Boolean {
        if (code == 200 && code == 201){
            return true
        }
        else{
            return false
        }
    }

}