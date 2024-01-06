package com.dhanshri.myapplication.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserInputViewModel :ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())

    companion object{
        const val TAG = "UserInputViewModel"
    }
    fun onEvent(event : UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(nameEntered = event.name)
                Log.d(TAG, "onEvent:UserNameEntered ${uiState.value.nameEntered}")
                Log.d(TAG, "onEvent:UiStateValues ${uiState.value}")
            }
            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(animalSelected = event.animalValue)
                Log.d(TAG, "onEvent:AnimalSelected ${uiState.value.animalSelected}")
            }
        }
    }

    fun isValidState() : Boolean{
        return !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()
    }
}



//We can define in different clas as well
data class UserInputScreenState(
    var nameEntered : String ="",
    var animalSelected : String = " "
)

sealed class UserDataUiEvents{
    data class UserNameEntered(val name : String) : UserDataUiEvents()
    data class AnimalSelected(val animalValue : String) : UserDataUiEvents()
}