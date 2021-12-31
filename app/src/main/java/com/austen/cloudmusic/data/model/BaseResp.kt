package com.austen.cloudmusic.data.model

import com.google.gson.annotations.SerializedName

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/12/30-01:15
 * ================================================
 */
data class BaseResp<T>(
    @SerializedName("msg") val status: Int,
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: T,
) {
    fun isOk() = code == 200
}

