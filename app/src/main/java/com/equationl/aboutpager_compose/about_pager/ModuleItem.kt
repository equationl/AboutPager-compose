package com.equationl.aboutpager_compose.about_pager

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.equationl.aboutpager_compose.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModuleItem(
    modifier: Modifier = Modifier,
    title: String? = null,
    backGroundColor: Color = Color.Unspecified,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    shape: Shape = MaterialTheme.shapes.medium,
    titleStyle: TextStyle = MaterialTheme.typography.h5,
    content: @Composable () -> Unit
) {
    Column {
        if (title != null) {
            Text(
                text = title,
                style = titleStyle,
                modifier = Modifier.padding(start = 6.dp)
            )
        }

        Card(
            onClick = { },
            enabled = false,
            modifier = modifier.fillMaxWidth(),
            backgroundColor = backGroundColor,
            border = border,
            elevation = elevation,
            shape = shape
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                content()
            }
        }
    }
}

@Composable
fun BaseSubItem(
    startContent: @Composable () -> Unit,
    endContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    verticalAlignment: Alignment.Vertical = Alignment.Top
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment
    ) {
        startContent()
        endContent()
    }
}

@Composable
fun NormalSubItem(
    startText: String,
    modifier: Modifier = Modifier,
    endText: String? = null,
    startTextStyle: TextStyle = LocalTextStyle.current,
    endTextStyle: TextStyle = LocalTextStyle.current,
    endIcon: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    BaseSubItem(
        modifier = if (onClick != null) modifier.clickable { onClick() } else modifier,
        startContent = {
            Text(text = startText, style = startTextStyle)
        },
        endContent = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (endText != null) {
                    Text(text = endText, style = endTextStyle)
                }
                if (endIcon != null) {
                    endIcon()
                }
            }
        },
        verticalAlignment = Alignment.CenterVertically
    )
}

@Composable
fun NormalWithStartIconSubItem(
    text: String,
    modifier: Modifier = Modifier,
    subText: String? = null,
    textStyle: TextStyle = MaterialTheme.typography.h6,
    subTextStyle: TextStyle = MaterialTheme.typography.body2,
    isAlignIcon: Boolean = true,
    startIcon: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    BaseSubItem(
        modifier = if (onClick != null) modifier.clickable { onClick() } else modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        startContent = {
            Column(Modifier.fillMaxWidth(if (!isAlignIcon && startIcon == null) 0f else 0.2f)) {
                if (startIcon != null) {
                    startIcon()
                }
            }

            Column(modifier = Modifier.padding(start = 6.dp).fillMaxWidth(0.8f)) {
                Text(text = text, style = textStyle)
                if (subText != null) {
                    Text(text = subText, style = subTextStyle)
                }
            }
        },
        endContent = {  }
    )
}

/**
 *
 * @param modifier 承载这个 module 的父 composable 的 modifier
 * */
@Composable
fun NormalSubItemModule(
    itemList: List<NormalSubItemData>,
    modifier: Modifier = Modifier,
    title: String? = null,
    showDivider: Boolean = true,
    showAllDivider: Boolean = false,
    backGroundColor: Color = Color.Unspecified,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    itemPadding: Dp = 6.dp,
    startTextStyle: TextStyle = LocalTextStyle.current,
    endTextStyle: TextStyle = LocalTextStyle.current,
    cardShape: Shape = MaterialTheme.shapes.medium,
    titleStyle: TextStyle = MaterialTheme.typography.h5,
    extraContent: (@Composable () -> Unit)? = null,
    onClick: ((clickNo: Int) -> Unit)? = null
) {
    ModuleItem(
        title = title,
        modifier = modifier,
        backGroundColor = backGroundColor,
        border = border,
        elevation = elevation,
        shape = cardShape,
        titleStyle = titleStyle
    ) {
        if (showAllDivider) {
            Divider(modifier = Modifier.padding(bottom = itemPadding))
        }
        itemList.forEachIndexed { index: Int, normalSubItemData: NormalSubItemData ->
            NormalSubItem(
                normalSubItemData.startText,
                endIcon = normalSubItemData.endIcon,
                onClick =
                    if (onClick == null) null
                    else { { onClick(index) } },
                endText = normalSubItemData.endText,
                modifier = Modifier.padding(bottom = if (!showAllDivider && index == itemList.lastIndex) 0.dp else itemPadding),
                startTextStyle = startTextStyle,
                endTextStyle = endTextStyle
            )
            if (showDivider && index != itemList.lastIndex) {
                Divider(modifier = Modifier.padding(bottom = itemPadding))
            }
        }
        if (showAllDivider) {
            Divider(modifier = Modifier.padding(bottom = itemPadding))
        }
        if (extraContent != null) {
            extraContent()
        }
    }
}

/**
 *
 * @param modifier 承载这个 module 的父 composable 的 modifier
 * */
@Composable
fun NormalWithStartIconSubItemModule(
    itemList: List<NormalSubItemWithStartIconData>,
    modifier: Modifier = Modifier,
    title: String? = null,
    showDivider: Boolean = true,
    showAllDivider: Boolean = false,
    backGroundColor: Color = Color.Unspecified,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    itemPadding: Dp = 6.dp,
    isAlignIcon: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.h6,
    subTextStyle: TextStyle = MaterialTheme.typography.body2,
    cardShape: Shape = MaterialTheme.shapes.medium,
    titleStyle: TextStyle = MaterialTheme.typography.h5,
    extraContent: (@Composable () -> Unit)? = null,
    onClick: ((clickNo: Int) -> Unit)? = null
) {
    ModuleItem(
        title = title,
        modifier = modifier,
        backGroundColor = backGroundColor,
        border = border,
        elevation = elevation,
        shape = cardShape,
        titleStyle = titleStyle
    ) {
        if (showAllDivider) {
            Divider(modifier = Modifier.padding(bottom = itemPadding))
        }
        itemList.forEachIndexed { index: Int, normalSubItemWithStartIconData: NormalSubItemWithStartIconData ->
            NormalWithStartIconSubItem(
                normalSubItemWithStartIconData.text,
                subText = normalSubItemWithStartIconData.subText,
                startIcon = normalSubItemWithStartIconData.startIcon,
                onClick =
                if (onClick == null) null
                else { { onClick(index) } },
                modifier = Modifier.padding(bottom = itemPadding),
                textStyle = textStyle,
                subTextStyle = subTextStyle,
                isAlignIcon = isAlignIcon
            )
            if (showDivider && index != itemList.lastIndex) {
                Divider(modifier = Modifier.padding(bottom = itemPadding))
            }
        }
        if (showAllDivider) {
            Divider(modifier = Modifier.padding(bottom = itemPadding))
        }
        if (extraContent != null) {
            extraContent()
        }
    }
}

data class NormalSubItemData(
    val startText: String,
    val endText: String? = null,
    val endIcon: (@Composable () -> Unit)? = null,
)

data class NormalSubItemWithStartIconData(
    val text: String,
    val subText: String? = null,
    val startIcon: (@Composable () -> Unit)? = null,
)


// ----------- 预览 ------------


@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PreviewModuleItem() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        ModuleItem(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(text = "hahah")
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PreviewNormalSubItem() {
    val text = remember { mutableStateOf("测试列表项") }

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        ModuleItem {
            NormalSubItem(
                text.value,
                endIcon = {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        contentDescription = "arrow"
                    )
                },
                onClick = {
                    text.value = "点击了：${System.currentTimeMillis()}"
                }
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFCCCCCC)
@Composable
fun PreviewNormalWithStartIconSubItem() {
    val text = remember { mutableStateOf("测试列表项") }

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        ModuleItem(title = "模块1") {
            NormalWithStartIconSubItem(
                text = text.value,
                startIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "arrow"
                    )
                },
                subText = "这里是一些其他的描述内容",
                onClick = {
                    text.value = "点击了：${System.currentTimeMillis()}"
                }
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFCCCCCC)
@Composable
fun PreviewNormalSubItemModule() {
    val endIcon = @Composable {
        Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "arrow")
    }
    val itemList1 = listOf(
        NormalSubItemData("列表1", "1.0.0", endIcon),
        NormalSubItemData("列表2", null, endIcon),
        NormalSubItemData("列表3", "1.0.0", endIcon),
        NormalSubItemData("列表4", "1.0.0", endIcon),
        NormalSubItemData("列表5", "1.0.0", endIcon),
        NormalSubItemData("列表6", "1.0.0"),
        NormalSubItemData("列表7", null, endIcon),
        NormalSubItemData("列表8", "1.0.0",),
        NormalSubItemData("列表9", "1.0.0", endIcon),
        NormalSubItemData("列表10", "1.0.0"),
    )

    Column(Modifier.fillMaxSize()) {
        NormalSubItemModule(
            itemList1, title = "模块1"
        )
        NormalSubItemModule(
            itemList1, title = "模块2"
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFCCCCCC)
@Composable
fun PreviewNormalWithStartIconSubItemModule() {
    val startIcon = @Composable {
        Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "arrow")
    }
    val itemList1 = listOf(
        NormalSubItemWithStartIconData("列表1", "这是描述文本", startIcon),
        NormalSubItemWithStartIconData("列表2", null, startIcon),
        NormalSubItemWithStartIconData("列表3", "这是描述文本"),
        NormalSubItemWithStartIconData("列表4", "这是描述文本", startIcon),
        NormalSubItemWithStartIconData("列表5", "这是描述文本", startIcon),
        NormalSubItemWithStartIconData("列表6", "这是描述文本"),
        NormalSubItemWithStartIconData("列表7", null, startIcon),
        NormalSubItemWithStartIconData("列表8", "1.0.0",),
        NormalSubItemWithStartIconData("列表9", "1.0.0", startIcon),
        NormalSubItemWithStartIconData("列表10", "1.0.0"),
    )

    Column(Modifier.fillMaxSize()) {
        NormalWithStartIconSubItemModule(
            itemList1, title = "模块1", isAlignIcon = false
        )
        NormalWithStartIconSubItemModule(
            itemList1, title = "模块2"
        )
    }
}