package com.example.lumet13.Activity.Users

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Events.starDraw
import com.example.lumet13.Activity.Maps.MapsAct
import com.example.lumet13.Activity.Maps.userDTO
import com.example.lumet13.Activity.Users.ui.theme.Lumet13Theme
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R
import com.example.lumet13.Request.Retrofit.Models.UserDTO
import com.example.lumet13.Request.Retrofit.RequestListener
import com.example.lumet13.Request.Retrofit.RetrofitRequest
import com.example.lumet13.db.DBHandler
import com.google.android.gms.maps.model.MarkerOptions
import lumetbackend.entities.EventDTO

var usersList = mutableListOf<UserDTO>()
class AllUsers : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        usersList = mutableListOf()
        val dbHandler: DBHandler = DBHandler(this)
        val requestListener = object : RequestListener<List<UserDTO>> {
            override fun onFetchData(t: List<UserDTO>) {

                for( i in t){
                    usersList.add(i)
                }


                setContent {
                    MyApp()
                }
            }

            override fun onError(message: String?) {
                println("Error")
            }
        }

        val req = RetrofitRequest()
        req.RequestGetDataAllUsers(dbHandler.readUsers()!![0].courseToken, requestListener)

    }
}

@Composable
fun MyApp() {
    var Context = LocalContext.current
    var openDialog = remember { mutableStateOf(false) }
    Column() {
        Box {

            Button(
                onClick = {
                    Context.startActivity(
                        Intent(Context, MapsAct::class.java)
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = androidx.compose.ui.graphics.Color.White,
                    disabledBackgroundColor = androidx.compose.ui.graphics.Color.White,
                    backgroundColor = androidx.compose.ui.graphics.Color.White
                ),
                modifier = Modifier
                    .padding(start = 330.dp, top = 13.dp)
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

            Button(
                onClick = {
                    openDialog.value = true
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = androidx.compose.ui.graphics.Color.White,
                    disabledBackgroundColor = androidx.compose.ui.graphics.Color.White,
                    backgroundColor = androidx.compose.ui.graphics.Color.White
                ),
                modifier = Modifier
                    .padding(start = 275.dp, top = 13.dp)
                    .size(width = 50.dp, height = 49.dp),
                shape = RoundedCornerShape(30)
            ) {
                Image(
                    modifier = Modifier.padding(),
                    bitmap = ImageBitmap.imageResource(R.drawable.icon_sort),
                    alignment = Alignment.BottomEnd,
                    contentDescription = null
                )
            }

            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        openDialog.value = false
                    },
                    title = { Text(text = "Тута будут настройки") },
                    text = { Text("И тут тоже") },
                    buttons = {
                        Button(
                            onClick = { openDialog.value = false }
                        ) {
                            Text("OK да", fontSize = 22.sp)
                        }
                    }
                )
            }


            var search by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                value = search,
                textStyle = TextStyle(fontSize = 17.sp),
                label = {
                    Text(
                        text = "Search",
                        fontSize = 17.sp,
                        fontFamily = manrope,
                        fontWeight = FontWeight.Bold
                    )
                },
                modifier = Modifier
                    .padding(start = 10.dp, top = 5.dp)
                    .width(260.dp)
                    .height(58.dp),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Проверено") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = androidx.compose.ui.graphics.Color.Black,
                    focusedLabelColor = androidx.compose.ui.graphics.Color.Black,
                    unfocusedLabelColor = androidx.compose.ui.graphics.Color.Black,
                    focusedBorderColor = androidx.compose.ui.graphics.Color.Black,
                    unfocusedBorderColor = androidx.compose.ui.graphics.Color.Black
                ),
                onValueChange = { search = it }
            )


        }

        Box(
            modifier = Modifier
                .padding(start = 40.dp, top = 15.dp, end = 40.dp)
                .size(width = 400.dp, height = 25.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = androidx.compose.ui.graphics.Color(R.color.whitegrey))
        ){
            Text(
                text = usersList.size.toString() + " people want to add you as a friend",
                fontSize = 11.sp ,
                modifier = Modifier.padding(start = 15.dp, top = 4.dp),
                color = androidx.compose.ui.graphics.Color.White,
                fontFamily = manrope,
                fontWeight = FontWeight.Bold
            )
        }


        Box(){
            Scaffold(
                content = {
                    BarkHomeContent()
                }
            )
        }



        Box(
            modifier = Modifier
                .padding(start = 40.dp, top = 10.dp, end = 40.dp)
                .size(width = 400.dp, height = 25.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = androidx.compose.ui.graphics.Color(R.color.whitegrey))
        ){
            Text(
                text = "Your friends",
                fontSize = 11.sp ,
                modifier = Modifier.padding(start = 15.dp, top = 4.dp),
                color = androidx.compose.ui.graphics.Color.White,
                fontFamily = manrope,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun BarkHomeContent() {
    val users = remember { usersList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = users,
            itemContent = {
                PuppyListItem(user = it)
            })
    }
}


@Composable
fun PuppyListItem(user: UserDTO) {
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
                    .clickable {
                        println("JHGJK")
                    }
            ) {
                Text(text = user.login!!,
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

                if(user.privacystatusChat == "ALL"){
                    Image(
                        modifier = Modifier
                            .padding(start = 290.dp)
                            .size(30.dp),
                        bitmap = ImageBitmap.imageResource(R.drawable.icon_message),
                        alignment = Alignment.BottomEnd,
                        contentDescription = null
                    )
                }
                for (i in 0..((user.rating!!)/2-1)){
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