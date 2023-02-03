package com.example.lumet13.Activity.Events

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Activity.Maps.MapsAct
import com.example.lumet13.Fonts.manrope
import com.example.lumet13.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

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
    var openDialog_userLimit = remember { mutableStateOf(false) }
    var openDialog_place = remember { mutableStateOf(false) }
    var openDialog_timeSpend = remember { mutableStateOf(false) }

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
    ){
        Image(
            contentScale = ContentScale.Crop,
            bitmap = ImageBitmap.imageResource(R.drawable.test_photo_biking),

            contentDescription = null
        )
    }


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

    var animatedd by remember { mutableStateOf(false) }
    val size by animateDpAsState(
        targetValue = if (animatedd) 40.dp else 0.dp,
        animationSpec = tween(durationMillis = 0, delayMillis = 400)
    )
    val sizeWidth by animateDpAsState(
        targetValue = if (animatedd) 7.dp else 0.dp,
        animationSpec = tween(durationMillis = 0, delayMillis = 400)
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
        .padding(top = 436.dp, start = 261.dp + size)
        .clip(shape = RoundedCornerShape(8.dp))
        .size(height = 23.dp, width = 44.dp - sizeWidth)
        .background(Color.White))

    var color1:Color = Color.White
    var color2:Color = Color.Black

    if(!animatedd){
        color1 = Color.Black
        color2 = Color.White
    }
    Text(
        text = "Yes" ,
        fontSize = 15.sp ,
        color = color1,
        modifier = Modifier
            .padding(start = 271.dp, top = 436.dp)
            .clickable(onClick = {
                animatedd = false
            }),
        fontFamily = manrope,
        fontWeight = FontWeight.Bold,
        )


    Text(
        text = "No" ,
        fontSize = 15.sp ,
        modifier = Modifier
            .padding(start = 310.dp, top = 436.dp)
            .clickable(onClick = {
                animatedd = true
            }),
        color = color2,
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


    AletrDialogAge()
    AletrDialogLimit()
    AletrDialogTime()
    AletrDialoMaps()
}

@Composable
fun AletrDialogAge(){
    var Context = LocalContext.current
    var openDialog_age = remember { mutableStateOf(false) }
    val age = rememberSaveable { mutableStateOf("18+") }
    var aged :String = "18"

    Box(modifier = Modifier
        .padding(top = 540.dp, start = 316.dp)
        .clip(shape = RoundedCornerShape(9.dp))
        .size(height = 23.dp, width = 23.dp)
        .background(
            Color.White
        )
        .clickable(onClick = {
            openDialog_age.value = true
        })){
        Image(
            modifier = Modifier
                .padding(start = 4.dp, top = 6.dp)
                .size(12.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }

    if (openDialog_age.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog_age.value = false
            },
            modifier = Modifier.size(width = 200.dp, height = 260.dp),
            title = {  },
            text = {
                Box(modifier = Modifier.fillMaxSize()){
                    Text(text = "Choose age", fontSize = 16.sp, fontFamily = manrope, fontWeight = FontWeight.SemiBold, color = Color.Black, modifier = Modifier.padding())
                    Column(modifier = Modifier.padding(top = 30.dp)){
                        Box(

                        ){
                            Text(text = "12+",
                                fontSize = 16.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                modifier = Modifier.clickable(onClick = {
                                    age.value = "12+"
                                    Toast.makeText(Context, age.value, Toast.LENGTH_SHORT).show()
                                    openDialog_age.value = false
                                }))

                        }
                        Box(
                            modifier = Modifier.padding(top = 7.dp)
                        ){
                            Text(text = "14+",
                                fontSize = 16.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                modifier = Modifier.clickable(onClick = {
                                    age.value = "14+"
                                    Toast.makeText(Context, age.value, Toast.LENGTH_SHORT).show()
                                    openDialog_age.value = false
                                }))

                        }
                        Box(
                            modifier = Modifier.padding(top = 7.dp)
                        ){
                            Text(text = "16+",
                                fontSize = 16.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                modifier = Modifier.clickable(onClick = {
                                    age.value = "16+"
                                    Toast.makeText(Context, age.value, Toast.LENGTH_SHORT).show()
                                    openDialog_age.value = false

                                }))

                        }
                        Box(
                            modifier = Modifier.padding(top = 7.dp)
                        ){
                            Text(text = "18+",
                                fontSize = 16.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                modifier = Modifier.clickable(onClick = {
                                    age.value = "18+"
                                    Toast.makeText(Context, age.value, Toast.LENGTH_SHORT).show()
                                    openDialog_age.value = false
                                }))

                        }
                        Box(
                            modifier = Modifier.padding(top = 7.dp)
                        ){
                            Text(text = "20+",
                                fontSize = 16.sp,
                                fontFamily = manrope,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                modifier = Modifier.clickable(onClick = {
                                    age.value = "20+"
                                    Toast.makeText(Context, age.value, Toast.LENGTH_SHORT).show()
                                    openDialog_age.value = false
                                }))

                        }


                    }
                }
            },
            buttons = {
                Button(onClick = {openDialog_age.value = false },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                    modifier = Modifier
                        .padding(
                            start = 25.dp,
                            top = 20.dp,
                            bottom = 10.dp
                        )
                        .height(35.dp)
                        .width(150.dp),
                    shape = RoundedCornerShape(20)) {
                    Text("Close", fontSize = 15.sp, fontFamily = manrope, fontWeight = FontWeight.Bold, color = Color.Black)
                }
            }
        )
    }
    if(age.value == "12+"){
        Text(
            text = age.value,
            fontSize = 15.sp ,
            modifier = Modifier.padding(start = 280.dp, top = 541.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    }
    if(age.value == "14+"){
        Text(
            text = age.value,
            fontSize = 15.sp ,
            modifier = Modifier.padding(start = 280.dp, top = 541.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    }
    if(age.value == "16+"){
        Text(
            text = age.value,
            fontSize = 15.sp ,
            modifier = Modifier.padding(start = 280.dp, top = 541.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    }
    if(age.value == "18+"){
        Text(
            text = age.value,
            fontSize = 15.sp ,
            modifier = Modifier.padding(start = 280.dp, top = 541.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    }
    if(age.value == "20+"){
        Text(
            text = age.value,
            fontSize = 15.sp ,
            modifier = Modifier.padding(start = 280.dp, top = 541.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    }


}


@Composable
fun AletrDialogLimit() {
    var Context = LocalContext.current
    var openDialog_limit = remember { mutableStateOf(false) }
    var limit by rememberSaveable { mutableStateOf("8") }


    if (limit == "8") {
        Text(
            text = limit,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 285.dp, top = 572.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    } else {
        Text(
            text = limit,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 285.dp, top = 572.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    }


    Box(
        modifier = Modifier
            .padding(top = 570.dp, start = 316.dp)
            .clip(shape = RoundedCornerShape(9.dp))
            .size(height = 23.dp, width = 23.dp)
            .background(
                Color.White
            )
            .clickable(onClick = {
                openDialog_limit.value = true
            })
    ) {
        Image(
            modifier = Modifier
                .padding(start = 4.dp, top = 6.dp)
                .size(12.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }

    if (openDialog_limit.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog_limit.value = false
            },
            modifier = Modifier.size(width = 300.dp, height = 200.dp),
            title = { },
            text = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Change limit",
                        fontSize = 16.sp,
                        fontFamily = manrope,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.padding()
                    )
                    Column(modifier = Modifier.padding(top = 30.dp)) {

                        var limit by rememberSaveable { mutableStateOf("") }
                        OutlinedTextField(
                            shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                            value = limit,
                            textStyle = TextStyle(fontSize = 17.sp),
                            label = {
                                Text(
                                    text = "New limit",
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
                                textColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Black
                            ),
                            onValueChange = { limit = it }
                        )
                    }
                }
            },
            buttons = {
                Box {
                    Button(
                        onClick = {
                            openDialog_limit.value = false
                        },

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .padding(start = 30.dp, bottom = 10.dp)
                            .size(width = 240.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text(
                            "Close",
                            fontSize = 13.sp,
                            fontFamily = manrope,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

            }
        )
    }
}


@Composable
fun AletrDialogTime() {
    var Context = LocalContext.current
    var openDialog_time = remember { mutableStateOf(false) }
    var time by rememberSaveable { mutableStateOf("10:30") }


    if (time == "8") {
        Text(
            text = time,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 269.dp, top = 473.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    } else {
        Text(
            text = time,
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 269.dp, top = 473.dp),
            color = Color.White,
            fontFamily = manrope,
            fontWeight = FontWeight.Bold
        )
    }
    Box(modifier = Modifier
        .padding(top = 472.dp, start = 316.dp)
        .clip(shape = RoundedCornerShape(9.dp))
        .size(height = 23.dp, width = 23.dp)
        .background(
            Color.White
        )
        .clickable(onClick = {
            openDialog_time.value = true
        })){
        Image(
            modifier = Modifier
                .padding(start = 4.dp, top = 6.dp)
                .size(12.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }


    if (openDialog_time.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog_time.value = false
            },
            modifier = Modifier.size(width = 300.dp, height = 200.dp),
            title = { },
            text = {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Meeting time",
                        fontSize = 16.sp,
                        fontFamily = manrope,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier.padding()
                    )
                    Column(modifier = Modifier.padding(top = 30.dp)) {

                        var limit by rememberSaveable { mutableStateOf("") }
                        OutlinedTextField(
                            shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
                            value = limit,
                            textStyle = TextStyle(fontSize = 17.sp),
                            label = {
                                Text(
                                    text = "Time",
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
                                textColor = Color.Black,
                                focusedLabelColor = Color.Black,
                                unfocusedLabelColor = Color.Black,
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color.Black
                            ),
                            onValueChange = { limit = it }
                        )
                    }
                }
            },
            buttons = {
                Box {
                    Button(
                        onClick = {
                            openDialog_time.value = false
                        },

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .padding(start = 30.dp, bottom = 10.dp)
                            .size(width = 240.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text(
                            "Close",
                            fontSize = 13.sp,
                            fontFamily = manrope,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

            }
        )
    }
}


@Composable
fun AletrDialoMaps() {
    var Context = LocalContext.current
    var openDialog_maps = remember { mutableStateOf(false) }
    var time by rememberSaveable { mutableStateOf("10:30") }


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
        ).clickable(onClick = {
            openDialog_maps.value = true
        })){
        Image(
            modifier = Modifier
                .padding(start = 5.dp, top = 5.dp)
                .size(12.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.icon_edit),
            alignment = Alignment.BottomEnd,
            contentDescription = null
        )
    }

    if (openDialog_maps.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog_maps.value = false
            },
            modifier = Modifier.size(width = 400.dp, height = 400.dp),
            title = { },
            text = {
                Box(modifier = Modifier.fillMaxSize()) {

                    Box {
                        val pos1 = LatLng(44.810058, 20.4627586)
                        val cameraPositionState = rememberCameraPositionState {
                            position = CameraPosition.fromLatLngZoom(pos1, 17f)
                        }

                        GoogleMap(
                            modifier = Modifier.fillMaxSize(),
                            cameraPositionState = cameraPositionState)
                        {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                IconButton(
                                    onClick = { /*TODO*/ },
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.iconplace),
                                        contentDescription = "Marker",
                                    )
                                }
                                Text(text = "Is camera moving ${cameraPositionState.isMoving}" +
                                        "\n x and y: ${cameraPositionState.position.target.latitude} and ${cameraPositionState.position.target.longitude}",
                                textAlign = TextAlign.Center)
                            }
                        }
                    }
                }
            },
            buttons = {
                Box {
                    Button(
                        onClick = {
                            openDialog_maps.value = false
                        },

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .padding(start = 30.dp, bottom = 10.dp)
                            .size(width = 240.dp, height = 35.dp),
                        shape = RoundedCornerShape(20)
                    )
                    {
                        Text(
                            "Close",
                            fontSize = 13.sp,
                            fontFamily = manrope,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }

            }
        )
    }

}




