package com.austen.cloudmusic.http.api

import com.austen.cloudmusic.data.model.BaseResp
import com.austen.cloudmusic.data.model.RespNoData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/12/30-01:03
 * ================================================
 */
interface LoginApiService {


    @FormUrlEncoded
    @POST("/login/cellphone?realIP=116.25.146.177")
    suspend fun mobileLogin(
        @Field("phone") phone: String,
        @Field("password") password: String,
    ): BaseResp<RespNoData>

}