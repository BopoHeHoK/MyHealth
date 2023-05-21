package com.test.myhealth.app.presentation.screen.tab.profile.menu.get_premium

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GetPremiumViewModelFactory(
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GetPremiumViewModel(
        ) as T
    }
}