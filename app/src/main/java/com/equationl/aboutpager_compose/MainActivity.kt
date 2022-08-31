package com.equationl.aboutpager_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.equationl.aboutpager_compose.about_pager.sample.*
import com.equationl.aboutpager_compose.ui.theme.AboutPagercomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = MyViewModel()

        setContent {
            HomeView(viewModel)
        }
    }
}

@Composable
fun HomeView(viewModel: MyViewModel) {
    AboutPagercomposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            MaterialTheme {
                Scaffold(
                    topBar = {
                        TopAppBar (
                            title = {
                                Text(text = "About pager Demo", maxLines = 1, overflow = TextOverflow.Ellipsis)
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    viewModel.pagerIndex = 0
                                }) {
                                    Icon(Icons.Outlined.ArrowBack, "返回")
                                }
                            },
                        )
                    }
                ) {
                    Column(Modifier.fillMaxSize().padding(it)) {
                        when (viewModel.pagerIndex) {
                            0 -> HomeScreen(viewModel)
                            1 -> AboutChengPager()
                            2 -> AboutWechatPager()
                            3 -> AboutQqPager()
                            4 -> AboutBoxPager()
                            5 -> AboutLibPager()
                            6 -> AboutVspPager()
                        }
                    }
                }
            }
        }
    }
}

class MyViewModel: ViewModel() {
    var pagerIndex by  mutableStateOf(0)
}


@Preview
@Composable
fun PreviewHomeView() {
    HomeView(viewModel = MyViewModel())
}