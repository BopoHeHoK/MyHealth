package com.test.myhealth.app.presentation.screen.root

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RootViewModelFactory(
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RootViewModel(
        ) as T
    }
}