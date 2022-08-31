package com.equationl.aboutpager_compose.about_pager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * AboutPager 的主入口，所有的子模块都应该放置于其中
 *
 * @param modifier
 * @param topContent
 * @param mainContent
 * @param bottomContent
 * @param keepBottomInBottom 是否固定底部控件始终在底部，设置为 true 可能出现内容叠加
 * */
@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    topContent: (@Composable () -> Unit)? = null,
    mainContent: (@Composable () -> Unit)? = null,
    bottomContent: (@Composable () -> Unit)? = null,
    keepBottomInBottom: Boolean = false
) {
    Box {
        Column(modifier = modifier.verticalScroll(rememberScrollState())) {
            if (topContent != null) {
                topContent()
            }
            if (mainContent != null) {
                mainContent()
            }
            if (bottomContent != null && !keepBottomInBottom) {
                bottomContent()
            }
        }

        if (bottomContent != null && keepBottomInBottom) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                bottomContent()
            }
        }
    }
}