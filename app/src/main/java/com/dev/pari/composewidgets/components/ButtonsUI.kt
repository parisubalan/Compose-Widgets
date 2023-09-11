package com.dev.pari.composewidgets.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.pari.composewidgets.R

class ButtonsUI {
    private lateinit var mContext: Context

    @Composable
    fun ButtonsView(context: Context) {
        mContext = context
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                val modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceAround) {
                        Button(
                            shape = RectangleShape,
                            onClick = {
                                showToast(mContext, "Normal Button")
                            },
                            modifier = modifier
                        ) {
                            Text(text = "Normal Button")
                        }

                        OutlinedButton(shape = CircleShape, onClick = {
                            showToast(mContext, "Outlined Button")
                        }, modifier = modifier) {
                            Text(text = "Outlined Button")
                        }
                    }
                    Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceAround) {
                        OutlinedButton(
                            shape = RoundedCornerShape(5.dp),
                            onClick = {
                                showToast(mContext, "Shaped Button")
                            },
                            modifier = modifier
                        ) {
                            Text(text = "Shaped Button")
                        }

                        Button(
                            shape = CutCornerShape(5.dp),
                            onClick = {
                                showToast(mContext, "Corner Cut Button")
                            },
                            modifier = modifier
                        ) {
                            Text(text = "Corner Cut Button")
                        }
                    }
                    Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceAround) {

                        OutlinedButton(
                            shape = RoundedCornerShape(10.dp),
                            onClick = {},
                            modifier = modifier
                        ) {
                            Row(modifier = Modifier) {
                                Icon(imageVector = Icons.Filled.Call, contentDescription = null)
                                Text(
                                    text = "Icon+Text+Icon",
                                    modifier = Modifier
                                )
                                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                            }
                        }
                    }
                    Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceAround) {
                        val horizontalGradiant = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFFF5722),
                                Color(0xFFFFFFFF),
                                Color(0xFF005804)
                            )
                        )

                        val verticalGradiant = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFFF5722),
                                Color(0xFFFFFFFF),
                                Color(0xFF005804)
                            )
                        )
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .background(brush = horizontalGradiant)
                                .clickable { }
                                .clip(
                                    RoundedCornerShape(20)
                                )
                                .then(Modifier.padding(10.dp))
                        ) {
                            Text(text = "Horizontal Gradiant")
                        }

                        Column(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .background(brush = verticalGradiant)
                                .clickable { }
                                .clip(
                                    RoundedCornerShape(20)
                                )
                                .then(Modifier.padding(10.dp))
                        ) {
                            Text(text = "Vertical Gradiant")
                        }
                    }
                    Row(
                        modifier = Modifier.padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        FloatingActionButton(
                            onClick = {},
                            shape = CircleShape,
                            modifier = modifier
                        ) {
                            Icon(imageVector = Icons.Filled.AddCircle, contentDescription = null)
                        }

                        ExtendedFloatingActionButton(
                            shape = RectangleShape,
                            icon = {
                                Icon(
                                    imageVector = Icons.Filled.Face,
                                    contentDescription = null
                                )
                            },
                            text = { Text(text = "Completed") },
                            onClick = {},
                            modifier = modifier.wrapContentSize(),
                        )
                    }
                    Row(modifier = Modifier, horizontalArrangement = Arrangement.SpaceAround) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFF8F95F8),
                            modifier = Modifier.then(Modifier.padding(10.dp))
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                    Image(
                                        painter = painterResource(R.drawable.avatar_1_raster),
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .size(20.dp)
                                            .clip(CircleShape),
                                        contentDescription = null
                                    )
                                Text(
                                    text = "Chip Text",
                                    style = MaterialTheme.typography.bodyLarge,
                                )
                                Surface(color = Color.DarkGray, modifier = modifier, shape = CircleShape) {
                                    IconButton(
                                        onClick = {},
                                        modifier = Modifier
                                            .size(16.dp)
                                            .padding(1.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Close,
                                            tint = Color(0xFFE0E0E0),
                                            contentDescription = null
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun showToast(mContext: Context, toastMsg: String) {
        Toast.makeText(mContext, toastMsg, Toast.LENGTH_SHORT).show()
    }

    @Preview(showBackground = true)
    @Composable
    fun ButtonViewPreview() {
        ButtonsView(LocalContext.current)
    }
}

