package uz.gita.testcleanafb6.presentation.screens.home

import android.view.WindowInsets.Side
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HomeViewModel @Inject constructor():HomeContract.ViewModel,ViewModel() {
    override val uiState = MutableStateFlow<HomeContract.UiState>(HomeContract.UiState())

    override val sideEffect = MutableStateFlow<HomeContract.SideEffect>(HomeContract.SideEffect.Init)

    override fun onEventDispatcher(intent: HomeContract.Intent) {

    }
}