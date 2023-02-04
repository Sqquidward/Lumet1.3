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
import androidx.compose.ui.layout.ContentScale
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
import com.example.lumet13.Activity.Profile.MyProfileAct
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
    var numberSpisok:List<UserDTO>?
    var Context = LocalContext.current
    var openDialog_sort = remember { mutableStateOf(false) }
    var search by rememberSaveable { mutableStateOf("") }
    var minimal_age : Int = 0

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
                    openDialog_sort.value = true
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



            if (openDialog_sort.value) {
                var min_age by rememberSaveable { mutableStateOf("") }
                AlertDialog(
                    onDismissRequest = {
                        openDialog_sort.value = false
                    },
                    modifier = Modifier.size(width = 400.dp, height = 320.dp),
                    title = { },
                    text = {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(
                                text = "Sorted",
                                fontSize = 18.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = androidx.compose.ui.graphics.Color.Black,
                                modifier = Modifier.padding(start = 10.dp)
                            )

                            Column(modifier = Modifier.padding(top = 30.dp)) {

                                OutlinedTextField(
                                    shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                                    value =  min_age,
                                    textStyle = TextStyle(fontSize = 17.sp),
                                    label = {
                                        Text(
                                            text = "Minimum age",
                                            fontSize = 13.sp,
                                            fontFamily = manrope,
                                            fontWeight = FontWeight.Bold
                                        )
                                    },
                                    modifier = Modifier
                                        .padding(start = 10.dp, top = 5.dp)
                                        .width(260.dp)
                                        .height(58.dp),
                                    //leadingIcon = { Icon(Icons.Filled, contentDescription = "Проверено") },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = androidx.compose.ui.graphics.Color.Black,
                                        focusedLabelColor = androidx.compose.ui.graphics.Color.Black,
                                        unfocusedLabelColor = androidx.compose.ui.graphics.Color.Black,
                                        focusedBorderColor = androidx.compose.ui.graphics.Color.Black,
                                        unfocusedBorderColor = androidx.compose.ui.graphics.Color.Black
                                    ),
                                    onValueChange = {  min_age = it }
                                )

                                var new_age by rememberSaveable { mutableStateOf("") }
                                OutlinedTextField(
                                    shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                                    value = new_age,
                                    textStyle = TextStyle(fontSize = 17.sp),
                                    label = {
                                        Text(
                                            text = "Rating",
                                            fontSize = 13.sp,
                                            fontFamily = manrope,
                                            fontWeight = FontWeight.Bold
                                        )
                                    },
                                    modifier = Modifier
                                        .padding(start = 10.dp, top = 5.dp)
                                        .width(260.dp)
                                        .height(58.dp),
                                    //leadingIcon = { Icon(Icons.Filled, contentDescription = "Проверено") },
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = androidx.compose.ui.graphics.Color.Black,
                                        focusedLabelColor = androidx.compose.ui.graphics.Color.Black,
                                        unfocusedLabelColor = androidx.compose.ui.graphics.Color.Black,
                                        focusedBorderColor = androidx.compose.ui.graphics.Color.Black,
                                        unfocusedBorderColor = androidx.compose.ui.graphics.Color.Black
                                    ),
                                    onValueChange = { new_age = it }
                                )

                                Text(
                                    text = "Hobby type",
                                fontSize = 18.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = androidx.compose.ui.graphics.Color.Black,
                                modifier = Modifier.padding(start = 10.dp)
                                )

                                var flag1: Boolean = false
                                var flag2: Boolean = false
                                var flag3: Boolean = false
                                if(flag1) {
                                    Text(
                                        text = "Biking",
                                        fontSize = 15.sp,
                                        fontFamily = manrope,
                                        fontWeight = FontWeight.W900,
                                        color = androidx.compose.ui.graphics.Color.Black,
                                        modifier = Modifier
                                            .padding(start = 20.dp)
                                            .clickable(onClick = {
                                                flag1 = true
                                                flag2 = false
                                                flag3 = false
                                            })
                                    )
                                }
                                else {
                                    Text(
                                        text = "Biking",
                                        fontSize = 15.sp,
                                        fontFamily = manrope,
                                        fontWeight = FontWeight.SemiBold,
                                        color = androidx.compose.ui.graphics.Color.Black,
                                        modifier = Modifier
                                            .padding(start = 20.dp)
                                            .clickable(onClick = {
                                                flag1 = true
                                                flag2 = false
                                                flag3 = false
                                            })
                                    )
                                }
                                if(flag2) {
                                    Text(
                                        text = "Running",
                                        fontSize = 15.sp,
                                        fontFamily = manrope,
                                        fontWeight = FontWeight.W900,
                                        color = androidx.compose.ui.graphics.Color.Black,
                                        modifier = Modifier
                                            .padding(start = 20.dp)
                                            .clickable(onClick = {
                                                flag2 = true
                                                flag1 = false
                                                flag3 = false
                                            })
                                    )
                                }
                                else {
                                    Text(
                                        text = "Running",
                                        fontSize = 15.sp,
                                        fontFamily = manrope,
                                        fontWeight = FontWeight.SemiBold,
                                        color = androidx.compose.ui.graphics.Color.Black,
                                        modifier = Modifier
                                            .padding(start = 20.dp)
                                            .clickable(onClick = {
                                                flag1 = true
                                                flag2 = false
                                                flag3 = false
                                            })
                                    )
                                }


                                if(flag3) {
                                    Text(
                                        text = "Swimming",
                                        fontSize = 15.sp,
                                        fontFamily = manrope,
                                        fontWeight = FontWeight.W900,
                                        color = androidx.compose.ui.graphics.Color.Black,
                                        modifier = Modifier
                                            .padding(start = 20.dp)
                                            .clickable(onClick = {
                                                flag3 = true
                                                flag2 = false
                                                flag1 = false
                                            })
                                    )
                                }
                                else {
                                    Text(
                                        text = "Swimming",
                                        fontSize = 15.sp,
                                        fontFamily = manrope,
                                        fontWeight = FontWeight.SemiBold,
                                        color = androidx.compose.ui.graphics.Color.Black,
                                        modifier = Modifier
                                            .padding(start = 20.dp)
                                            .clickable(onClick = {
                                                flag1 = true
                                                flag2 = false
                                                flag3 = false
                                            })
                                    )
                                }
                            }
                        }
                    },
                    buttons = {
                        Box {
                            Button(onClick = {
                                openDialog_sort.value = false
                            },

                                colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color.White, contentColor = androidx.compose.ui.graphics.Color.Black),
                                modifier = Modifier
                                    .padding(start = 30.dp, bottom = 10.dp)
                                    .size(width = 120.dp, height = 35.dp),
                                shape = RoundedCornerShape(20)
                            )
                            {
                                Text("Close", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                            }

                            Button(onClick = {
                                openDialog_sort.value = false
                            },

                                colors = ButtonDefaults.buttonColors(backgroundColor = androidx.compose.ui.graphics.Color.White, contentColor = androidx.compose.ui.graphics.Color.Black),
                                modifier = Modifier
                                    .padding(start = 160.dp, bottom = 10.dp)
                                    .size(width = 120.dp, height = 35.dp),
                                shape = RoundedCornerShape(20)
                            )
                            {
                                Text("Apply", fontSize = 13.sp, fontFamily = manrope, fontWeight = FontWeight.Bold)
                                try {

                                } catch (ex: NumberFormatException) {

                                }
                            }
                        }



                    }
                )
            }



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
                text = usersList.size.toString() + " your friends",
                fontSize = 11.sp ,
                modifier = Modifier.padding(start = 15.dp, top = 4.dp),
                color = androidx.compose.ui.graphics.Color.White,
                fontFamily = manrope,
                fontWeight = FontWeight.Bold
            )
        }

        var usersSearchList = mutableListOf<UserDTO>()
        var flag:Boolean = true
        for (n in 0..(usersList.size-1)){
            if(usersList[n].login!!.contains(search) && search != ""){
                usersSearchList.add(usersList[n])
            }
        }
        println(minimal_age)
        try {
            for (n in 0..(usersList.size-1)){
                if(usersList[n].age != null){
                    if((usersList[n].age!!.toInt() <= minimal_age) && (minimal_age != 0)){
                        println(usersList)
                        usersSearchList.add(usersList[n])
                    }
                }

            }
        }catch (ex: NumberFormatException){}


        if(usersSearchList.size != 0){
            Box(){
                Scaffold(
                    content = {
                        BarkHomeContent(usersSearchList)
                    }
                )
            }
        }



            Box(){
                Scaffold(
                    content = {
                        BarkHomeContent(usersList)
                    }
                )
            }




    }
}

@Composable
fun BarkHomeContent(usList: List<UserDTO>) {
    val users = remember { usList }
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
    var Context = LocalContext.current
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
                    modifier = Modifier
                        .padding(start = 35.dp)
                        .clickable(onClick = {
                            Context.startActivity(
                                Intent(Context, UserProfile::class.java)
                            )
                        })
                )



                Box(
                    modifier = Modifier
                        .padding(start = 0.dp, top = 0.dp)
                        .size(27.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(color = androidx.compose.ui.graphics.Color.Black)
                ){
                    Image(
                        contentScale = ContentScale.Crop,
                        bitmap = ImageBitmap.imageResource(R.drawable.test_photo1),

                        contentDescription = null
                    )
                }

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

@Composable
fun PuppyListItemSearch(user: UserDTO) {
    var Context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 10.dp)
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
                modifier = Modifier
                    .padding(start = 35.dp)
                    .clickable(onClick = {
                        Context.startActivity(
                            Intent(Context, UserProfile::class.java)
                        )
                    })
            )



            Box(
                modifier = Modifier
                    .padding(start = 0.dp, top = 0.dp)
                    .size(27.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = androidx.compose.ui.graphics.Color.Black)
            ){
                Image(
                    contentScale = ContentScale.Crop,
                    bitmap = ImageBitmap.imageResource(R.drawable.test_photo1),

                    contentDescription = null
                )
            }

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