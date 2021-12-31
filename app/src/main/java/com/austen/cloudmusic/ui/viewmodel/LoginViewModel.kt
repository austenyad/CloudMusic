package com.austen.cloudmusic.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.austen.cloudmusic.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/12/30-01:22
 * ================================================
 */
@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {

    fun mobileLogin(phone: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val mobileLogin = loginRepository.mobileLogin(phone, password)
            Log.e("austenYang", "$mobileLogin")

        }
    }
}