package com.example.marketplace.core.di

import com.example.marketplace.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {LoginViewModel(get())}
}