package com.austen.cloudmusic.data.repository

import com.austen.cloudmusic.data.model.BaseResp
import com.austen.cloudmusic.data.model.RespNoData
import com.austen.cloudmusic.http.api.LoginApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/12/30-01:23
 * ================================================
 */
@Singleton
class LoginRepository @Inject constructor(private val loginApiService: LoginApiService) {

    suspend fun mobileLogin(phone: String, password: String): BaseResp<RespNoData> {
        return withContext(Dispatchers.IO) {
            loginApiService.mobileLogin(phone, password)
        }

    }


}