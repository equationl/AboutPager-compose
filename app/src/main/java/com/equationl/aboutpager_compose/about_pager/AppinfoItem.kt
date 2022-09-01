package com.equationl.aboutpager_compose.about_pager

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.equationl.aboutpager_compose.R

/**
 * 头部 APP 信息垂直显示基础 Item
 *
 * @param iconContent 图标内容
 * @param textContent 文本内容
 * @param modifier Modifier
 * */
@Composable
fun AppInfoVerticalItem(
    iconContent: @Composable () -> Unit,
    textContent: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        iconContent()
        textContent()
    }
}

/**
 * 头部 APP 信息垂直显示 item
 *
 * @param iconPaint APP 图标
 * @param modifier Modifier
 * @param text 主文本
 * @param subText 主文本下方的补充文本
 * @param textStyle 主文本样式
 * @param subTextStyle 补充文本样式
 * */
@Composable
fun AppInfoVerticalItem(
    iconPaint: Painter,
    modifier: Modifier = Modifier,
    text: String? = null,
    subText: String? = null,
    textStyle: TextStyle = MaterialTheme.typography.h4,
    subTextStyle: TextStyle = MaterialTheme.typography.body2
) {
    AppInfoVerticalItem(
        iconContent = {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = iconPaint,
                    contentDescription = "icon"
                )
            }
        },
        textContent = {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

                if (text != null) {
                    Text(
                        text = text,
                        style = textStyle,
                        maxLines = 1
                    )
                }

                if (subText != null) {
                    Text(
                        text = subText,
                        style = subTextStyle
                    )
                }

            }
        },
        modifier = modifier
    )
}

/**
 * 头部 APP 信息水平显示基础 Item
 *
 * @param iconContent 图标内容
 * @param textContent 文本内容
 * @param modifier Modifier
 * */
@Composable
fun AppInfoHorizontalItem(
    iconContent: @Composable () -> Unit,
    textContent: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        iconContent()
        textContent()
    }
}

/**
 * 头部 APP 信息水平显示 item
 *
 * @param iconPaint APP 图标
 * @param modifier Modifier
 * @param text 主文本
 * @param subText 主文本下方的补充文本
 * */
@Composable
fun AppInfoHorizontalItem(
    iconPaint: Painter,
    text: String,
    modifier: Modifier = Modifier,
    subText: String? = null
) {
    AppInfoHorizontalItem(
        iconContent = {
            Icon(
                painter = iconPaint,
                contentDescription = "icon"
            )
        },
        textContent = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight().padding(6.dp)
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.h6,
                    maxLines = 1
                )

                if (subText != null) {
                    Text(
                        text = subText,
                        style = MaterialTheme.typography.body2
                    )
                }

            }
        },
        modifier = modifier.fillMaxWidth()
    )
}


@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PreviewVerticalAppInfoItem() {
    AppInfoVerticalItem(
        iconPaint = painterResource(id = R.drawable.ic_launcher_foreground),
        text = "示例APP",
        subText = "V1.0.0"
    )
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PreviewHorizontalAppInfoItem() {
    AppInfoHorizontalItem(
        iconPaint = painterResource(id = R.drawable.ic_launcher_foreground),
        text = "示例APP",
        subText = "V1.0.0",
        modifier = Modifier.height(80.dp)
    )
}