package com.example.lumet13.Activity.Setting

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Maps.MapsAct
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R

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
        onClick = { /*TODO*/ },
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

    Image(
        modifier = Modifier
            .padding(start = 0.dp, top = 7.dp)
            .size(20.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.icon_password),

        contentDescription = null
    )



    Button(
        onClick = { /*TODO*/ },
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
        onClick = { /*TODO*/ },
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



}