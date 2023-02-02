package com.example.lumet13.JCview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.lumet13.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumet13.Fonts.manrope


@Composable
fun TextField(label:String, verticalSize:Int, text:String, onTextChange: (String) -> Unit){
    OutlinedTextField(
        shape = MaterialTheme.shapes.small.copy(CornerSize(15.dp)),
        value = text,
        textStyle = TextStyle(fontSize = 17.sp),
        label = { Text(text = label, fontSize = 17.sp, fontFamily = manrope, fontWeight = FontWeight.Bold) },
        modifier = Modifier
            .padding(start = 37.dp, top = verticalSize.dp, end = 37.dp)
            .width(320.dp)
            .height(58.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White,
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White),
        onValueChange = onTextChange

    )
}


@Composable
fun backgroung(){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.DarkGray))



    Box(
        modifier = Modifier.fillMaxSize()){
        Image(
            modifier = Modifier,
            contentScale = ContentScale.Crop,
            bitmap = ImageBitmap.imageResource(R.drawable.background),
            contentDescription = null
        )
    }


    Text(text = "Lumet",
        fontFamily = manrope,
        fontWeight = FontWeight.SemiBold,
        color = Color.White,
        maxLines = 1,
        fontSize = 56.sp,
        style = LocalTextStyle.current,
        modifier = Modifier.padding(start = 151.dp, top = 151.dp)
        //horizontal = 131.dp, vertical = 127.dp
    )


}

