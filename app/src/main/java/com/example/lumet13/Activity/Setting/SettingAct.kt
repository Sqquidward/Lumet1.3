package com.example.lumet13.Activity.Setting

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Maps.MapsAct
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R
import com.example.lumet13.Request.Retrofit.RetrofitRequest

class SettingAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingActiv()
        }
    }
}


@Composable
fun SettingActiv(){
    var Context = LocalContext.current
    var openDialogChangeEmail = remember { mutableStateOf(false) }
    var openDialogChangeEmailToken = remember { mutableStateOf(false) }
    var openDialogChangePassword = remember { mutableStateOf(false) }
    var openDialogChangePasswordToken = remember { mutableStateOf(false) }
    var openDialogChangePrivacy = remember { mutableStateOf(false) }
    Button(
        onClick = {
            Context.startActivity(
                Intent(Context, MapsAct::class.java)
            )
        },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 300.dp, top = 10.dp, end = 5.dp, bottom = 40.dp)
            .size(width = 50.dp, height = 55.dp),
        shape = RoundedCornerShape(40)
    ) {
        Image(
            modifier = Modifier.padding(),
            bitmap = ImageBitmap.imageResource(R.drawable.logout),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }

    Box(
        modifier = Modifier
            .padding(start = 40.dp, top = 10.dp)
            .size(height = 55.dp, width = 250.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFDB0082),
                        Color(0xFFFFC303)
                    )
                )
            )
    ) {
        Text(
            text = "Settings",
            fontSize = 30.sp ,
            modifier = Modifier.padding(start = 70.dp, top = 5.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    }





    Button(
        onClick = {  openDialogChangeEmail.value = true},
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 40.dp, top = 80.dp, end = 40.dp, bottom = 5.dp)
            .size(width = 400.dp, height = 50.dp),
        shape = RoundedCornerShape(30),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .padding(start = 0.dp, top = 7.dp)
                    .size(20.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.icon_email),

                contentDescription = null
            )

            Text(
                text = " Change email",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 34.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600
            )


        }
    }



    Button(
        onClick = { openDialogChangePassword.value = true },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 40.dp, top = 140.dp, end = 40.dp, bottom = 5.dp)
            .size(width = 400.dp, height = 50.dp),
        shape = RoundedCornerShape(30),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .padding(start = 0.dp, top = 7.dp)
                    .size(20.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.icon_password),

                contentDescription = null
            )

            Text(
                text = " Change password",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 34.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600
            )


        }
    }

    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 40.dp, top = 200.dp, end = 40.dp, bottom = 5.dp)
            .size(width = 250.dp, height = 50.dp),
        shape = RoundedCornerShape(30),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .padding(start = 0.dp, top = 7.dp)
                    .size(20.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.icon_language),

                contentDescription = null
            )

            Text(
                text = " Language",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 34.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600
            )


        }
    }

    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 300.dp, top = 200.dp, end = 40.dp, bottom = 5.dp)
            .size(width = 250.dp, height = 50.dp),
        shape = RoundedCornerShape(30),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                modifier = Modifier
                    .padding(start = 0.dp, top = 0.dp)
                    .size(60.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.icon_tema),

                contentDescription = null
            )

        }
    }

    Button(
        onClick = { openDialogChangePrivacy.value = true },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 220.dp, top = 260.dp, end = 40.dp, bottom = 5.dp)
            .size(width = 250.dp, height = 50.dp),
        shape = RoundedCornerShape(30),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .padding(start = 0.dp, top = 7.dp)
                    .size(20.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.icon_privacy),

                contentDescription = null
            )

            Text(
                text = " Privacy",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 22.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600
            )

        }
    }

    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 40.dp, top = 260.dp, end = 40.dp, bottom = 5.dp)
            .size(width = 170.dp, height = 50.dp),
        shape = RoundedCornerShape(30),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .padding(start = 0.dp, top = 7.dp)
                    .size(20.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.icon_blacklist),

                contentDescription = null
            )

            Text(
                text = " Blacklist",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 34.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600
            )


        }
    }



    if (openDialogChangeEmail.value) {
        AlertDialog(
            onDismissRequest = {

            },
            modifier = Modifier.size(width = 300.dp, height = 200.dp),
            title = {  },
            text = {
                Box(modifier = Modifier.fillMaxSize()){
                    Text(text = "Change your email", fontSize = 16.sp, fontFamily = manrope, fontWeight = FontWeight.SemiBold, color = Color.Black, modifier = Modifier.padding())
                    Column(modifier = Modifier.padding(top = 30.dp)){

                        var email by rememberSaveable { mutableStateOf("") }
                        OutlinedTextField(
                            shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                            value = email,
                            textStyle = TextStyle(fontSize = 17.sp),
                            label = {
                                Text(
                                    text = "New email",
                                    fontSize = 13.sp,
                                    fontFamily = manrope,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            modifier = Modifier
                                .padding(start = 10.dp, top = 5.dp)
                                .width(260.dp)
                                .height(58.dp),
                            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Проверено") },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                textColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Black
                            ),
                            onValueChange = { email = it }
                        )
                    }
                }
            },
            buttons = {
                Box {
                    Button(onClick = {
                        openDialogChangeEmail.value = false

                    },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                        modifier = Modifier
                            .padding(start = 30.dp, bottom = 10.dp)
                            .size(width = 120.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text("Close", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                    }

                    Button(onClick = {
                        openDialogChangeEmail.value = false
                        openDialogChangeEmailToken.value = true
                    },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                        modifier = Modifier
                            .padding(start = 160.dp, bottom = 10.dp)
                            .size(width = 120.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text("Send token", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                    }
                }

            }
        )
    }


    if (openDialogChangeEmailToken.value) {
        AlertDialog(
            onDismissRequest = {
                openDialogChangeEmailToken.value = false
            },
            modifier = Modifier.size(width = 300.dp, height = 200.dp),
            title = {  },
            text = {
                Box(modifier = Modifier.fillMaxSize()){
                    Text(text = "Change your token", fontSize = 16.sp, fontFamily = manrope, fontWeight = FontWeight.SemiBold, color = Color.Black, modifier = Modifier.padding())
                    Column(modifier = Modifier.padding(top = 30.dp)){

                        var emailToken by rememberSaveable { mutableStateOf("") }
                        OutlinedTextField(
                            shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                            value = emailToken,
                            textStyle = TextStyle(fontSize = 17.sp),
                            label = {
                                Text(
                                    text = "Your token",
                                    fontSize = 13.sp,
                                    fontFamily = manrope,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            modifier = Modifier
                                .padding(start = 10.dp, top = 5.dp)
                                .width(260.dp)
                                .height(58.dp),
                            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Проверено") },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                textColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Black
                            ),
                            onValueChange = { emailToken = it }
                        )
                    }
                }
            },
            buttons = {
                Box {
                    Button(onClick = {
                        openDialogChangeEmailToken.value = false
                    },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                        modifier = Modifier
                            .padding(start = 30.dp, bottom = 10.dp)
                            .size(width = 120.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text("Close", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                    }

                    Button(onClick = {
                        openDialogChangeEmailToken.value = false
                    },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                        modifier = Modifier
                            .padding(start = 160.dp, bottom = 10.dp)
                            .size(width = 120.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text("Send token", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                    }
                }

            }
        )
    }


    if (openDialogChangePassword.value) {
        AlertDialog(
            onDismissRequest = {

            },
            modifier = Modifier.size(width = 300.dp, height = 200.dp),
            title = {  },
            text = {
                Box(modifier = Modifier.fillMaxSize()){
                    Text(text = "Change your password", fontSize = 16.sp, fontFamily = manrope, fontWeight = FontWeight.SemiBold, color = Color.Black, modifier = Modifier.padding())
                    Column(modifier = Modifier.padding(top = 30.dp)){

                        var password by rememberSaveable { mutableStateOf("") }
                        OutlinedTextField(
                            shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                            value = password,
                            textStyle = TextStyle(fontSize = 17.sp),
                            label = {
                                Text(
                                    text = "New password",
                                    fontSize = 13.sp,
                                    fontFamily = manrope,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            modifier = Modifier
                                .padding(start = 10.dp, top = 5.dp)
                                .width(260.dp)
                                .height(58.dp),
                            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Проверено") },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                textColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Black
                            ),
                            onValueChange = { password = it }
                        )
                    }
                }
            },
            buttons = {
                Box {
                    Button(onClick = {
                        openDialogChangePassword.value = false

                    },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                        modifier = Modifier
                            .padding(start = 30.dp, bottom = 10.dp)
                            .size(width = 120.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text("Close", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                    }

                    Button(onClick = {
                        openDialogChangePassword.value = false
                        openDialogChangePasswordToken.value = true
                    },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                        modifier = Modifier
                            .padding(start = 160.dp, bottom = 10.dp)
                            .size(width = 120.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text("Send token", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                    }
                }

            }
        )
    }


    if (openDialogChangePasswordToken.value) {
        AlertDialog(
            onDismissRequest = {
                openDialogChangePasswordToken.value = false
            },
            modifier = Modifier.size(width = 300.dp, height = 200.dp),
            title = {  },
            text = {
                Box(modifier = Modifier.fillMaxSize()){
                    Text(text = "Change your token", fontSize = 16.sp, fontFamily = manrope, fontWeight = FontWeight.SemiBold, color = Color.Black, modifier = Modifier.padding())
                    Column(modifier = Modifier.padding(top = 30.dp)){

                        var  passwordToken by rememberSaveable { mutableStateOf("") }
                        OutlinedTextField(
                            shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                            value = passwordToken,
                            textStyle = TextStyle(fontSize = 17.sp),
                            label = {
                                Text(
                                    text = "Your token",
                                    fontSize = 13.sp,
                                    fontFamily = manrope,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            modifier = Modifier
                                .padding(start = 10.dp, top = 5.dp)
                                .width(260.dp)
                                .height(58.dp),
                            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Проверено") },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                textColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Black
                            ),
                            onValueChange = { passwordToken = it }
                        )
                    }
                }
            },
            buttons = {
                Box {
                    Button(onClick = {
                        openDialogChangePasswordToken.value = false
                    },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                        modifier = Modifier
                            .padding(start = 30.dp, bottom = 10.dp)
                            .size(width = 120.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text("Close", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                    }

                    Button(onClick = {
                        openDialogChangePasswordToken.value = false
                    },

                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                        modifier = Modifier
                            .padding(start = 160.dp, bottom = 10.dp)
                            .size(width = 120.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text("Send token", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                    }
                }

            }
        )
    }


    if (openDialogChangePrivacy.value) {
        AlertDialog(
            onDismissRequest = {
                openDialogChangePrivacy.value = false
            },
            modifier = Modifier.size(width = 200.dp, height = 200.dp),
            title = {  },
            text = {
                Box(modifier = Modifier.fillMaxSize()){
                    Text(text = "Who sees your profile?", fontSize = 16.sp, fontFamily = manrope, fontWeight = FontWeight.SemiBold, color = Color.Black, modifier = Modifier.padding())
                    Column(modifier = Modifier.padding(top = 60.dp)){
                        Box(

                        ){
                            Text(text = "All",
                                fontSize = 16.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                modifier = Modifier.clickable(onClick = {
                                    openDialogChangePrivacy.value = false
                                }))

                        }
                        Box(
                            modifier = Modifier.padding(top = 7.dp)
                        ){
                            Text(text = "Friends",
                                fontSize = 16.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                modifier = Modifier.clickable(onClick = {
                                    openDialogChangePrivacy.value = false
                                }))

                        }
                        Box(
                            modifier = Modifier.padding(top = 7.dp)
                        ){
                            Text(text = "Nobody",
                                fontSize = 16.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                modifier = Modifier.clickable(onClick = {
                                    openDialogChangePrivacy.value = false
                                }))

                        }




                    }
                }
            },
            buttons = {
            }
        )
    }


}