package com.example.lumet13.Activity.Profile.MyFriends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lumet13.Activity.Profile.MyFriends.ui.theme.Lumet13Theme
import com.example.lumet13.Activity.Users.User
import com.example.lumet13.Activity.Users.usersList
import android.content.Intent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection.Companion.Content

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Events.starDraw
import com.example.lumet13.Activity.Maps.MapsAct
import com.example.lumet13.Activity.Profile.MyProfileAct
import com.example.lumet13.Activity.Users.ui.theme.Lumet13Theme
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R
import com.example.lumet13.Request.Retrofit.Models.UserDTO
import com.example.lumet13.Request.Retrofit.RequestListener
import com.example.lumet13.Request.Retrofit.RetrofitRequest
import com.google.android.gms.maps.model.MarkerOptions
import lumetbackend.entities.EventDTO

class MyFriendsAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val requestListener = object : RequestListener<List<UserDTO>> {
            override fun onFetchData(t: List<UserDTO>) {
                TODO("Not yet implemented")
            }

            override fun onError(message: String?) {
                TODO("Not yet implemented")
            }
        }

      //  val req = RetrofitRequest()
      //  req.RequestGetDataAllUsers("token", requestListener)

        setContent {
            AppMyFriendsActivity()
        }
    }
}


@Composable
fun AppMyFriendsActivity() {
    var Context = LocalContext.current
    Column() {
        Box {


            Button(
                onClick = {
                    Context.startActivity(
                        Intent(Context, MyProfileAct::class.java)
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = androidx.compose.ui.graphics.Color.White,
                    disabledBackgroundColor = androidx.compose.ui.graphics.Color.White,
                    backgroundColor = androidx.compose.ui.graphics.Color.White
                ),
                modifier = Modifier
                    .padding(start = 320.dp, top = 13.dp)
                    .size(width = 50.dp, height = 49.dp),
                shape = RoundedCornerShape(30)
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
                    .padding(start = 24.dp, top = 10.dp)
                    .size(height = 55.dp, width = 280.dp)
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
                    text = "Friends",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 70.dp, top = 5.dp),
                    color = androidx.compose.ui.graphics.Color.White,
                    fontFamily = manrope,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Box(modifier = Modifier.padding(top = 10.dp)){
            Scaffold(
                content = {
                    MyFriendHomeContent()
                }
            )

        }

    }
}

@Composable
fun MyFriendHomeContent() {
    val friend = remember { friendList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = friend,
            itemContent = {
                MyFriendsListItem(friend = it)
            })
    }
}


@Composable
fun MyFriendsListItem(friend: Friend) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .size(height = 60.dp, width = 400.dp),
        elevation = 3.dp,
        backgroundColor = androidx.compose.ui.graphics.Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {

        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(text = friend.name,
                fontSize = 18.sp,
                color = androidx.compose.ui.graphics.Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 35.dp)
            )

            Image(

                bitmap = ImageBitmap.imageResource(R.drawable.roundblack),
                modifier = Modifier
                    .padding(start = 0.dp, top = 0.dp),
                alignment = Alignment.BottomEnd,
                contentDescription = null
            )

            if(friend.privacity){
                Image(
                    modifier = Modifier
                        .padding(start = 290.dp)
                        .size(30.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.icon_message),
                    alignment = Alignment.BottomEnd,
                    contentDescription = null
                )
            }
            for (i in 0..(friend.rating-1)){
                Image(
                    modifier = Modifier
                        .padding(start = 30.dp + (i * 11).dp, top = 21.dp)
                        .size(14.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.star_black),
                    alignment = Alignment.BottomEnd,
                    contentDescription = null
                )
            }

        }

    }
}