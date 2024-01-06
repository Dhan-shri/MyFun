package com.dhanshri.myapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dhanshri.myapplication.AnimalCard
import com.dhanshri.myapplication.ButtonComponent
import com.dhanshri.myapplication.R
import com.dhanshri.myapplication.TextComponent
import com.dhanshri.myapplication.TextFieldComponent
import com.dhanshri.myapplication.TopBar
import com.dhanshri.myapplication.ui.theme.UserDataUiEvents
import com.dhanshri.myapplication.ui.theme.UserInputViewModel


@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
    Surface(modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        )
        {
//            TopBar("Hi there \uD83D\uDC4B")
            TopBar("Hi there \uD83D\uDE0A")

            TextComponent(
                txtValue = "Let's learn about you!",
                textSize = 24.sp)

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                txtValue = "This app will prepare a details page based on input provided by you !",
                textSize = 18.sp)

            Spacer(modifier = Modifier.size(26.dp))

            TextComponent(txtValue = "Name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))
            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(txtValue = "What do you like", textSize = 18.sp)


            Row(modifier = Modifier.fillMaxWidth()){
                AnimalCard(image = R.drawable.cat, animalSelected = {
                           userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")


                AnimalCard(image = R.drawable.dog, animalSelected = {
                    userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                }, selected = userInputViewModel.uiState.value.animalSelected == "Dog")
            }

            Spacer(modifier = Modifier.weight(1f))

//            if (!userInputViewModel.uiState.value.nameEntered.isNullOrEmpty() && !userInputViewModel.uiState.value.animalSelected.isNullOrEmpty()){
//                ButtonComponent(
//                    goToDetailsScreen = {
//
//                    }
//                )
//            }
            if (userInputViewModel.isValidState()){
                ButtonComponent(
                    goToDetailsScreen = {
                        println("===========Coming here")
                        println("=========== ${userInputViewModel.uiState.value.animalSelected} ${userInputViewModel.uiState.value.nameEntered}")
                    }
                )
            }

        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel())
}