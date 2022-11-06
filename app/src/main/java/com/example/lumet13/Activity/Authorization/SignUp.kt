package com.example.lumet13.Activity.Authorization

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Request.Authorization.RetrofitRequest

import com.example.lumet13.Fonts.manrope
import com.example.lumet13.JCview.TextField
import com.example.lumet13.JCview.backgroung


class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val Context = LocalContext.current
            var email by rememberSaveable{ mutableStateOf("") }
            var password by rememberSaveable{ mutableStateOf("") }
            backgroung()

            TextField(label = "Email", verticalSize = 219, text = email, onTextChange = {email = it})
            TextField(label = "Password", verticalSize = 281, text = password, onTextChange = {password = it})

            Button(onClick = {
                Toast.makeText(Context,"Authotization", Toast.LENGTH_LONG).show()
                val obj = RetrofitRequest(email, password)
                obj.RequestAuthorization()
            },

                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                modifier = Modifier
                    .padding(
                        start = 37.dp,
                        top = 351.dp
                    )
                    .height(45.dp)
                    .width(156.dp),
                shape = RoundedCornerShape(40)
            )
            {
                Text("Login", fontSize = 18.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
            }


            Button(onClick = {
                //println("$login, $email, $password, $password_again")
                Context.startActivity(Intent(Context, Registration::class.java))
                //mainCheck(login = login, email = email, password = password, password_again = password_again)
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0x7C88D4), contentColor = Color.White),

                modifier = Modifier
                    .padding(
                        start = 200.dp,
                        top = 351.dp
                    )
                    .height(45.dp)
                    .width(135.dp),
                shape = RoundedCornerShape(40)
            )
            {
                Text("Register", fontSize = 18.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
            }
        }
    }
}
