package com.dhanshri.myapplication

import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(value : String,) {
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        ){
        Text(
            text = value,
            color = Color.Black,
            fontSize = 24.sp,
           fontWeight = FontWeight.Medium,
        )

        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = "Native Mobile Bits")
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar("hi there")
}


@Composable
fun TextComponent(txtValue:String, textSize : TextUnit, colorValue: Color = Color.Black) {

    Text(
        text = txtValue,
        color = colorValue,
        fontSize = textSize,
        fontWeight = FontWeight.Black,
    )

}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent("hi there", 24.sp, Color.Black)
}


@Composable
fun TextFieldComponent(
    onTextChanged : (name: String) -> Unit
) {
    var currentValue by remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions{
            // for any custome action after click on keyboard
            localFocusManager.clearFocus()
        }
    )
}
@Preview
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent(onTextChanged = {  })
}


@Composable
fun AnimalCard(image : Int, selected : Boolean,
            animalSelected: (animalName:String) -> Unit  ){
    val localFocusManager = LocalFocusManager.current
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box (

            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp),
                )
        ){
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        val animalName = if (image == R.drawable.dog) "Dog" else "Cat"
                        animalSelected(animalName)
                        localFocusManager.clearFocus()
                    },
                painter = painterResource(id = image),
                contentDescription = "Animal Image"
            )
        }

    }
}

@Preview
@Composable
fun AnimalCardPreview() {
    AnimalCard(0, false, animalSelected = {  })
}



@Composable
fun ButtonComponent(
    goToDetailsScreen : () -> Unit
){
   Button(
       modifier = Modifier
           .fillMaxWidth()
           .height(50.dp),
       onClick = {
           goToDetailsScreen()
       }) {
       TextComponent(txtValue = "Go to Details Screen" , textSize = 18.sp, colorValue = Color.White)
   }
}



