package com.sample.catdetails.view.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sample.catdetails.view.catdetails.CustomText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    backGroundColor: Color = MaterialTheme.colorScheme.primary,
    elevation: Dp = 4.dp,
    borderStroke: Dp = 1.dp,
    borderColor: Color = Color.Gray,
    text: String,
    isBackButtonRequired: Boolean = false,
    onBackClicked: () -> Unit
) {
    Surface(
        color = backGroundColor,
        tonalElevation = elevation,
        border = BorderStroke(borderStroke, borderColor)
    ) {
        TopAppBar(
            title = {
                CustomText(
                    text = text,
                    style = MaterialTheme.typography.headlineMedium
                )
            },
            navigationIcon = {
                if (isBackButtonRequired) {
                    IconButton(onClick = { onBackClicked() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            }
        )
    }
}