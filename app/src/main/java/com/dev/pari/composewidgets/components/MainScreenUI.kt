package com.dev.pari.composewidgets.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.dev.pari.composewidgets.activity.ButtonsActivity
import com.dev.pari.composewidgets.activity.RowColumActivity
import com.dev.pari.composewidgets.activity.TextFieldActivity

class MainScreenUI {

    @Composable
    fun MainUI(context: Context) {
        LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Button(shape = RectangleShape, onClick = {
                    val intent = Intent(context, RowColumActivity::class.java)
                    context.startActivity(intent)
                }, modifier = Modifier.padding(vertical = 10.dp)) {
                    Text(text = "Row and Colum")
                }

                Button(shape = RectangleShape, onClick = {
                    val intent = Intent(context, ButtonsActivity::class.java)
                    context.startActivity(intent)
                }, modifier = Modifier.padding(vertical = 10.dp)) {
                    Text(text = "Buttons")
                }

                Button(shape = RectangleShape, onClick = {
                    val intent = Intent(context, TextFieldActivity::class.java)
                    context.startActivity(intent)
                }, modifier = Modifier.padding(vertical = 10.dp)) {
                    Text(text = "Text fields")
                }
            }
        }
    }

}