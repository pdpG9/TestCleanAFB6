package uz.gita.testcleanafb6.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import uz.gita.testcleanafb6.data.network.api.AuthApi
import uz.gita.testcleanafb6.data.network.api.ContactApi
import javax.inject.Singleton

const val BASE_URL = "https://b4cc-195-158-16-140.ngrok.io"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun provideRetrofit():Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @[Singleton Provides]
    fun provideContactApi(retrofit:Retrofit):ContactApi = retrofit.create()
    @[Singleton Provides]
    fun provideAuthApi(retrofit:Retrofit):AuthApi = retrofit.create()

}