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

/**
 * 一个独立的模块，使用 Card 作为载体
 *
 * @param modifier Modifier
 * @param title 模块标题，会被置于载体 Card 之外
 * @param backGroundColor Card 背景颜色
 * @param border Card 变宽
 * @param elevation Card 高度（会影响 Card 的阴影深度）
 * @param shape Card 形状（可自定义形状或增加圆角）
 * @param titleStyle 标题文本的样式
 * @param content 内容
 * */
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
            // 将标题文本放到 Card 外面，这样比较美观
            Text(
                text = title,
                style = titleStyle,
                modifier = Modifier.padding(start = 6.dp)
            )
        }

        Card(
            onClick = { }, // 其实这里只是将 card 作为外部载体使用，不需要直接点击 card，但是这个参数是必须的，所以直接传一个空的给它
            enabled = false, // 禁用点击
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

/**
 * 基础 Item 载体，使用 Row 作为载体承载内容
 *
 * @param startContent 左边的内容
 * @param endContent 右边的内容
 * @param modifier Modifier
 * @param horizontalArrangement 水平对齐方式
 * @param verticalAlignment 垂直对齐方式
 * */
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

/**
 * 一般 Item，显示效果形如普通文本列表，但是可以添加尾部图标与尾部文字，建议包裹在 [NormalSubItemModule] 使用
 *
 * @param startText 主文本，位于列表最左边
 * @param modifier Modifier
 * @param endText 辅助文本，位于列表最右边，但是在 [endIcon] 左边
 * @param startTextStyle 主文本样式
 * @param endTextStyle 辅助文本样式
 * @param endIcon 尾部图标
 * @param onClick 点击回调
 * */
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
        // 这里如果没有设置点击回调则不添加 clickable，因为如果即使添加的是空 lambda 也会有点击涟漪效果，不太美观
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

/**
 * 带有前导图标的一般 Item ，显示效果类似对话框，建议包裹在 [NormalWithStartIconSubItemModule] 中使用
 *
 * @param text 主文本
 * @param modifier Modifier
 * @param subText 辅助文本
 * @param textStyle 主文本样式
 * @param subTextStyle 辅助文本样式
 * @param isAlignIcon 是否留空，如果设置为 true，那么即使没有图标也会将图标位置留空占位
 * @param startIcon 图标
 * @param onClick 点击回调
 * */
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
            // 如果条件满足的话，即使图标为空，也要把位置留空出来，即 fillMaxWidth(0.2f)
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
        // 由于该组件风格不是严格的左右布局，所以这里将内容全放入 startContent 中，不使用 endContent
        endContent = {  }
    )
}

/**
 *
 * 用于承载 [NormalSubItem] 的模块，会将传入的所有 [NormalSubItem] 放入同一个 Card 中
 *
 * @param itemList 内容列表
 * @param modifier 承载这个 module 的父 composable 的 modifier
 * @param title 该模块标题
 * @param showDivider 是否在 item 之间显示分割线
 * @param showAllDivider 是否在第一个 item 之前 和 最后一个 item 之后显示分割线
 * @param backGroundColor 模块背景颜色
 * @param border 模块边框
 * @param elevation 模块高度（影响阴影深度）
 * @param itemPadding item 之间的 padding
 * @param startTextStyle 主文本样式
 * @param endTextStyle 辅助文本样式
 * @param cardShape 模块形状
 * @param titleStyle 标题样式
 * @param extraContent 额外的子定义内容，会在最后显示
 * @param onClick 点击回调，参数为点击的 item 索引
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
 * 用于承载 [NormalWithStartIconSubItem] 的模块，会将传入的所有 [NormalWithStartIconSubItem] 放入同一个 Card 中
 *
 * @param itemList 内容列表
 * @param modifier 承载这个 module 的父 composable 的 modifier
 * @param title 该模块标题
 * @param showDivider 是否在 item 之间显示分割线
 * @param showAllDivider 是否在第一个 item 之前 和 最后一个 item 之后显示分割线
 * @param backGroundColor 模块背景颜色
 * @param border 模块边框
 * @param elevation 模块高度（影响阴影深度）
 * @param itemPadding item 之间的 padding
 * @param textStyle 主文本样式
 * @param subTextStyle 辅助文本样式
 * @param cardShape 模块形状
 * @param titleStyle 标题样式
 * @param extraContent 额外的子定义内容，会在最后显示
 * @param onClick 点击回调，参数为点击的 item 索引
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