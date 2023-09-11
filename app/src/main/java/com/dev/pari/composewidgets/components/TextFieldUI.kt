package com.dev.pari.composewidgets.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextFieldUI {

    private lateinit var mContext: Context

    @ExperimentalMaterial3Api
    @Composable
    fun TextFieldUIView(context: Context) {
        mContext = context
        var etUserName by rememberSaveable { mutableStateOf("") }
        var etPassword by rememberSaveable { mutableStateOf("") }
        var outEtEmailId by rememberSaveable { mutableStateOf("") }
        var outEtPassword by rememberSaveable { mutableStateOf("") }
        var outEtName by rememberSaveable { mutableStateOf("") }
        var outEtMobile by rememberSaveable { mutableStateOf("") }
        var isError by rememberSaveable { mutableStateOf(false) }
        val charLimit = 10
        var pwdVisibleState by rememberSaveable { mutableStateOf(false) }

        fun validate(text: String) {
            isError = text.length > charLimit
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            userScrollEnabled = true
        ) {
            item {
//Normal Edittext Field
                Text(text = "Normal Edittext Field", fontSize = 18.sp)
                TextField(
                    value = etUserName,
                    onValueChange = { etUserName = it },
                    label = { Text(text = "User Name") },
                    singleLine = true,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                TextField(
                    value = etPassword, onValueChange = { etPassword = it },
                    label = { Text(text = "Password") }, singleLine = true,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                Button(onClick = {
                    if (etUserName.isEmpty())
                        showToast(mContext, "Please enter your user name")
                    else if (etPassword.isEmpty())
                        showToast(mContext, "Please enter your password")
                    else
                        showToast(mContext, "Username : $etUserName   Password : $etPassword")
                }, shape = RectangleShape) {
                    Text(text = "Login")
                }
//Outlined Edittext Field
                Text(
                    text = "Outlined Edittext Field",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    value = outEtEmailId,
                    placeholder = { Text("Enter your email Id") },
                    onValueChange = {
                        outEtEmailId = it
                    },
                    label = {
                        Text(text = "Email Id")
                    },
                    singleLine = true
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    value = outEtPassword,
                    placeholder = { Text("Enter your password") },
                    onValueChange = {
                        outEtPassword = it
                    },
                    label = {
                        Text(text = "Password")
                    },
                    visualTransformation = if (!pwdVisibleState) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        IconButton(onClick = {
                            pwdVisibleState = !pwdVisibleState
                        }) {
                            if (pwdVisibleState)
                                Icon(imageVector = Icons.Filled.Close, contentDescription = null)
                            else
                                Icon(imageVector = Icons.Filled.Done, contentDescription = null)
                        }
                    },
                    singleLine = true
                )

//Drawable Start and End Edittext Field
                Button(onClick = {
                    if (outEtEmailId.isEmpty())
                        showToast(mContext, "Please enter your email id")
                    else if (outEtPassword.isEmpty())
                        showToast(mContext, "Please enter your password")
                    else
                        showToast(mContext, "EmailId : $outEtEmailId   Password : $outEtPassword")
                }, shape = RoundedCornerShape(30), modifier = Modifier.padding(vertical = 10.dp)) {
                    Text(text = "Login")
                }
                Text(text = "Drawable Start and End Edittext Field", fontSize = 18.sp)
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    value = outEtName,
                    placeholder = { Text("Enter your name") },
                    onValueChange = {
                        outEtName = it
                    },
                    label = {
                        Text(text = "Name")
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Face,
                            contentDescription = null
                        )
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    value = outEtMobile,
                    placeholder = { Text("Enter your mobile number") },
                    onValueChange = {
//                        if (it.length <= 10)
                        outEtMobile = it
                        validate(outEtMobile)
                    },
                    label = {
                        Text(text = "Mobile")
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Phone, contentDescription = null)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    keyboardActions = KeyboardActions(),
                    trailingIcon = {
                        if (isError)
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = null, modifier = Modifier.clickable {
                                    showToast(
                                        mContext,
                                        "Invalid mobile number",
                                    )
                                }
                            )
                    },
                    supportingText = {
                        if (isError)
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Limit: ${outEtMobile.length}/10",
                                textAlign = TextAlign.End,
                                color = Color.Red
                            )
                        else
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Limit: ${outEtMobile.length}/10",
                                textAlign = TextAlign.End,
                                color = Color.Black
                            )

                    },
                    isError = isError,
                )
            }
        }
    }

    private fun showToast(mContext: Context, msg: String) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show()
    }

}