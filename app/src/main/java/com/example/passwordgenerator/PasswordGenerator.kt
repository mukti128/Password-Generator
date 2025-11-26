package com.example.passwordgenerator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun GeneratePassword(
    length: Int,
    isUpperCaseLetter: Boolean,
    isLowerCaseLetter: Boolean,
    isNumber: Boolean,
    isSymbols: Boolean,
): String {
    val upperCaseLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowerCaseLetter = "abcdefghijklmnopqrstuvwxyz"
    val number = "1234567890"
    val symbols = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~"

    val addPass = ""
    if (isUpperCaseLetter == true) addPass + upperCaseLetter
    if (isLowerCaseLetter == true) addPass + lowerCaseLetter
    if (isNumber == true) addPass + number
    if (isSymbols == true) addPass + symbols

    return (1..length)
        .map { addPass.random() }
        .joinToString()
}

@Composable
fun PasswordGeneratorScreen() {
    var password by remember { mutableStateOf("") }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Password Generator",
                    fontSize = 30.sp,
                    color = Color.Blue
                )

                Row {
                    TextField(
                        value = password,
                        onValueChange = {password = it}
                    )
                }
            }
        }
    }
}
