package com.alangeronimo.data.di

import com.alangeronimo.data.common.AndroidLogger
import com.alangeronimo.data.common.MyLogger
import com.alangeronimo.data.network.SakeShopApi
import com.alangeronimo.domain.repository.SakeShopRepository
import com.google.gson.Gson
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule =
    module {

        single {
            Retrofit.Builder()
                .baseUrl("https://mybackend.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single<SakeShopApi> { get<Retrofit>().create(SakeShopApi::class.java) }

        single { Gson() }

        single<MyLogger> { AndroidLogger() }

        single<SakeShopRepository> {
            com.alangeronimo.data.repository.SakeShopRepositoryImpl(
                api = get(),
                context = get(),
                gson = get(),
                logger = get(),
            )
        }
    }
