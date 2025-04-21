package com.example.operatorbz2.di

import com.example.operatorbz2.ui.viewmodels.NewNoteViewModel
import dagger.Subcomponent


@Subcomponent
interface NewNoteComponent {
    fun viewModel(): NewNoteViewModel
}