package uz.gita.testcleanafb6.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import uz.gita.testcleanafb6.data.network.api.AuthApi
import uz.gita.testcleanafb6.data.network.api.ContactApi
import javax.inject.Singleton

const val BASE_URL = "https://f8c8-195-158-16-140.ngrok.io"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @[Singleton Provides]
    fun provideContactApi(retrofit: Retrofit): ContactApi = retrofit.create()

    @[Singleton Provides]
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create()

    @[Singleton Provides]
    fun provideClient(@ApplicationContext context: Context): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(ChuckerInterceptor.Builder(context).build()).build()

}