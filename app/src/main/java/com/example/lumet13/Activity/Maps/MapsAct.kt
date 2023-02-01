package com.example.lumet13.Activity.Maps

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Events.CreateEventAct
import com.example.lumet13.Activity.Events.starDraw
import com.example.lumet13.Activity.Profile.MyProfileAct
import com.example.lumet13.Activity.Setting.SettingAct
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R
import kotlinx.coroutines.launch

class MapsAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainM()
        }
    }
}

var digit = R.drawable.apps



@Composable
fun mainM(){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    Text(
        text = "Hello",
        fontSize = 30.sp,
        color = Color.Blue,
        modifier = Modifier
            .padding(start = 70.dp, top = 40.dp)
    )
    var Context = LocalContext.current;




    Scaffold(
        scaffoldState = scaffoldState,
        drawerBackgroundColor = colorResource(R.color.darkgrey),
        drawerContent= {
            Box {
                Text(
                    text = "Significant",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontFamily = manrope,
                    fontWeight = FontWeight.W800,
                    modifier = Modifier
                        .padding(start = 125.dp, top = 48.dp)
                        .clickable(onClick = {
                            Context.startActivity(
                                Intent(Context, MyProfileAct::class.java)
                            )
                        })

                )

                Text(
                    text = "Meetings",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 70.dp, top = 150.dp),
                    color = Color.White,
                    fontFamily = manrope,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Create meeting",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(start = 70.dp, top = 205.dp)
                        .clickable(onClick = {
                            Context.startActivity(
                                Intent(Context, CreateEventAct::class.java)
                            )
                        }),
                    color = Color.White,
                    fontFamily = manrope,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Chats",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 70.dp, top = 260.dp),
                    color = Color.White,
                    fontFamily = manrope,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Seetings",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontFamily = manrope,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(start = 70.dp, top = 315.dp)
                        .clickable(onClick = {
                            Context.startActivity(
                                Intent(Context, SettingAct::class.java)
                            )
                        })

                )

                Image(
                    modifier = Modifier
                        .size(105.dp)
                        .padding(start = 20.dp, top = 30.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.round),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier
                        .size(15.dp)
                        .padding(horizontal = 10.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.star),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier.padding(start = 30.dp, top = 152.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.iconplace),
                    alignment = Alignment.BottomEnd,
                    contentDescription = null
                )

                Image(
                    modifier = Modifier.padding(start = 30.dp, top = 207.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.iconplus),
                    alignment = Alignment.BottomEnd,
                    contentDescription = null
                )

                Image(
                    modifier = Modifier.padding(start = 30.dp, top = 265.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.iconmessage),
                    alignment = Alignment.BottomEnd,
                    contentDescription = null
                )

                Image(
                    modifier = Modifier.padding(start = 30.dp, top = 317.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.icon_settings),
                    alignment = Alignment.BottomEnd,
                    contentDescription = null
                )

            }

        }
    ) {

        Button(onClick = {
            scope.launch{
                scaffoldState.drawerState.open()}

        },colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White)) {
        }


        mainActivitys()
    }





}


@Composable
fun mainActivitys(){

    Box(
        modifier = Modifier
            .padding(start = 20.dp, top = 60.dp, end = 20.dp)
            .size(width = 400.dp, height = 430.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.Black)
    )

    Text(
        text = "Maps...",
        fontSize = 30.sp ,
        modifier = Modifier.padding(start = 160.dp, top = 310.dp),
        color = Color.White,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Image(
        modifier = Modifier
            .padding(start = 40.dp, top = 509.dp)
            .size(100.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.roundblack),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )

    Text(
        text = "Significant",
        fontSize = 30.sp ,
        modifier = Modifier.padding(start = 160.dp, top = 510.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Image(
        modifier = Modifier
            .padding(start = 160.dp, top = 554.dp)
            .size(20.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.round_blue),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )

    Text(
        text = "Running",
        fontSize = 18.sp ,
        modifier = Modifier.padding(start = 190.dp, top = 552.dp),
        color = Color.DarkGray,
        fontFamily = manrope,
        fontWeight = FontWeight.Normal
    )

    for (i in 0..4){
        starDraw(i*20, 578)
    }


    Box(modifier = Modifier
        .padding(start = 30.dp, top = 640.dp, bottom = 5.dp, end = 190.dp)
        .size(width = 230.dp, height = 55.dp)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            bitmap = ImageBitmap.imageResource(R.drawable.rectangle),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )

        Text(
            text = "I will come",
            fontSize = 19.sp ,
            modifier = Modifier.padding(start = 30.dp, top = 12.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.W600
        )
    }


    Box(modifier = Modifier
        .padding(start = 215.dp, top = 634.dp, bottom = 5.dp, end = 50.dp)
        .size(width = 230.dp, height = 58.dp)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            bitmap = ImageBitmap.imageResource(R.drawable.rectangle2),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )

        Text(
            text = "Chat",
            fontSize = 19.sp ,
            modifier = Modifier.padding(start = 40.dp, top = 19.dp),
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontFamily = manrope,
            fontWeight = FontWeight.W600
        )
    }

    Text(
        text = "Moscow, Mokhovaya street, 15/1s1",
        fontSize = 19.sp ,
        modifier = Modifier.padding(start = 40.dp, top = 710.dp),
        color = Color(R.color.whitegrey),
        fontFamily = manrope,
        fontWeight = FontWeight.W600
    )
}


