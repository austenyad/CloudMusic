package com.austen.cloudmusic.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.austen.cloudmusic.R

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/10/10-20:09
 * ================================================
 */
sealed class DataHomeBottomItem(
    val route: String,
    @StringRes val resStrId: Int,
    @DrawableRes val resDrawableNormalId: Int,
    @DrawableRes val resDrawableSelectedId: Int
) {
    object HomeBottomDiscovery : DataHomeBottomItem(
        "home_bottom_discovery",
        R.string.home_bottom_discovery,
        R.drawable.home_ic_navi_one_noraml,
        R.drawable.home_ic_navi_one_selected
    )

    object HomeBottomBroadcast : DataHomeBottomItem(
        "home_bottom_broadcast",
        R.string.home_bottom_broadcast,
        R.drawable.home_ic_navi_one_noraml,
        R.drawable.home_ic_navi_one_selected
    )

    object HomeBottomMine : DataHomeBottomItem(
        "home_bottom_item_mine",
        R.string.home_bottom_item_mine,
        R.drawable.home_ic_navi_one_noraml,
        R.drawable.home_ic_navi_one_selected
    )

    object HomeBottomFollow : DataHomeBottomItem(
        "home_bottom_item_follow",
        R.string.home_bottom_item_follow,
        R.drawable.home_ic_navi_one_noraml,
        R.drawable.home_ic_navi_one_selected
    )

    object HomeBottomCloudVillage : DataHomeBottomItem(
        "home_bottom_item_cloud_village",
        R.string.home_bottom_item_cloud_village,
        R.drawable.home_ic_navi_one_noraml,
        R.drawable.home_ic_navi_one_selected
    )
}