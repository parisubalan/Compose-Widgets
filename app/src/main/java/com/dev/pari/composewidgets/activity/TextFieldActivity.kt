package com.dev.pari.composewidgets.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dev.pari.composewidgets.components.TextFieldUI
import com.dev.pari.composewidgets.ui.theme.ComposeWidgetsTheme

class TextFieldActivity : ComponentActivity() {

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWidgetsTheme {
                TextFieldUI().TextFieldUIView(context = this)
            }
        }
    }

    @ExperimentalMaterial3Api
    @Preview(showBackground = true)
    @Composable
    fun TextFieldPreview() {
        TextFieldUI().TextFieldUIView(this)
    }
}