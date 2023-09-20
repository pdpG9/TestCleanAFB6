package uz.gita.testcleanafb6.di

import org.koin.dsl.module
import uz.gita.testcleanafb6.data.local.pref.MySharedPref
import uz.gita.testcleanafb6.data.local.pref.MySharedPrefImpl

val localModule = module {
    single<MySharedPref>{
        MySharedPrefImpl(context = get())
    }
}