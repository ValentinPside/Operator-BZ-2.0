package com.example.operatorbz2.di

import com.example.operatorbz2.ui.viewmodels.NoteViewModel
import dagger.Subcomponent

@Subcomponent
interface NoteComponent {
    fun viewModel(): NoteViewModel
}