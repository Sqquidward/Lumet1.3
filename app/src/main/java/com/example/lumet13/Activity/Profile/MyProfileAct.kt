package com.example.lumet13.Activity.Profile

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Events.starDraw
import com.example.lumet13.Activity.Maps.MapsAct
import com.example.lumet13.Activity.Profile.ui.theme.Lumet13Theme
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R

class MyProfileAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            maindd()
        }
    }
}




@Composable
fun maindd(){
    var Context = LocalContext.current
    Button(
        onClick = {
            Context.startActivity(
                Intent(Context, MapsAct::class.java)
            )
        },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .size(width = 1000.dp, height = 65.dp)
            .padding(start = 330.dp, top = 5.dp, end = 5.dp, bottom = 5.dp),
        shape = RoundedCornerShape(40)
    ) {
        Image(
            modifier = Modifier.padding(),
            bitmap = ImageBitmap.imageResource(R.drawable.logout),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }


    Image(
        modifier = Modifier
            .padding(start = 40.dp, top = 25.dp)
            .size(100.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.roundblack),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )

    Text(
        text = "Mike",
        fontSize = 35.sp ,
        modifier = Modifier.padding(start = 163.dp, top = 30.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.SemiBold
    )

    for (i in 0..4){
        starDraw(i*20, 98)
    }

    Text(
        text = "15 years",
        fontSize = 20.sp ,
        modifier = Modifier.padding(start = 163.dp, top = 70.dp),
        color = Color.DarkGray,
        fontFamily = manrope,
        fontWeight = FontWeight.SemiBold
    )


    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 40.dp, top = 370.dp, end = 40.dp, bottom = 5.dp)
            .size(width = 400.dp, height = 50.dp),
        shape = RoundedCornerShape(30),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .padding(start = 0.dp, top = 7.dp)
                    .size(20.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.friend_icon),

                contentDescription = null
            )

            Text(
                text = " Friends",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 34.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600
            )

            Text(text = "13",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 255.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600)
        }


    }

    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 40.dp, top = 430.dp, end = 40.dp, bottom = 5.dp)
            .size(width = 170.dp, height = 50.dp),
        shape = RoundedCornerShape(30),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .padding(start = 0.dp, top = 7.dp)
                    .size(22.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.icon_event),

                contentDescription = null
            )

            Text(
                text = " Events",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 35.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600
            )

            Text(text = "13",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 255.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600)
        }


    }

    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(contentColor = Color.White, disabledBackgroundColor = Color.White, backgroundColor = Color.White),
        modifier = Modifier
            .padding(start = 220.dp, top = 430.dp, end = 40.dp, bottom = 5.dp)
            .size(width = 170.dp, height = 50.dp),
        shape = RoundedCornerShape(30),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .padding(start = 0.dp, top = 7.dp)
                    .size(22.dp),
                bitmap = ImageBitmap.imageResource(R.drawable.icon_hobby),

                contentDescription = null
            )

            Text(
                text = " Hobby",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 30.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600
            )

            Text(text = "13",
                fontSize = 17.sp ,
                modifier = Modifier.padding(start = 255.dp, top = 6.dp),
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.W600)
        }


    }

    Box(
        modifier = Modifier
            .padding(start = 40.dp, top = 200.dp)
            .size(width = 100.dp, height = 150.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.Black)
    )

    Box(
        modifier = Modifier
            .padding(start = 150.dp, top = 200.dp)
            .size(width = 130.dp, height = 150.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.Black)
    )

    Box(
        modifier = Modifier
            .padding(start = 290.dp, top = 200.dp)
            .size(width = 70.dp, height = 150.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.Black)
    )


    Box(
        modifier = Modifier
            .padding(start = 40.dp, top = 500.dp, end = 40.dp)
            .size(width = 400.dp, height = 15.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color(R.color.whitegrey))
    )



    post()

}

@Composable
fun post(){
    Image(
        modifier = Modifier
            .padding(start = 40.dp, top = 555.dp)
            .size(60.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.roundblack),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )

    Text(
        text = "Mike",
        fontSize = 24.sp ,
        modifier = Modifier.padding(start = 113.dp, top = 557.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.SemiBold
    )

    Text(
        text = "15 November, 2022",
        fontSize = 15.sp ,
        modifier = Modifier.padding(start = 113.dp, top = 587.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Normal
    )

    Box(
        modifier = Modifier
            .padding(start = 40.dp, top = 630.dp, end = 40.dp)
            .size(width = 400.dp, height = 180.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.Black)
    )
}

