package com.example.lumet13.Activity.Maps

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import com.example.lumet13.Activity.Events.AllEvents
import com.example.lumet13.Activity.Events.CreateEventAct
import com.example.lumet13.Activity.Events.ProfileEventAct
import com.example.lumet13.Activity.Events.starDraw
import com.example.lumet13.Activity.Profile.MyProfileAct
import com.example.lumet13.Activity.Setting.SettingAct
import com.example.lumet13.Activity.Users.AllUsers
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R
import com.example.lumet13.Request.Retrofit.Models.UserDTO
import com.example.lumet13.Request.Retrofit.RequestListener
import com.example.lumet13.Request.Retrofit.RetrofitRequest
import com.example.lumet13.db.DBHandler
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.launch
import lumetbackend.entities.EventDTO
var userDTO  = UserDTO()
class MapsAct : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dbHandler: DBHandler = DBHandler(this)


//         userDTO = intent.getSerializableExtra("UserDTO") as UserDTO

        val requestListener = object : RequestListener<List<EventDTO>?>{
            override fun onFetchData(t: List<EventDTO>?) {
                println("test")
            }

            override fun onError(message: String?) {
                println("test")
            }
        }


        val req = RetrofitRequest()
        req.RequestGetDataEvents(dbHandler.readUsers()!![0].courseToken, requestListener)

        setContent {
            mainM()
        }
    }


}


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
                                Intent(Context, MyProfileAct::class.java).apply { putExtra("UserDTO", userDTO) }
                            )
                        })

                )

                Text(
                    text = "Meetings",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(start = 70.dp, top = 150.dp)
                        .clickable(onClick = {
                            Context.startActivity(
                                Intent(Context, AllEvents::class.java)
                            )
                        }),
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
                    text = "Users",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(start = 70.dp, top = 370.dp)
                        .clickable(onClick = {
                            Context.startActivity(
                                Intent(Context, AllUsers::class.java)
                            )
                        }),
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


                val dbHandler: DBHandler = DBHandler(Context);
                //RequestGetDataUser(token, listener)
                Toast.makeText(Context, dbHandler.readUsers().toString(), Toast.LENGTH_SHORT).show()
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
fun mainActivitys() {

    var digit = R.drawable.icon3
    var people = R.drawable.people

    var animatedd by remember { mutableStateOf(false) }
    val size by animateDpAsState(
        targetValue = if (animatedd) 450.dp else 780.dp,
        animationSpec = tween(durationMillis = 800, delayMillis = 500)
    )

    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }


    Box(
        modifier = Modifier
            .padding(start = 20.dp, top = 50.dp, bottom = 20.dp, end = 20.dp)
            .size(size)
            .clip(shape = RoundedCornerShape(20.dp))){
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state =  rememberMarkerState(position = singapore),
                icon = BitmapDescriptorFactory.fromResource(digit)
            )

            Marker(
                state = rememberMarkerState(position = singapore),
                title = "Mike",
                snippet = "Marker in Singapore",
                icon = BitmapDescriptorFactory.fromResource(people),
                onInfoWindowClick = { _ ->
                    animatedd =! animatedd
                }
            )


        }
    }

    mainSod(animated = animatedd)

}



@Composable
fun mainSod(animated:Boolean) {
    var Context = LocalContext.current
    val alpha by animateFloatAsState(
        targetValue = if(animated) 1f else 0f,
        animationSpec = tween(durationMillis = 400, delayMillis = 800))
    Image(
        modifier = Modifier
            .padding(start = 40.dp, top = 509.dp)
            .size(100.dp)
            .alpha(alpha),
        bitmap = ImageBitmap.imageResource(R.drawable.roundblack),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )

    Text(
        text = "Significant",
        fontSize = 30.sp ,
        modifier = Modifier
            .padding(start = 160.dp, top = 510.dp)
            .alpha(alpha)
            .clickable(onClick = {
                Context.startActivity(
                    Intent(Context, ProfileEventAct::class.java)
                )
            }),
        color = Color.Black,
        fontFamily = manrope,
        fontWeight = FontWeight.Bold
    )

    Image(
        modifier = Modifier
            .padding(start = 160.dp, top = 554.dp)
            .size(20.dp)
            .alpha(alpha),
        bitmap = ImageBitmap.imageResource(R.drawable.round_blue),
        alignment = Alignment.BottomEnd,
        contentDescription = null
    )

    Text(
        text = "Running",
        fontSize = 18.sp ,
        modifier = Modifier
            .padding(start = 190.dp, top = 552.dp)
            .alpha(alpha),
        color = Color.DarkGray,
        fontFamily = manrope,
        fontWeight = FontWeight.Normal
    )

    for (i in 0..4){
        Image(
            modifier = Modifier
                .padding(start = 161.dp + (i*20).dp, top = 578.dp)
                .size(18.dp)
                .alpha(alpha),
            bitmap = ImageBitmap.imageResource(R.drawable.star_black),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }


    Box(modifier = Modifier
        .padding(start = 30.dp, top = 640.dp, bottom = 5.dp, end = 190.dp)
        .size(width = 230.dp, height = 55.dp)
        .alpha(alpha)) {
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
        .size(width = 230.dp, height = 58.dp)
        .alpha(alpha)) {
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
        modifier = Modifier
            .padding(start = 40.dp, top = 710.dp)
            .alpha(alpha),
        color = Color(R.color.whitegrey),
        fontFamily = manrope,
        fontWeight = FontWeight.W600
    )
}




