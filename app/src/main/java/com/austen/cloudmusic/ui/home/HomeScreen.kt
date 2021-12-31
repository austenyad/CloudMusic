package com.austen.cloudmusic.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.austen.cloudmusic.R

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/9/29-22:26
 * ================================================
 */
data class DataBottomNavigationItem(
    val itemPosition: Int,
    val selectedIconRes: List<Int>,
    val itemName: String
)

val items = listOf(
    DataBottomNavigationItem(
        0,
        listOf(R.drawable.home_ic_navi_one_noraml, R.drawable.home_ic_navi_one_selected),
        "发现",

        ), DataBottomNavigationItem(
        1,
        listOf(R.drawable.home_ic_navi_one_noraml, R.drawable.home_ic_navi_one_selected),
        "播客",

        ), DataBottomNavigationItem(
        2,
        listOf(R.drawable.home_ic_navi_one_noraml, R.drawable.home_ic_navi_one_selected),
        "我的"
    ), DataBottomNavigationItem(
        3,
        listOf(R.drawable.home_ic_navi_one_noraml, R.drawable.home_ic_navi_one_selected),
        "关注",

        ),
    DataBottomNavigationItem(
        4,
        listOf(R.drawable.home_ic_navi_one_noraml, R.drawable.home_ic_navi_one_selected),
        "云村",

        )
)

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun PreviewBottomNavigationBar() {
    val selected = remember {
        mutableStateOf(0)
    }
    BottomNavigationBar(items, selected.value, selectedChange = { selected.value = it })
}

@Preview
@Composable
fun PreviewBottomNavigationItem() {
    BottomNavigationItem(
        DataBottomNavigationItem(
            0,
            listOf(R.drawable.home_ic_navi_one_noraml, R.drawable.home_ic_navi_one_selected),
            "发现",

            ),
        true
    ) {

    }
}

@Composable
fun BottomNavigationItem(
    item: DataBottomNavigationItem,
    isSelected: Boolean,
    onItemClick: (Int) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val selectColor = if (isSelected) Color.Red else Color.White
    val selectIcon = if (isSelected) item.selectedIconRes[1] else item.selectedIconRes[0]
    val selectTextColor = if (isSelected) Color.Red else Color.Gray


    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier =
    Modifier.clickable(
        interactionSource = interactionSource,
        indication = null
    ) {
        onItemClick(item.itemPosition)
    }) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(
                    brush =
                    linearGradient(
                        colors = listOf(Color.White, selectColor),
                        start = Offset(0.0F, 0.0F),
                        end = Offset(0.0F, 100.0F)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = selectIcon),
                contentDescription = "discovery",
                modifier = Modifier.size(28.dp)
            )
        }

        Text(text = item.itemName, fontSize = 12.sp, color = selectTextColor)
    }
}

@Composable
fun BottomNavigationBar(
    items: List<DataBottomNavigationItem>,
    selected: Int,
    selectedChange: (Int) -> Unit
) {

    val navController = rememberNavController()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items.forEach {
            BottomNavigationItem(it, selected == it.itemPosition, selectedChange)
        }
    }
}




