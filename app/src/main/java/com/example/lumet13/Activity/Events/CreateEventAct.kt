package com.example.lumet13.Activity.Events

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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

class CreateEventAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeEvents()
        }
    }
}

@Composable
fun MakeEvents() {
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
            text = "Create meeting",
            fontSize = 25.sp ,
            modifier = Modifier.padding(start = 33.dp, top = 8.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    }

    Box(
        modifier = Modifier
            .padding(start = 40.dp, top = 80.dp, end = 40.dp)
            .size(width = 400.dp, height = 180.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color.Black)
    )

    Text(
        text = "Сycling in the city",
        fontSize = 25.sp ,
        modifier = Modifier.padding(start = 40.dp, top = 270.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Image(
        modifier = Modifier
            .padding(start = 270.dp, top = 279.dp)
            .size(17.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )

    Image(
        modifier = Modifier
            .padding(start = 320.dp, top = 279.dp)
            .size(17.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.icon_telega),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )

    Text(
        text = "Lorem ipsum dolor sit amet, pro no choro habemus. Te nibh eius nominati pri, eum no ignota accusata assueverit. Id qui soleat     possim veritus.",
        fontSize = 15.sp ,
        modifier = Modifier.padding(start = 40.dp, top = 325.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Image(
        modifier = Modifier
            .padding(start = 170.dp, top = 390.dp)
            .size(12.dp),
        bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )


    Text(
        text = "Need registration?" ,
        fontSize = 17.sp ,
        modifier = Modifier.padding(start = 40.dp, top = 435.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Box(modifier = Modifier
        .padding(top = 435.dp, start = 260.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .size(height = 25.dp, width = 80.dp)
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFFDB0082),
                    Color(0xFFFFC303)
                )
            )
        ), )

    Box(modifier = Modifier
        .padding(top = 436.dp, start = 261.dp)
        .clip(shape = RoundedCornerShape(8.dp))
        .size(height = 23.dp, width = 44.dp)
        .background(
            Color.White
        ))

    Text(
        text = "Yes" ,
        fontSize = 15.sp ,
        modifier = Modifier.padding(start = 269.dp, top = 436.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )


    Text(
        text = "No" ,
        fontSize = 15.sp ,
        modifier = Modifier.padding(start = 310.dp, top = 436.dp),
        color = Color.White,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )


    Text(
        text = "Time spending" ,
        fontSize = 17.sp ,
        modifier = Modifier.padding(start = 40.dp, top = 470.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = "Place" ,
        fontSize = 17.sp ,
        modifier = Modifier.padding(start = 40.dp, top = 505.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = "Age" ,
        fontSize = 17.sp ,
        modifier = Modifier.padding(start = 40.dp, top = 535.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = "Users limit" ,
        fontSize = 17.sp ,
        modifier = Modifier.padding(start = 40.dp, top = 565.dp),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Box(modifier = Modifier
        .padding(top = 569.dp, start = 270.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .size(height = 25.dp, width = 70.dp)
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFFDB0082),
                    Color(0xFFFFC303)
                )
            )
        ), )

    Text(
        text = "8" ,
        fontSize = 15.sp ,
        modifier = Modifier.padding(start = 285.dp, top = 572.dp),
        color = Color.White,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Box(modifier = Modifier
        .padding(top = 570.dp, start = 316.dp)
        .clip(shape = RoundedCornerShape(9.dp))
        .size(height = 23.dp, width = 23.dp)
        .background(
            Color.White
        )){
        Image(
            modifier = Modifier
                .padding(start = 4.dp, top = 6.dp)
                .size(12.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }

    Box(modifier = Modifier
        .padding(top = 539.dp, start = 270.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .size(height = 25.dp, width = 70.dp)
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFFDB0082),
                    Color(0xFFFFC303)
                )
            )
        ), )

    Text(
        text = "16+" ,
        fontSize = 15.sp ,
        modifier = Modifier.padding(start = 280.dp, top = 541.dp),
        color = Color.White,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Box(modifier = Modifier
        .padding(top = 540.dp, start = 316.dp)
        .clip(shape = RoundedCornerShape(9.dp))
        .size(height = 23.dp, width = 23.dp)
        .background(
            Color.White
        )){
        Image(
            modifier = Modifier
                .padding(start = 4.dp, top = 6.dp)
                .size(12.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }


    Box(modifier = Modifier
        .padding(top = 471.dp, start = 260.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .size(height = 25.dp, width = 80.dp)
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFFDB0082),
                    Color(0xFFFFC303)
                )
            )
        ), )

    Text(
        text = "10:30" ,
        fontSize = 15.sp ,
        modifier = Modifier.padding(start = 269.dp, top = 473.dp),
        color = Color.White,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Box(modifier = Modifier
        .padding(top = 472.dp, start = 316.dp)
        .clip(shape = RoundedCornerShape(9.dp))
        .size(height = 23.dp, width = 23.dp)
        .background(
            Color.White
        )){
        Image(
            modifier = Modifier
                .padding(start = 4.dp, top = 6.dp)
                .size(12.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }


    Box(modifier = Modifier
        .padding(top = 472.dp, start = 316.dp)
        .clip(shape = RoundedCornerShape(9.dp))
        .size(height = 23.dp, width = 23.dp)
        .background(
            Color.White
        )){
        Image(
            modifier = Modifier
                .padding(start = 5.dp, top = 5.dp)
                .size(12.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }

    Box(modifier = Modifier
        .padding(top = 506.dp, start = 150.dp)
        .clip(shape = RoundedCornerShape(10.dp))
        .size(height = 25.dp, width = 190.dp)
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFFDB0082),
                    Color(0xFFFFC303)
                )
            )
        ), )

    Text(
        text = "310 Donley St, Cama" ,
        fontSize = 15.sp ,
        modifier = Modifier.padding(start = 160.dp, top = 507.dp),
        color = Color.White,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Box(modifier = Modifier
        .padding(top = 507.dp, start = 316.dp)
        .clip(shape = RoundedCornerShape(9.dp))
        .size(height = 23.dp, width = 23.dp)
        .background(
            Color.White
        )){
        Image(
            modifier = Modifier
                .padding(start = 5.dp, top = 5.dp)
                .size(12.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }




}