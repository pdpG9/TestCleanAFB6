package uz.gita.testcleanafb6.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.testcleanafb6.data.local.pref.MySharedPref
import uz.gita.testcleanafb6.data.local.pref.MySharedPrefImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LocalModule {
    @[Binds Singleton]
    fun bindSharedPref(impl: MySharedPrefImpl):MySharedPref
}