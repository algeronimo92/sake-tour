package com.alangeronimo.saketour.di

import com.alangeronimo.saketour.data.repository.SakeShopRepositoryImpl
import com.alangeronimo.saketour.domain.repository.SakeShopRepository
import com.alangeronimo.saketour.domain.useCase.GetSakeShopsUseCase
import com.alangeronimo.saketour.network.SakeShopApi
import com.alangeronimo.saketour.presentation.viewmodel.SakeShopViewModel
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://mybackend.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<SakeShopApi> { get<Retrofit>().create(SakeShopApi::class.java) }
}

val dataModule = module {
    single { Gson() }
    single<SakeShopRepository> {
        SakeShopRepositoryImpl(
            api = get(),
            context = androidContext(),
            gson = get()
        )
    }
}

val domainModule = module {
    factory { GetSakeShopsUseCase(get()) }
}

val presentationModule = module {
    viewModel { SakeShopViewModel(get()) }
}
