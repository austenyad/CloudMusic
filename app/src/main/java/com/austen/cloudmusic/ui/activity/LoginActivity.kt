package com.austen.cloudmusic.ui.activity

import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.austen.cloudmusic.databinding.ActivityLoginBinding
import com.austen.cloudmusic.ui.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/12/30-00:27
 * ================================================
 */
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener {

            viewModel.mobileLogin(
                binding.etPhone.content(),
                binding.etPassword.content()
            )
        }
    }
}

private fun EditText.content(): String {
    return this.toString().trim()
}
