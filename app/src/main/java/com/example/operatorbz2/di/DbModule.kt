package com.example.operatorbz2.di

import android.content.Context
import androidx.room.Room
import com.example.operatorbz2.data.db.MainDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DbModule {
    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): MainDb {
        return Room.databaseBuilder(context, MainDb::class.java, "taskDb.db")
            .build()
    }
}