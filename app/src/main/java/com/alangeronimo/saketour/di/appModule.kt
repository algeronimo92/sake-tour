package com.alangeronimo.saketour.di

import com.alangeronimo.saketour.presentation.viewmodel.SakeShopViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { SakeShopViewModel(get()) }
}
