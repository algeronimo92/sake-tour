package com.alangeronimo.domain.di

import com.alangeronimo.domain.useCase.GetSakeShopsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetSakeShopsUseCase(get()) }
}