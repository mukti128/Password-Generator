package com.example.passwordgenerator

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun generatePassword(
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

    var addPass = ""
    if (isUpperCaseLetter) addPass += upperCaseLetter
    if (isLowerCaseLetter) addPass += lowerCaseLetter
    if (isNumber) addPass += number
    if (isSymbols) addPass += symbols

    if (addPass.isEmpty()) return ""

    return (1..length)
        .map { addPass.random() }
        .joinToString("")
}

@Composable
fun PasswordGeneratorScreen() {
    var password by remember { mutableStateOf("") }
    var passwordLength by remember { mutableStateOf("") }
    var isUpperCaseLetter by remember { mutableStateOf(false) }
    var isLowerCaseLetter by remember { mutableStateOf(false) }
    var isNumber by remember { mutableStateOf(false) }
    var isSymbols by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
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

                Row(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = password,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .width(200.dp)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Button(
                        onClick = {
                            password = generatePassword(
                                length = passwordLength.toIntOrNull() ?: 0,
                                isUpperCaseLetter = isUpperCaseLetter,
                                isLowerCaseLetter = isLowerCaseLetter,
                                isNumber = isNumber,
                                isSymbols = isSymbols,
                            )
                        }
                    ) {
                        Text(
                            text = "Spin",
                            fontSize = 18.sp
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Password length: $passwordLength"
                    )

                    Spacer(modifier = Modifier.width(100.dp))

                    OutlinedTextField(
                        value = passwordLength,
                        onValueChange = {passwordLength = it},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .width(100.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = "Characters used:"
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(
                        modifier = Modifier
                    ) {
                        // UpperCase
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                        ) {
                            Button(
                                onClick = { isUpperCaseLetter = !isUpperCaseLetter},
                                shape = CircleShape,
                                border = BorderStroke(1.dp, Color.Black),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color.Black
                                ),
                                elevation = null,
                                contentPadding = PaddingValues(0.dp),
                                modifier = Modifier.size(40.dp)
                            ) {
                                if (isUpperCaseLetter) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                } else {
                                    // TODO
                                }
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = "ABC"
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // LowerCase
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                        ) {
                            Button(
                                onClick = { isLowerCaseLetter = !isLowerCaseLetter},
                                shape = CircleShape,
                                border = BorderStroke(1.dp, Color.Black),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color.Black
                                ),
                                elevation = null,
                                contentPadding = PaddingValues(0.dp),
                                modifier = Modifier.size(40.dp)
                            ) {
                                if (isLowerCaseLetter) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                } else {
                                    // TODO
                                }
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = "abc"
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Number
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                        ) {
                            Button(
                                onClick = { isNumber = !isNumber},
                                shape = CircleShape,
                                border = BorderStroke(1.dp, Color.Black),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color.Black
                                ),
                                elevation = null,
                                contentPadding = PaddingValues(0.dp),
                                modifier = Modifier.size(40.dp)
                            ) {
                                if (isNumber) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                } else {
                                    // TODO
                                }
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = "123"
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Symbols
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                        ) {
                            Button(
                                onClick = { isSymbols = !isSymbols},
                                shape = CircleShape,
                                border = BorderStroke(1.dp, Color.Black),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Color.Black
                                ),
                                elevation = null,
                                contentPadding = PaddingValues(0.dp),
                                modifier = Modifier.size(40.dp)
                            ) {
                                if (isSymbols) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                } else {
                                    // TODO
                                }
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = "#$&"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PasswordGeneratorScreenPreview() {
    PasswordGeneratorScreen()
}
