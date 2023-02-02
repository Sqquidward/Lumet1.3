package com.example.lumet13.Activity.Authorization

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.lumet_11.Activity.Authorization.ui.theme.Lumet11Theme
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.JCview.backgroung
import com.example.lumet13.JCview.TextField
import com.example.lumet13.Request.Authorization.RetrofitRequest

class Registration : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val Context = LocalContext.current
            backgroung()


            var login by rememberSaveable{ mutableStateOf("") }
            var email by rememberSaveable{ mutableStateOf("") }
            var password by rememberSaveable{ mutableStateOf("") }
            var password_again by rememberSaveable{ mutableStateOf("") }

//
//            var flag by remember{ mutableStateOf(false)}
//            Button_Register(top = 474, flag = flag, nick)

            Button(onClick = {
               // mainCheck(login = login, email = email, password = password, password_again = password_again)
                val i = Intent(Context, validatePswrd::class.java)
                i.putExtra("email", email)
                Context.startActivity(i)

                //println("$login, $email, $password, $password_again")

                val Object = RetrofitRequest(login, password, email)
                Object.RequestRegister()
            },

                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                modifier = Modifier
                    .padding(
                        start = 37.dp,
                        top = 476.dp
                    )
                    .height(45.dp)
                    .width(156.dp),
                shape = RoundedCornerShape(40)
            )
            {
                Text("Register", fontSize = 18.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
            }



            Button(onClick = {
                Context.startActivity(Intent(Context, SignUp::class.java))
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),

                modifier = Modifier
                    .padding(
                        start = 200.dp,
                        top = 476.dp
                    )
                    .height(45.dp)
                    .width(135.dp),
                shape = RoundedCornerShape(40)
            )
            {
                Text("Login", fontSize = 18.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
            }

            TextField(label = "Nick", verticalSize = 219, text = login, onTextChange = {login = it})
            TextField(label = "Email", verticalSize = 281, text = email, onTextChange = {email = it})
            TextField(label = "Password", verticalSize = 343, text = password, onTextChange = {password = it})
            TextField(label = "Password again", verticalSize = 406, text = password_again, onTextChange = {password_again = it})



        }
    }
}


fun mainCheck(login:String, email:String, password:String, password_again:String){



        val Object = RetrofitRequest(login, password, email)
        Object.RequestRegister()

}
