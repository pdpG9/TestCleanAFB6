package uz.gita.testcleanafb6.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import uz.gita.testcleanafb6.di.localModule
import uz.gita.testcleanafb6.di.navigationModule
import uz.gita.testcleanafb6.di.networkModule
import uz.gita.testcleanafb6.di.viewModelModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(localModule,
                networkModule,
                viewModelModule,
                navigationModule))
        }
        ///
//        asd
//        as
//                d
//        as
//                d
//        asda
    }
}