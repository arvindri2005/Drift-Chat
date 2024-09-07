package com.drift.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DriftChatInputField(
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = modifier,
        label = { Text("Type a message") },
        textStyle = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(500),
                color = Color(0xFF9498A1),
            ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF3d4354),
            unfocusedContainerColor = Color(0xFF3d4354),
            focusedLabelColor = Color(0xFF9498a1),
            unfocusedLabelColor = Color(0xFF9498a1),
        ),
        shape = RoundedCornerShape(15.dp),
    )

}

@Preview
@Composable
fun DriftChatInputFieldPreview() {
    DriftChatInputField()
}