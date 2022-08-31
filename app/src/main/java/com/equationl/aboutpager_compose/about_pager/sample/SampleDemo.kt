package com.equationl.aboutpager_compose.about_pager.sample

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    modifier = Modifier.padding(bottom = 32.dp)
                )
            },
            mainContent = {
                NormalSubItemModule(itemList = list, backGroundColor = Color.White)
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
                    modifier = Modifier.padding(bottom = 32.dp, top=16.dp)
                )
            },
            mainContent = {
                NormalSubItemModule(
                    itemList = list,
                    backGroundColor = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    border = BorderStroke(0.dp, Color.Transparent),
                    elevation = 0.dp,
                    showAllDivider = true
                )
            },
            bottomContent = {
                BaseTextItem {
                    LinkText(text = "《软件许可及服务协议》") {}
                    Row {
                        LinkText(text = "《隐私保护指引摘要》") {}
                        LinkText(text = "《隐私保护指引》") {}
                    }
                    Text(text = "客服电话：400 670 0700")
                    Text(text = "腾讯公司 版权所有")
                    RightsTextItem(dateText = "2011-2022", name = "Tencent")
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
                    modifier = Modifier.padding(bottom = 32.dp, top=16.dp)
                )
            },
            mainContent = {
                NormalSubItemModule(
                    itemList = list,
                    backGroundColor = Color.White,
                    modifier = Modifier.padding(horizontal = 12.dp),
                )
            },
            bottomContent = {
                BaseTextItem {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        LinkText(text = "服务协议") {}

                        Text(text=" | ")

                        LinkText(text = "隐私政策") {}
                    }
                    Text(text = "客户服务热线-4006700700")
                    RightsTextItem(dateText = "2009-2022", name = "Tencent.")
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
                 ModuleItem(modifier = Modifier.padding(12.dp)) {
                     Column(modifier = Modifier.padding(bottom = 16.dp)) {
                         Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                             Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "logo")
                         }
                         BaseTextItem {
                             Text(text = "拥有很多，不如有我。", Modifier.padding(vertical = 6.dp))
                         }
                         Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                             Row {
                                 Icon(imageVector = Icons.Outlined.Star, contentDescription = "star", modifier = Modifier.padding(start = 16.dp, end=12.dp))
                                 Icon(imageVector = Icons.Outlined.Star, contentDescription = "star")
                             }
                             LinkText(text = "开源许可", modifier = Modifier.padding(end = 16.dp)) {}
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
                    itemPadding = 12.dp,
                    extraContent = {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp), horizontalArrangement = Arrangement.End) {
                            Row(Modifier.fillMaxWidth(0.5f), horizontalArrangement = Arrangement.SpaceEvenly) {
                                LinkText(text = "隐私政策") { }
                                LinkText(text = "用户协议") { }
                            }
                        }
                    }
                )
            },
            bottomContent = {
                BaseTextItem {
                    Text(text = "花筏科技 版权所有", modifier = Modifier.padding(bottom = 8.dp))
                    RightsTextItem(dateText = "2017-2022", name = "Sakuraft")
                }
            }
        )
    }
}

@Composable
fun AboutLibPager() {
    val developerList = remember {
        listOf(
            NormalSubItemWithStartIconData("developer1", subText = "developer description", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("developer2", subText = "developer description", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("developer3", subText = "developer description", startIcon = boxSampleIcon),
        )
    }

    val otherWorkList = remember {
        listOf(
            NormalSubItemWithStartIconData("Work1", subText = "Work description", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("Work2", subText = "Work description", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("Work3", subText = "Work description", startIcon = boxSampleIcon),
        )
    }

    val contributorList = remember {
        listOf(
            NormalSubItemWithStartIconData("contributorList", subText = "contributorList description", startIcon = boxSampleIcon)
        )
    }

    val openSourceList = remember {
        listOf(
            NormalSubItemWithStartIconData("openSource", subText = "openSource description", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("openSource", subText = "openSource description", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("openSource", subText = "openSource description", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("openSource", subText = "openSource description", startIcon = boxSampleIcon),
            NormalSubItemWithStartIconData("openSource", subText = "openSource description", startIcon = boxSampleIcon),
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
                    modifier = Modifier.padding(bottom = 32.dp, top=16.dp)
                )
            },
            mainContent = {
                NormalSubItemModule(
                    itemList = listOf(),
                    title = "What's this",
                    backGroundColor = Color.White,
                    extraContent = {
                        Text(text = "这是一些关于应用的描述")
                    }
                )

                NormalWithStartIconSubItemModule(
                    itemList = developerList,
                    title = "Developers",
                    backGroundColor = Color.White,
                    showDivider = false
                )

                NormalWithStartIconSubItemModule(
                    itemList = otherWorkList,
                    title = "Other Works",
                    backGroundColor = Color.White,
                    showDivider = false
                )

                NormalWithStartIconSubItemModule(
                    itemList = contributorList,
                    title = "Contribution",
                    backGroundColor = Color.White,
                    showDivider = false
                )

                NormalSubItemModule(
                    itemList = listOf(),
                    title = "Acknowledgement",
                    backGroundColor = Color.White,
                    extraContent = {
                        Text(text = "这是一些关于版权的描述：\n第二行\n第三行\n等等")
                    }
                )

                NormalSubItemModule(
                    itemList = listOf(),
                    title = "Declaration",
                    backGroundColor = Color.White,
                    extraContent = {
                        Text(text = "这是一些声明")
                    }
                )

                NormalWithStartIconSubItemModule(
                    itemList = openSourceList,
                    title = "Open Source Licenses",
                    backGroundColor = Color.White
                )
            }
        )
    }
}

@Composable
fun AboutVspPager() {
    Text(text = "这个没啥特殊的样式，不仿了！\n(〃￣︶￣)人(￣︶￣〃)")
}

val endArrow = @Composable {
    Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "arrow")
}

val boxSampleIcon = @Composable {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Icon(imageVector = Icons.Outlined.Star, contentDescription = "star")
    }
}


@Preview()
@Composable
fun PreviewDemo() {
    Column(modifier = Modifier.fillMaxSize()) {
        AboutLibPager()
    }
}