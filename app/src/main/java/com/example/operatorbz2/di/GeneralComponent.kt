package com.example.operatorbz2.di

import com.example.operatorbz2.ui.theme.viewmodels.GeneralViewModel
import dagger.Subcomponent

@Subcomponent
interface GeneralComponent {

    fun viewModel(): GeneralViewModel

}