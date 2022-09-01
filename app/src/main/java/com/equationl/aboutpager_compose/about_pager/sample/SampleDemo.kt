package com.equationl.aboutpager_compose.about_pager.sample

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.equationl.aboutpager_compose.MyViewModel
import com.equationl.aboutpager_compose.R
import com.equationl.aboutpager_compose.about_pager.*


@Composable
fun HomeScreen(viewModel: MyViewModel) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { viewModel.pagerIndex = 1 }) {
            Text(text = "仿 橙APP")
        }
        Button(onClick = { viewModel.pagerIndex = 2 }) {
            Text(text = "仿 微信")
        }
        Button(onClick = { viewModel.pagerIndex = 3 }) {
            Text(text = "仿 QQ")
        }
        Button(onClick = { viewModel.pagerIndex = 4 }) {
            Text(text = "仿 一个木函")
        }
        Button(onClick = { viewModel.pagerIndex = 5 }) {
            Text(text = "仿 LibChecker")
        }
        Button(onClick = { viewModel.pagerIndex = 6 }) {
            Text(text = "仿 隐云图解制作")
        }
    }
}

@Composable
fun AboutChengPager() {
    val list = remember {
        listOf(
            NormalSubItemData("用户协议", endIcon = endArrow),
            NormalSubItemData("隐私政策", endIcon = endArrow)
        )
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F3F3))) {
        AboutScreen(
            topContent = {
                AppInfoVerticalItem(
                    iconPaint = painterResource(id = R.drawable.ic_launcher_foreground),
                    text = "橙 App",
                    subText = "版本 3.13.2(204)",
                    modifier = Modifier.padding(bottom = 32.dp),
                    textStyle = MaterialTheme.typography.body1.copy(color = Color(0xFF404040)),
                    subTextStyle = MaterialTheme.typography.body2.copy(color = Color(0xFF7F7F7F))
                )
            },
            mainContent = {
                NormalSubItemModule(
                    itemList = list,
                    backGroundColor = Color.White,
                    startTextStyle = LocalTextStyle.current.copy(color = Color(0xFF404040)),
                    itemPadding = 12.dp
                )
            }
        )
    }
}

@Composable
fun AboutWechatPager() {
    val list = remember {
        listOf(
            NormalSubItemData("功能介绍", endIcon = endArrow),
            NormalSubItemData("投诉", endIcon = endArrow),
            NormalSubItemData("检查新版本", endIcon = endArrow)
        )
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        AboutScreen(
            topContent = {
                AppInfoVerticalItem(
                    iconPaint = painterResource(id = R.drawable.ic_launcher_foreground),
                    text = "微信",
                    subText = "Version 8.0.27",
                    modifier = Modifier.padding(bottom = 32.dp, top=16.dp),
                    textStyle = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Black),
                    subTextStyle = MaterialTheme.typography.body2
                )
            },
            mainContent = {
                NormalSubItemModule(
                    itemList = list,
                    backGroundColor = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    border = BorderStroke(0.dp, Color.Transparent),
                    elevation = 0.dp,
                    showAllDivider = true,
                    itemPadding = 12.dp
                )
            },
            bottomContent = {
                BaseTextItem {
                    LinkText(text = "《软件许可及服务协议》", color = Color(0xFF5B6A81)) {}
                    Row {
                        LinkText(text = "《隐私保护指引摘要》", color = Color(0xFF5B6A81)) {}
                        LinkText(text = "《隐私保护指引》", color = Color(0xFF5B6A81)) {}
                    }
                    Text(text = "客服电话：400 670 0700", color = Color(0xFFB1B1B1))
                    Text(text = "腾讯公司 版权所有", color = Color(0xFFB1B1B1))
                    RightsTextItem(
                        dateText = "2011-2022",
                        name = "Tencent.",
                        style = LocalTextStyle.current.copy(color = Color(0xFFB1B1B1))
                    )
                }
            },
            keepBottomInBottom = true
        )
    }
}

@Composable
fun AboutQqPager() {
    val list = remember {
        listOf(
            NormalSubItemData("功能介绍", endIcon = endArrow),
            NormalSubItemData("官网", endIcon = endArrow, endText = "有新版本可用"),
            NormalSubItemData("帮助", endIcon = endArrow),
            NormalSubItemData("反馈", endIcon = endArrow)
        )
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FB))) {
        AboutScreen(
            topContent = {
                AppInfoVerticalItem(
                    iconPaint = painterResource(id = R.drawable.ic_launcher_foreground),
                    subText = "V 8.9.3.8730",
                    modifier = Modifier.padding(bottom = 32.dp, top=16.dp),
                    subTextStyle = MaterialTheme.typography.body2.copy(color = Color(0xFFB3B3BD))
                )
            },
            mainContent = {
                NormalSubItemModule(
                    itemList = list,
                    backGroundColor = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .padding(bottom = 6.dp),
                    startTextStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                    endTextStyle = LocalTextStyle.current.copy(color = Color(0xFF939393)),
                    border = BorderStroke(width = 0.dp, color = Color.Transparent)
                )
            },
            bottomContent = {
                BaseTextItem {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        LinkText(text = "服务协议", color = Color(0xFF115AA9)) {}

                        Text(text=" | ", color = Color(0xFF5A9CD9))

                        LinkText(text = "隐私政策", color = Color(0xFF115AA9)) {}
                    }
                    Text(text = "客户服务热线-4006700700", color = Color(0xFFAFAFAF))
                    RightsTextItem(
                        dateText = "2009-2022",
                        name = "Tencent.",
                        style = LocalTextStyle.current.copy(color = Color(0xFFAFAFAF))
                    )
                }
            },
            keepBottomInBottom = true
        )
    }
}

@Composable
fun AboutBoxPager() {
    val list = remember {
        listOf(
            NormalSubItemWithStartIconData("给我好评", subText = "您的好评将会给予我们莫大的动力与帮助", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("加入群组", subText = "加入官方群组，与四海函友交友互水", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("分享应用", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("小程序", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("反馈&建议", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("获取帮助", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("版本状态", subText = "7.10.2-normal", startIcon = boxSampleIcon)
        )
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)) {
        AboutScreen(
            topContent = {
                Column(
                    modifier = Modifier.background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFF89B6A2),
                                Color.White
                            )
                        )
                    )
                ) {
                    ModuleItem(
                        modifier = Modifier
                            .padding(12.dp)
                            .background(Color.White)) {
                        Column(modifier = Modifier.padding(bottom = 16.dp)) {
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                                Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "logo")
                            }
                            BaseTextItem {
                                Text(
                                    text = "拥有很多，不如有我。",
                                    Modifier.padding(vertical = 6.dp),
                                    style = MaterialTheme.typography.h6
                                )
                            }
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                Row {
                                    Icon(
                                        imageVector = Icons.Outlined.Star,
                                        contentDescription = "star",
                                        modifier = Modifier.padding(start = 16.dp, end=12.dp),
                                        tint = Color.Cyan
                                    )

                                    Icon(
                                        imageVector = Icons.Outlined.Star,
                                        contentDescription = "star",
                                        tint = Color.Magenta
                                    )
                                }
                                LinkText(
                                    text = "开源许可",
                                    modifier = Modifier.padding(end = 16.dp),
                                    color = Color(0xFF89B6A2)
                                ) {}
                            }
                        }
                    }
                }
            },
            mainContent = {
                NormalWithStartIconSubItemModule(
                    itemList = list,
                    modifier = Modifier.padding(12.dp),
                    backGroundColor = Color.White,
                    showDivider = false,
                    elevation = 2.dp,
                    itemPadding = 24.dp,
                    textStyle = MaterialTheme.typography.h6.copy(color = Color(0xFF404040)),
                    subTextStyle = MaterialTheme.typography.body2.copy(color = Color(0xFF797979)),
                    cardShape = RoundedCornerShape(12.dp), // 定义模块框的形状，这里使用圆角，且圆角大小为 12 dp
                    extraContent = {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp), horizontalArrangement = Arrangement.End) {
                            Row(Modifier.fillMaxWidth(0.5f), horizontalArrangement = Arrangement.SpaceEvenly) {
                                LinkText(text = "隐私政策", color = Color(0xFF89B6A2)) { }
                                LinkText(text = "用户协议", color = Color(0xFF89B6A2)) { }
                            }
                        }
                    }
                )
            },
            bottomContent = {
                BaseTextItem {
                    Text(
                        text = "花筏科技 版权所有",
                        modifier = Modifier.padding(bottom = 16.dp, start = 8.dp),
                        color = Color(0xFF797979)
                    )
                    RightsTextItem(
                        dateText = "2017-2022",
                        name = "Sakuraft",
                        style = LocalTextStyle.current.copy(color = Color(0xFF797979))
                    )
                }
            }
        )
    }
}

@Composable
fun AboutLibPager() {
    val sampleIcon = @Composable {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "icon", tint = Color(0xFF797979))
        }
    }

    val developerList = remember {
        listOf(
            NormalSubItemWithStartIconData("developer1", subText = "developer description", startIcon = sampleIcon),
            NormalSubItemWithStartIconData("developer2", subText = "developer description", startIcon = sampleIcon),
        )
    }

    val otherWorkList = remember {
        listOf(
            NormalSubItemWithStartIconData("Work1", subText = "Work description", startIcon = sampleIcon),
        )
    }

    val contributorList = remember {
        listOf(
            NormalSubItemWithStartIconData("contributorList", subText = "contributorList description", startIcon = sampleIcon)
        )
    }

    val openSourceList = remember {
        listOf(
            NormalSubItemWithStartIconData("openSource", subText = "openSource description"),
            NormalSubItemWithStartIconData("openSource", subText = "openSource description"),
            NormalSubItemWithStartIconData("openSource", subText = "openSource description"),
            NormalSubItemWithStartIconData("openSource", subText = "openSource description"),
            NormalSubItemWithStartIconData("openSource", subText = "openSource description"),
        )
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F1F1))) {
        AboutScreen(
            topContent = {
                AppInfoVerticalItem(
                    iconPaint = painterResource(id = R.drawable.ic_launcher_foreground),
                    text = "LibChecker",
                    subText = "Version: 2.2.3.abdjsb21",
                    modifier = Modifier
                        .background(Color(0xFF6101EB))
                        .padding(bottom = 32.dp, top = 16.dp),
                    textStyle = MaterialTheme.typography.body1.copy(color = Color.White),
                    subTextStyle = MaterialTheme.typography.body2.copy(color = Color.White),
                )
            },
            mainContent = {
                NormalSubItemModule(
                    itemList = listOf(),
                    title = "What's this",
                    backGroundColor = Color.White,
                    titleStyle = MaterialTheme.typography.body1.copy(color = Color(0xFF737373)),
                    extraContent = {
                        Text(text = "这是一些关于应用的描述\n这是第二行")
                    }
                )

                NormalWithStartIconSubItemModule(
                    itemList = developerList,
                    title = "Developers",
                    titleStyle = MaterialTheme.typography.body1.copy(color = Color(0xFF737373)),
                    backGroundColor = Color.White,
                    showDivider = false
                )

                NormalWithStartIconSubItemModule(
                    itemList = otherWorkList,
                    title = "Other Works",
                    titleStyle = MaterialTheme.typography.body1.copy(color = Color(0xFF737373)),
                    backGroundColor = Color.White,
                    showDivider = false
                )

                // 下面这些其实就是重复组件，为了能够一屏显示完，这里给注释掉

                /*NormalWithStartIconSubItemModule(
                    itemList = contributorList,
                    title = "Contribution",
                    titleStyle = MaterialTheme.typography.body1.copy(color = Color(0xFF737373)),
                    backGroundColor = Color.White,
                    showDivider = false
                )*/

                /*NormalSubItemModule(
                    itemList = listOf(),
                    title = "Acknowledgement",
                    titleStyle = MaterialTheme.typography.body1.copy(color = Color(0xFF737373)),
                    backGroundColor = Color.White,
                    extraContent = {
                        Text(text = "这是一些关于版权的描述：\n第二行")
                    }
                )*/

                /*NormalSubItemModule(
                    itemList = listOf(),
                    title = "Declaration",
                    titleStyle = MaterialTheme.typography.body1.copy(color = Color(0xFF737373)),
                    backGroundColor = Color.White,
                    extraContent = {
                        Text(text = "这是一些声明")
                    }
                )*/

                NormalWithStartIconSubItemModule(
                    itemList = openSourceList,
                    titleStyle = MaterialTheme.typography.body1.copy(color = Color(0xFF737373)),
                    title = "Open Source Licenses",
                    backGroundColor = Color.White,
                    isAlignIcon = false
                )
            }
        )
    }
}

@Composable
fun AboutVspPager() {
    Text(text = "这个没啥特殊的样式，不仿了！\n(〃￣︶￣)人(￣︶￣〃)")
}

val endArrow =  @Composable {
    Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "arrow", tint = Color(0xFFD0D0D0))
}

val boxSampleIcon = @Composable {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Icon(imageVector = Icons.Outlined.Star, contentDescription = "star", tint = Color(0xFF797979))
    }
}


@Preview()
@Composable
fun PreviewDemo() {
    Column(modifier = Modifier.fillMaxSize()) {
        AboutLibPager()
    }
}