package com.example.operatorbz2.di

import com.example.operatorbz2.ui.viewmodels.TextViewModel
import dagger.Subcomponent

@Subcomponent
interface TextComponent {

    fun viewModel(): TextViewModel

}