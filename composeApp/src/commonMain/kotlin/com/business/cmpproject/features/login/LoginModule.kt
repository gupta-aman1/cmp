package com.business.cmpproject.features.login


import org.koin.dsl.module

val LoginModule = module {
    single { LoginApi(get()) }
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    factory { LoginViewModel(get()) }
}
