package com.dev.pari.composewidgets.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class RowColumUI {
    @Composable
    fun ContentViews() {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp), userScrollEnabled = true) {
            item {
                TitleText(title = "Row Example")
                RowExample()

                TitleText(title = "Column Example")
                ColumExample()
            }
        }

    }

    @Composable
    private fun RowExample() {
        val modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp)
        ContentText("Arrangement.Start")
        Row(modifier = modifier, horizontalArrangement = Arrangement.Start) {
            TextSample(sampleText = "Row1")
            TextSample(sampleText = "Row2")
            TextSample(sampleText = "Row3")
        }
        ContentText("Arrangement.End")
        Row(modifier = modifier, horizontalArrangement = Arrangement.End) {
            TextSample(sampleText = "Row1")
            TextSample(sampleText = "Row2")
            TextSample(sampleText = "Row3")
        }
        ContentText("Arrangement.Center")
        Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
            TextSample(sampleText = "Row1")
            TextSample(sampleText = "Row2")
            TextSample(sampleText = "Row3")
        }

        ContentText("Arrangement.SpaceEvenly")
        Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
            TextSample(sampleText = "Row1")
            TextSample(sampleText = "Row2")
            TextSample(sampleText = "Row3")
        }
        ContentText("Arrangement.SpaceAround")
        Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround) {
            TextSample(sampleText = "Row1")
            TextSample(sampleText = "Row2")
            TextSample(sampleText = "Row3")
        }
        ContentText("Arrangement.SpaceBetween")
        Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
            TextSample(sampleText = "Row1")
            TextSample(sampleText = "Row2")
            TextSample(sampleText = "Row3")
        }

    }

    @Composable
    private fun ColumExample() {
        val modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp)
            .height(200.dp)
            .background(color = Color(0xFF929292))

        ContentText("Arrangement.Top")
        Column(modifier = modifier, verticalArrangement = Arrangement.Top) {
            TextSample(sampleText = "Column1")
            TextSample(sampleText = "Column2")
            TextSample(sampleText = "Column3")
        }

        ContentText("Arrangement.Center")
        Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
            TextSample(sampleText = "Column1")
            TextSample(sampleText = "Column2")
            TextSample(sampleText = "Column3")
        }

        ContentText("Arrangement.Bottom")
        Column(modifier = modifier, verticalArrangement = Arrangement.Bottom) {
            TextSample(sampleText = "Column1")
            TextSample(sampleText = "Column2")
            TextSample(sampleText = "Column3")
        }

        ContentText("Arrangement.Center")
        Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
            TextSample(sampleText = "Column1")
            TextSample(sampleText = "Column2")
            TextSample(sampleText = "Column3")
        }

        ContentText("Arrangement.SpaceEvenly")
        Column(modifier = modifier, verticalArrangement = Arrangement.SpaceEvenly) {
            TextSample(sampleText = "Column1")
            TextSample(sampleText = "Column2")
            TextSample(sampleText = "Column3")
        }

        ContentText("Arrangement.SpaceAround")
        Column(modifier = modifier, verticalArrangement = Arrangement.SpaceAround) {
            TextSample(sampleText = "Column1")
            TextSample(sampleText = "Column2")
            TextSample(sampleText = "Column3")
        }

        ContentText("Arrangement.SpaceBetween")
        Column(modifier = modifier, verticalArrangement = Arrangement.SpaceBetween) {
            TextSample(sampleText = "Column1")
            TextSample(sampleText = "Column2")
            TextSample(sampleText = "Column3")
        }
    }

    @Composable
    private fun TextSample(sampleText: String) {
        Text(
            text = sampleText, modifier = Modifier
                .background(color = Color(0xFFFF0000)), color = Color(0xFFFFFFFF)
        )
    }

    @Composable
    private fun ContentText(title: String) {
        Text(
            text = title, modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 5.dp), color = Color(0xFF757575)
        )
    }

    @Composable
    private fun TitleText(title: String) {
        Text(
            text = title, modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 5.dp),
            color = Color(0xFF000000),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}