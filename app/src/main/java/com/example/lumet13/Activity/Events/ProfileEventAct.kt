package com.example.lumet13.Activity.Events

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Events.ui.theme.Lumet13Theme
import com.example.lumet13.Activity.Maps.MapsAct
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R
import com.example.lumet13.Request.Retrofit.Models.UserDTO
import com.example.lumet13.db.DBHandler
import lumetbackend.entities.EventDTO

class ProfileEventAct : ComponentActivity() {

    val dbHandler: DBHandler = DBHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var eventDTO = intent.getSerializableExtra("EventDTO") as EventDTO
        setContent {
            ProfileEvent(eventDTO)
        }
    }
}



var digit = R.drawable.apps
@Composable
fun ProfileEvent(eventDTO:EventDTO) {
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





    Box(
        modifier = Modifier
            .padding(start = 40.dp, top = 65.dp)
            .size(100.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(color = Color.Black)
    ){
        Image(
            contentScale = ContentScale.Crop,
            bitmap = ImageBitmap.imageResource(R.drawable.test_photo_biking),

            contentDescription = null
        )
    }



    Text(
        text = "Mountain trip",
        fontSize = 30.sp ,
        modifier = Modifier.padding(start = 160.dp, top = 70.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Image(
        modifier = Modifier
            .padding(start = 160.dp, top = 114.dp)
            .size(20.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.round_blue),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )

    Text(
        text = "Biking",
        fontSize = 18.sp ,
        modifier = Modifier.padding(start = 190.dp, top = 112.dp),
        color = Color.DarkGray,
        fontFamily = manrope,
        fontWeight = FontWeight.Normal
    )

    for (i in 0..eventDTO.userrating!!/2-1){
        starDraw(i*20, 138)
    }


    Box(modifier = Modifier
        .padding(start = 30.dp, top = 200.dp, bottom = 5.dp, end = 190.dp)
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
        .padding(start = 215.dp, top = 194.dp, bottom = 5.dp, end = 50.dp)
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
        modifier = Modifier.padding(start = 40.dp, top = 270.dp),
        color = Color(R.color.whitegrey),
        fontFamily = manrope,
        fontWeight = FontWeight.W600
    )




    Box(
        modifier = Modifier
            .padding(start = 40.dp, top = 325.dp)
            .size(60.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(color = Color.Black)
    ){
        Image(
            contentScale = ContentScale.Crop,
            bitmap = ImageBitmap.imageResource(R.drawable.test_photo5),

            contentDescription = null
        )
    }


    Text(
        text = "Ivan Kolugin",
        fontSize = 22.sp ,
        modifier = Modifier.padding(start = 110.dp, top = 332.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.W600
    )

    Text(
        text = "Was online at 12:34 yesterday",
        fontSize = 13.sp ,
        modifier = Modifier.padding(start = 110.dp, top = 360.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Light
    )

    Text(
        text = "Lorem ipsum dolor sit amet, pro no choro habemus. Te nibh eius nominati pri, eum no ignota accusata assueverit. Id qui soleat possim veritus. Cu eos oporteat mediocrem democritum, nihil explicari gloriatur eos no. Everti qualisque ei qui. An nam oblique nominati, postea dicunt ex usu. Noster everti has ut, tollit interesset ad sed.\n",
        fontSize = 18.sp ,
        modifier = Modifier.padding(start = 40.dp, top = 390.dp, end = 20.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.W500
    )



}

@Composable
fun starDraw(digit: Int, top: Int){
    Image(
        modifier = Modifier
            .padding(start = 161.dp + digit.dp, top = top.dp)
            .size(18.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.star_black),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )
}
