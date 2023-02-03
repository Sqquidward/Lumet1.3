package com.example.lumet13.Activity.Profile.MyFriends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.content.Intent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Maps.userDTO
import com.example.lumet13.Activity.Profile.MyProfileAct
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R
import com.example.lumet13.Request.Retrofit.Models.UserDTO
import com.example.lumet13.Request.Retrofit.RequestListener
import com.example.lumet13.Request.Retrofit.RetrofitRequest
import com.example.lumet13.db.DBHandler

class MyFriendsAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dbHandler: DBHandler = DBHandler(this)

        userDTO = intent.getSerializableExtra("UserDTO") as UserDTO
        val requestListener = object : RequestListener<List<UserDTO>> {
            override fun onFetchData(t: List<UserDTO>) {

                setContent {
                    AppMyFriendsActivity(t)
                }
            }

            override fun onError(message: String?) {
                TODO("Not yet implemented")
            }
        }

        val req = RetrofitRequest()
        req.RequestGetDataUserListById(dbHandler.readUsers()!![0].courseToken, requestListener,
            userDTO.friends!!.friendlist.toList()
        )

    }
}


@Composable
fun AppMyFriendsActivity(userDTO: List<UserDTO>) {
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
                    MyFriendHomeContent(userDTO)
                }
            )

        }

    }
}

@Composable
fun MyFriendHomeContent(userDTO: List<UserDTO>) {
    val friend = remember { userDTO }
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
fun MyFriendsListItem(friend: UserDTO) {
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
            Text(text = friend.login!!,
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

            if(friend.privacystatusChat == "ALL"){
                Image(
                    modifier = Modifier
                        .padding(start = 290.dp)
                        .size(30.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.icon_message),
                    alignment = Alignment.BottomEnd,
                    contentDescription = null
                )
            }
            for (i in 0..(friend.rating!!/2-1)){
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