package com.equationl.aboutpager_compose.about_pager

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BaseTextItem(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        content()
    }
}

@Composable
fun RightsTextItem(
    dateText: String,
    name: String,
    style: TextStyle = LocalTextStyle.current
) {
    Text(text = "Copyright © $dateText $name All Rights Reserved.", style = style)
}

@Composable
fun LinkText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 12.sp,
    color: Color = MaterialTheme.colors.primary,
    onClick: () -> Unit) {

    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        modifier = modifier.noRippleClickable(onClick = onClick) )
}

inline fun Modifier.noRippleClickable(crossinline onClick: ()->Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFCCCCCC)
@Composable
fun PreviewTextItem() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
        BaseTextItem {
            Row {
                LinkText(text = "隐私协议") { }
                Text(text = "|", modifier = Modifier.padding(horizontal = 4.dp))
                LinkText(text = "隐私政策") { }
            }

            RightsTextItem(dateText = "2022", name = "equationl")
        }
    }
}
