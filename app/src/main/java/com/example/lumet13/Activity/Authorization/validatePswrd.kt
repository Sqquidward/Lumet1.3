package com.example.lumet13.Activity.Authorization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.JCview.TextField
import com.example.lumet13.JCview.backgroung
import com.example.lumet13.Request.Retrofit.RetrofitRequest
class validatePswrd : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val Context = LocalContext.current
            backgroung()



            var token by rememberSaveable{ mutableStateOf("") }
            val intent = this.intent
            val email = intent.getStringExtra("email")

            Button(onClick = {
                val objec = RetrofitRequest()
                objec.RequestValidatePassword(email!!, token)
                //println("$login, $email, $password, $password_again")
                //Context.startActivity(Intent(Context, Registration::class.java))
                //mainCheck(login = login, email = email, password = password, password_again = password_again)
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.White),
                modifier = Modifier
                    .padding(
                        start = 37.dp,
                        top = 287.dp
                    )
                    .height(45.dp)
                    .width(320.dp),
                shape = RoundedCornerShape(40)
            )
            {
                Text("Send token", fontSize = 18.sp, fontFamily = manrope, fontWeight = FontWeight.Bold, color = Color.Black)
            }

            TextField(label = "Token", verticalSize = 219, text = token, onTextChange = {token = it})

        }
    }
}

