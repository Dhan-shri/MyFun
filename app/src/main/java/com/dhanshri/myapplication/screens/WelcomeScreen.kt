package com.dhanshri.myapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dhanshri.myapplication.FactComposable
import com.dhanshri.myapplication.TextComponent
import com.dhanshri.myapplication.TextWithShadow
import com.dhanshri.myapplication.TopBar

@Composable
fun WelcomeScreen(username : String?, animalSelected: String?) {

    println("==========InsideWelcomeScreen ${username} ${animalSelected}")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ){
            TopBar(value = "Welcome $username \uD83D\uDE0D")
            
            TextComponent(txtValue = "Thank you !! for sharing your data", textSize = 24.sp )

            Spacer(modifier = Modifier.height(150.dp))

            val finalText = if (animalSelected == "Cat") "Ohh!! You are a Cat Lover \uD83D\uDC36" else "Ohh!! You are a Dog Lover \uD83D\uDC15"

            TextWithShadow(value = finalText)

            val factsViewModel : FactsViewModel = viewModel()
            FactComposable(value = factsViewModel.generateRandomeFact(animalSelected!!))
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("username", "animalSelected")
}