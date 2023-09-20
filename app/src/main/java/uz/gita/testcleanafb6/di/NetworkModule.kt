package uz.gita.testcleanafb6.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import uz.gita.testcleanafb6.data.network.api.AuthApi
import uz.gita.testcleanafb6.data.network.api.ContactApi

const val BASE_URL = "https://b4cc-195-158-16-140.ngrok.io"
val networkModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<ContactApi> {
        val retrofit: Retrofit = get()
        retrofit.create()
    }
    single<AuthApi>{
        val retrofit: Retrofit = get()
        retrofit.create()
    }
}