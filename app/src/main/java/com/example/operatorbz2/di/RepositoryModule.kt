package com.example.operatorbz2.di

import com.example.operatorbz2.data.RepositoryImpl
import com.example.operatorbz2.domain.Repository
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    fun provideRepository(impl: RepositoryImpl): Repository = impl

}