package com.example.operatorbz2.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        DbModule::class
    ]
)
interface AppComponent {

    fun generalComponent(): GeneralComponent

    fun textComponent(): TextComponent

    fun newNoteComponent(): NewNoteComponent

    fun noteComponent(): NoteComponent

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}