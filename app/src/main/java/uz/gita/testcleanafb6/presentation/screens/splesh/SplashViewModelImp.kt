package uz.gita.testcleanafb6.presentation.screens.splesh

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.testcleanafb6.data.local.pref.MySharedPref
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImp @Inject constructor(pref: MySharedPref, direction: SplashDirection) :
    SplashViewModel, ViewModel() {

    init {
        viewModelScope.launch {
            delay(2000)
            if (pref.getToken().isNotEmpty())
                direction.moveToMainScreen()
            else direction.moveToLoginScreen()
        }
    }

}