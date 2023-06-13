package com.example.marketplace.ui.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.marketplace.core.data.source.remote.request.LoginRequest
import com.inyongtisto.marketplace.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {

    private val viewModel : LoginViewModel by viewModel()

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("RESPON", "PESAN SINGKAT")

        setData()
    }

    fun setData(){
        viewModel.text.observe(this, {
            binding.edtEmail.setText(it)
        })

        binding.btnMasuk.setOnClickListener{

            val body = LoginRequest(
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString())

            viewModel.login(body).observe(this, {

            })
        }
    }
}