package com.example.lumet13.Activity.Events

import android.content.Context
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Maps.MapsAct
import com.example.lumet13.Activity.Maps.userDTO
import com.example.lumet13.Activity.Profile.MyProfileAct
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R
import com.example.lumet13.Request.Retrofit.RequestListener
import com.example.lumet13.Request.Retrofit.RetrofitRequest
import com.example.lumet13.db.DBHandler
import lumetbackend.entities.EventDTO

var eventList = mutableListOf<EventDTO>()
var requestListener = object : RequestListener<List<EventDTO>?> {
    override fun onFetchData(t: List<EventDTO>?) {
        println("test")
    }
    override fun onError(message: String?) {
        println("test")
    }
}

class AllEvents : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventList = mutableListOf()
        val dbHandler: DBHandler = DBHandler(this)


         requestListener = object : RequestListener<List<EventDTO>?> {
            override fun onFetchData(t: List<EventDTO>?) {

                for (i in t!!){
                    eventList.add(i)
                }

                setContent {
                    MyAllEvent()
                }
            }

            override fun onError(message: String?) {
                println("Error")
            }
        }

        val req = RetrofitRequest()
        req.RequestGetDataEvents(dbHandler.readUsers()!![0].courseToken, requestListener)


    }
}

@Composable
fun MyAllEvent() {
    var Context = LocalContext.current
    var openDialog_sort = remember { mutableStateOf(false) }
    Column() {
        Box {

            Button(
                onClick = {

                    Context.startActivity(
                        Intent(Context, MapsAct::class.java)
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    disabledBackgroundColor = Color.White,
                    backgroundColor = Color.White
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
                    contentColor = Color.White,
                    disabledBackgroundColor = Color.White,
                    backgroundColor = Color.White
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
                AlertDialog(
                    onDismissRequest = {
                        openDialog_sort.value = false
                    },
                    modifier = Modifier.size(width = 400.dp, height = 390.dp),
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

                                var min_age by rememberSaveable { mutableStateOf("") }
                                OutlinedTextField(
                                    shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                                    value = min_age,
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
                                    onValueChange = { min_age = it }
                                )

                                var new_rating by rememberSaveable { mutableStateOf("") }
                                OutlinedTextField(
                                    shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                                    value = new_rating,
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
                                    onValueChange = { new_rating = it }
                                )

                                var new_limit by rememberSaveable { mutableStateOf("") }
                                OutlinedTextField(
                                    shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                                    value = new_limit,
                                    textStyle = TextStyle(fontSize = 17.sp),
                                    label = {
                                        Text(
                                            text = "Limit",
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
                                    onValueChange = { new_limit = it }
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
                                        modifier = Modifier.padding(start = 20.dp)
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
                                        modifier = Modifier.padding(start = 20.dp)
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
                                        modifier = Modifier.padding(start = 20.dp)
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
                                        modifier = Modifier.padding(start = 20.dp)
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
                                        modifier = Modifier.padding(start = 20.dp)
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
                                        modifier = Modifier.padding(start = 20.dp)
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
                            }
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
                    textColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                ),
                onValueChange = { search = it }
            )


        }

        Box(
            modifier = Modifier
                .padding(start = 40.dp, top = 15.dp, end = 40.dp)
                .size(width = 400.dp, height = 25.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color(R.color.whitegrey))
        ){
            Text(
                text = eventList.size.toString() + " events",
                fontSize = 11.sp ,
                modifier = Modifier.padding(start = 15.dp, top = 4.dp),
                color = Color.White,
                fontFamily = manrope,
                fontWeight = FontWeight.Bold
            )
        }


        Box(){
            Scaffold(
                content = {
                    ContentEvent(Context)
                }
            )
        }



        Box(
            modifier = Modifier
                .padding(start = 40.dp, top = 10.dp, end = 40.dp)
                .size(width = 400.dp, height = 25.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color(R.color.whitegrey))
        ){
            Text(
                text = "Your friends",
                fontSize = 11.sp ,
                modifier = Modifier.padding(start = 15.dp, top = 4.dp),
                color = Color.White,
                fontFamily = manrope,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ContentEvent(context: Context) {
    val event = remember { eventList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = event,
            itemContent = {
                EventListItem(event = it, context)
            })
    }
}


@Composable
fun EventListItem(event: EventDTO, context: Context) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .size(height = 60.dp, width = 400.dp),
        elevation = 4.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    context.startActivity(
                        Intent(context, ProfileEventAct::class.java).apply { putExtra("EventDTO", event) }
                    )
                }
        ) {
            Text(text = event.name!!,
                fontSize = 17.sp,
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 60.dp, top = 10.dp)
            )

            Text(text = event.desiredage.toString()+ "+",
                fontSize = 13.sp,
                color = Color.Black,
                fontFamily = manrope,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 61.dp, top = 29.dp)
            )



            Box(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .size(35.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = Color.Black)
            ){
                Image(
                    contentScale = ContentScale.Crop,
                    bitmap = ImageBitmap.imageResource(R.drawable.test_photo_biking),

                    contentDescription = null
                )
            }

            if(true){
                Image(
                    modifier = Modifier
                        .padding(start = 290.dp, top = 10.dp)
                        .size(30.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.icon_hobby),
                    alignment = Alignment.BottomEnd,
                    contentDescription = null
                )
            }

        }

    }
}