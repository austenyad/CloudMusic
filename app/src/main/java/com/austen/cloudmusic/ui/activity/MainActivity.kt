package com.austen.cloudmusic.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout
import com.austen.cloudmusic.ui.common.HomeTopHeader
import com.austen.cloudmusic.ui.home.BottomNavigationBar
import com.austen.cloudmusic.ui.home.items
import com.austen.cloudmusic.ui.theme.CloudMusicTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloudMusicTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun Greeting(name: String) {

    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(items = items,
                selected = pagerState.currentPage,
                selectedChange = {
                    scope.launch {
                        pagerState.scrollToPage(it)
                    }
                })
        }

    ) {

        HorizontalPager(count = items.size, state = pagerState)
        { page ->
            // ...page content
            when (page) {
                0 -> PageDiscovery()
                else -> {
                    Text(
                        text = "Page: $page",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(color = Color((0xFFFFFFFF * (page / items.size.toFloat())).toInt()))
                    )
                }
            }

        }


    }
}

@Composable
fun PageDiscovery() {
    Scaffold(

        topBar = {
            HomeTopHeader()
        },
    ) {

    }

}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CloudMusicTheme {
        Greeting("Android")
    }
}