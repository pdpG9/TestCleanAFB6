package uz.gita.testcleanafb6.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.gita.testcleanafb6.data.local.pref.MySharedPref
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val direction: HomeDirection,
    private val pref: MySharedPref
) : HomeContract.ViewModel, ViewModel() {
    override val uiState = MutableStateFlow<HomeContract.UiState>(HomeContract.UiState())

    override val sideEffect =
        MutableStateFlow<HomeContract.SideEffect>(HomeContract.SideEffect.Init)

    override fun onEventDispatcher(intent: HomeContract.Intent) {
        when (intent) {
            HomeContract.Intent.LogOut -> {
                viewModelScope.launch {
                    pref.clearData()
                    direction.logout()
                }
            }
        }

    }
}